package com.project.LayOutService.service;

import com.project.LayOutService.domain.Card;
import com.project.LayOutService.domain.Pillar;
import com.project.LayOutService.domain.WorkSpace;
import com.project.LayOutService.exception.CardAlreadyExistsException;
import com.project.LayOutService.exception.CardNotFoundException;
import com.project.LayOutService.exception.PillarNotFoundException;
import com.project.LayOutService.exception.WorkSpaceNotFoundException;

public interface CardService {
    WorkSpace addCard(String workSpaceName, String pillarName , Card card) throws CardAlreadyExistsException, PillarNotFoundException, WorkSpaceNotFoundException;
    WorkSpace updateCard(String workSpaceName, String pillarName , Card card, String cardId) throws CardNotFoundException, PillarNotFoundException, WorkSpaceNotFoundException;
    WorkSpace removeCard(String workSpaceName, String pillarName, String cardId) throws CardNotFoundException, PillarNotFoundException, WorkSpaceNotFoundException;
}
