package com.project.LayOutService.service;

import com.project.LayOutService.domain.Card;
import com.project.LayOutService.domain.Pillar;
import com.project.LayOutService.domain.WorkSpace;
import com.project.LayOutService.exception.CardAlreadyExistsException;
import com.project.LayOutService.exception.CardNotFoundException;
import com.project.LayOutService.exception.PillarNotFoundException;
import com.project.LayOutService.exception.WorkSpaceNotFoundException;
import com.project.LayOutService.repository.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService {
    private WorkSpaceRepository workSpaceRepository;


    @Autowired
    public CardServiceImpl(WorkSpaceRepository workSpaceRepository) {
        this.workSpaceRepository = workSpaceRepository;

    }

    @Override
    public WorkSpace addCard(String workSpaceName, String pillarName, Card card) throws CardAlreadyExistsException, PillarNotFoundException, WorkSpaceNotFoundException {
        if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
            throw new WorkSpaceNotFoundException();
        }
        WorkSpace workSpace = workSpaceRepository.findById(workSpaceName).get(); // workspace
        System.out.println(workSpace);
        List<Pillar> pillars = workSpace.getPillars(); // listofpillars
        System.out.println(pillars);
        if (!pillars.stream().anyMatch(p -> pillarName.equalsIgnoreCase(p.getPillarName()))) //check pillar is present or not
        {
            System.out.println("first if statement");
            throw new PillarNotFoundException();
        } else {

            System.out.println("first else statement");
            for (int i = 0; i < pillars.size(); i++) {
                System.out.println("ïnside for");
                if (pillars.get(i).getPillarName().equalsIgnoreCase(pillarName)) {
                    System.out.println("ïnside for if found pillar");
                    if (pillars.get(i).getCards() == null) {
                        System.out.println("check if getcard is empty");
                        List<Card> mycard = List.of(card);
                        System.out.println(mycard);
                        pillars.get(i).setCards(mycard);
                        System.out.println(pillars.get(i).getPillarName());
                        System.out.println(pillars.get(i).getCards());
                    } else {
                        System.out.println("check if card is not empty");
                        List<Card> cards = pillars.get(i).getCards();
                        cards.add(card);
                        System.out.println(cards);
                        pillars.get(i).setCards(cards);
                        System.out.println(pillars);

                    }
                }
            }
            workSpace.setPillars(pillars);

//            System.out.println("saving to database");
            return workSpaceRepository.save(workSpace);
        }
    }

    @Override
    public WorkSpace updateCard(String workSpaceName, String pillarName, Card card, String cardId) throws CardNotFoundException, PillarNotFoundException, WorkSpaceNotFoundException {

        if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
            throw new WorkSpaceNotFoundException();
        }
//        Pillar pillar = pillarRepository.findById(pillarName).get();
//        List<Card> cards1 = pillar.getCards();
//        cards1.add(card);
//        pillar.setCards(cards1);
//        WorkSpace workSpace = workSpaceRepository.findById(workSpaceName).get();
//        List<Pillar> pillars = workSpace.getPillars();
//        pillars.add(pillar);
//        workSpace.setPillars(pillars);
        return null;
    }

    @Override
    public WorkSpace removeCard(String workSpaceName, String pillarName, String cardId) throws CardNotFoundException, PillarNotFoundException, WorkSpaceNotFoundException {
        boolean flag = false;
        WorkSpace workSpace = workSpaceRepository.findById(workSpaceName).get();
        if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
            throw new WorkSpaceNotFoundException();
        }
        else {
            if (!workSpace.getPillars().stream().anyMatch(p -> pillarName.equalsIgnoreCase(p.getPillarName()))) {
                throw new PillarNotFoundException();
            } else {
               List<Pillar> pillar = workSpace.getPillars().stream().filter(p -> pillarName.equalsIgnoreCase(p.getPillarName())).collect(Collectors.toList());
                if (!pillar.get(0).getCards().stream().anyMatch(c -> cardId.equalsIgnoreCase(c.getCardId()))) {
                    throw new CardNotFoundException();
                } else {
                    List<Pillar> pillars = workSpace.getPillars();
                    for (int i = 0; i < pillars.size(); i++) {
                        if (pillars.get(i).getPillarName().equalsIgnoreCase(pillarName)) {
                            List<Card> cardList = pillars.get(i).getCards();
                            cardList.removeIf(x -> x.getCardId().equalsIgnoreCase(cardId));
                            pillars.get(i).setCards(cardList);
                        }
                    }
                    workSpace.setPillars(pillars);
                }
            }
        }
        return workSpace;
    }

}
