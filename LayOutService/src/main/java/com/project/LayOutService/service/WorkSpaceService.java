package com.project.LayOutService.service;

import com.project.LayOutService.domain.WorkSpace;
import com.project.LayOutService.exception.*;

<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> 700d41520eb1a769e20c64eda50092463e27999c
import java.util.Optional;

public interface WorkSpaceService {

<<<<<<< HEAD
	WorkSpace addWorkSpace(WorkSpace workSpace);
	boolean removeWorkSpace(String workSpaceName) throws WorkSpaceNotFoundException;
	List<WorkSpace> getWorkSpace() throws WorkSpaceNotFoundException;
=======
	WorkSpace addWorkSpace(WorkSpace workSpace) throws WorkSpaceAlreadyExistsException;
	boolean removeWorkSpace(String workSpaceName) throws WorkSpaceNotFoundException;
	Optional<WorkSpace> getWorkSpaceByName(String workSpaceName) throws WorkSpaceNotFoundException;
>>>>>>> 700d41520eb1a769e20c64eda50092463e27999c

}