package com.project.LayOutService.service;

import com.project.LayOutService.exception.*;
import com.project.LayOutService.repository.WorkSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.LayOutService.domain.WorkSpace;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 700d41520eb1a769e20c64eda50092463e27999c
import java.util.Optional;

@Service
public class WorkSpaceServiceImpl implements WorkSpaceService {
	private WorkSpaceRepository workSpaceRepository;


	@Autowired
	public WorkSpaceServiceImpl(WorkSpaceRepository workSpaceRepository) {this.workSpaceRepository = workSpaceRepository;
	}

	@Override
	public WorkSpace addWorkSpace(WorkSpace workSpace) {
		// TODO Auto-generated method stub
<<<<<<< HEAD
//		if (workSpaceRepository.findById(workSpace.getWorkSpaceName()).isPresent()) {
//			throw new WorkSpaceAlreadyExistsException();
//		}
=======
		if (workSpaceRepository.findById(workSpace.getWorkSpaceName()).isPresent()) {
			throw new WorkSpaceAlreadyExistsException();
		}
>>>>>>> 700d41520eb1a769e20c64eda50092463e27999c
		return workSpaceRepository.save(workSpace);
	}

	@Override
	public boolean removeWorkSpace(String workSpaceName) throws WorkSpaceNotFoundException {
		// TODO Auto-generated method stub
		boolean flag = false;
		if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
			throw new WorkSpaceNotFoundException();
		} else {
			workSpaceRepository.deleteById(workSpaceName);
			flag = true;
		}
		return flag;
	}

	@Override
<<<<<<< HEAD
	public List<WorkSpace> getWorkSpace() throws WorkSpaceNotFoundException {
//		if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
//			throw new WorkSpaceNotFoundException();
//		}
		return workSpaceRepository.findAll();
=======
	public Optional<WorkSpace> getWorkSpaceByName(String workSpaceName) throws WorkSpaceNotFoundException {
		if (workSpaceRepository.findById(workSpaceName).isEmpty()) {
			throw new WorkSpaceNotFoundException();
		}
		return workSpaceRepository.findById(workSpaceName);
>>>>>>> 700d41520eb1a769e20c64eda50092463e27999c
	}


}