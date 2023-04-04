package com.project.LayOutService.service;

import com.project.LayOutService.domain.Pillar;
import com.project.LayOutService.domain.WorkSpace;
import com.project.LayOutService.exception.PillarAlreadyExistsException;
import com.project.LayOutService.exception.PillarNotFoundException;
import com.project.LayOutService.exception.WorkSpaceNotFoundException;

import java.util.List;

public interface PillarService {
    WorkSpace addPillar(Pillar pillar, String workSpaceName) throws PillarAlreadyExistsException, WorkSpaceNotFoundException;
    WorkSpace removePillar(String workSpaceName,String pillarName) throws PillarNotFoundException, WorkSpaceNotFoundException;
    public List<Pillar> showAllPillar(String workspaceName) throws  WorkSpaceNotFoundException;
}
