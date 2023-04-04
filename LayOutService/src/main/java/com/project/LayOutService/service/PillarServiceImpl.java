package com.project.LayOutService.service;

import com.project.LayOutService.domain.Pillar;
import com.project.LayOutService.domain.WorkSpace;
import com.project.LayOutService.exception.PillarAlreadyExistsException;
import com.project.LayOutService.exception.PillarNotFoundException;
import com.project.LayOutService.exception.WorkSpaceNotFoundException;
import com.project.LayOutService.repository.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PillarServiceImpl implements PillarService {
    private WorkSpaceRepository workSpaceRepository;


    @Autowired
    public PillarServiceImpl(WorkSpaceRepository workSpaceRepository) {
        this.workSpaceRepository = workSpaceRepository;
    }


    @Override
    public WorkSpace addPillar(Pillar pillar, String workSpaceName) throws PillarAlreadyExistsException, WorkSpaceNotFoundException {

        WorkSpace workSpace = workSpaceRepository.findById(workSpaceName).get();
        List<Pillar> pillars = new ArrayList<>();
        pillars.add(pillar);
        List<Pillar> pillarList = workSpace.getPillars();
        if (pillarList.stream().anyMatch(p -> pillars.get(0).getPillarName().equalsIgnoreCase(p.getPillarName()))) {
            throw new PillarAlreadyExistsException();
        } else {
            if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
                throw new WorkSpaceNotFoundException();
            } else {
                if (pillarList.isEmpty()) {
                    workSpace.setPillars(List.of(pillar));
                } else {

                    pillarList.add(pillar);
                    workSpace.setPillars(pillarList);
                    System.out.println(" Workspace with added new board");
                    System.out.println(workSpace);
                }
            }
        }
        return workSpaceRepository.save(workSpace);
    }

    @Override
    public WorkSpace removePillar(String workSpaceName, String pillarName) throws PillarNotFoundException, WorkSpaceNotFoundException {
        WorkSpace workSpace = workSpaceRepository.findById(workSpaceName).get();
        if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
            throw new WorkSpaceNotFoundException();
        } else {

            List<Pillar> pillars = workSpace.getPillars();
            if(!pillars.stream().anyMatch(p -> pillarName.equalsIgnoreCase(p.getPillarName())))
            {
                throw new PillarNotFoundException();
            }
            else {
                pillars.removeIf(p -> pillars.get(0).getPillarName().equalsIgnoreCase(p.getPillarName()));
                System.out.println(pillars);
                workSpace.setPillars(pillars);
            }
        }

        return workSpaceRepository.save(workSpace);
    }

    @Override
    public List<Pillar> showAllPillar(String workSpaceName) throws  WorkSpaceNotFoundException {

        WorkSpace workSpace = null;
        if (workSpaceRepository.findById(workSpaceName).isEmpty())
        {
            throw new WorkSpaceNotFoundException();
        }
        else {
             workSpace = workSpaceRepository.findById(workSpaceName).get();
        }
        return workSpace.getPillars();
    }

}