package com.project.LayOutService.controller;

import com.project.LayOutService.domain.Card;
import com.project.LayOutService.exception.CardAlreadyExistsException;
import com.project.LayOutService.exception.CardNotFoundException;
import com.project.LayOutService.exception.PillarNotFoundException;
import com.project.LayOutService.exception.WorkSpaceNotFoundException;
import com.project.LayOutService.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card/")
@CrossOrigin(origins = "http://localhost:4200")
public class CardController {
    private CardService cardService;
    private ResponseEntity responseEntity;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("add/{workSpaceName}/{pillarName}")
    public ResponseEntity<?> addCard(@PathVariable String workSpaceName, @PathVariable String pillarName, @RequestBody Card card) throws CardAlreadyExistsException, PillarNotFoundException, WorkSpaceNotFoundException {
        try {
            responseEntity = new ResponseEntity( cardService.addCard(workSpaceName, pillarName, card), HttpStatus.OK);
        }
        catch (CardAlreadyExistsException e) {
            responseEntity=new ResponseEntity<>("Card Already Exists",HttpStatus.CONFLICT);
        }
        catch (PillarNotFoundException e) {
            responseEntity=new ResponseEntity<>("Pillar Not Found ",HttpStatus.NOT_FOUND);
        }
        catch (WorkSpaceNotFoundException e) {
            responseEntity=new ResponseEntity<>("WorkSpace Not Found",HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            responseEntity=new ResponseEntity<>("Error !!!! Try  after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("update/{workSpaceName}/{pillarName}/{cardId}")
    public ResponseEntity<?> updateCard(@PathVariable String workSpaceName, @PathVariable String pillarName, @RequestBody Card card, @PathVariable String cardId) throws CardNotFoundException, PillarNotFoundException, WorkSpaceNotFoundException {
        try {
            responseEntity = new ResponseEntity(cardService.updateCard(workSpaceName, pillarName, card, cardId), HttpStatus.OK);
        }
        catch (CardNotFoundException | PillarNotFoundException | WorkSpaceNotFoundException e) {
            throw new CardNotFoundException();
        }
        return responseEntity;
    }

    @DeleteMapping("remove/{workSpaceName}/{pillarName}/{cardId}")
    public ResponseEntity<?> removeCard(@PathVariable String workSpaceName, @PathVariable String pillarName, @PathVariable String cardId) throws CardNotFoundException, PillarNotFoundException, WorkSpaceNotFoundException {
        try {
            responseEntity = new ResponseEntity(cardService.removeCard(workSpaceName, pillarName, cardId), HttpStatus.OK);
        }
        catch (CardNotFoundException e) {
            throw new CardNotFoundException();
        }
        catch(PillarNotFoundException e)
        {
            throw new PillarNotFoundException();
        }
        catch(WorkSpaceNotFoundException e)
        {
            throw new WorkSpaceNotFoundException();
        }
        catch (Exception e) {
            responseEntity=new ResponseEntity<>("Error !!!! Try  after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
