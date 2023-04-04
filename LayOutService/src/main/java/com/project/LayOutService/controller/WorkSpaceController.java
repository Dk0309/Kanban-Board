package com.project.LayOutService.controller;

import com.project.LayOutService.domain.WorkSpace;
import com.project.LayOutService.exception.WorkSpaceAlreadyExistsException;
import com.project.LayOutService.exception.WorkSpaceNotFoundException;
import com.project.LayOutService.service.WorkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class WorkSpaceController {
    private ResponseEntity responseEntity;
    private WorkSpaceService workSpaceService;

    @Autowired
    public WorkSpaceController(WorkSpaceService workSpaceService) {this.workSpaceService = workSpaceService;}

    @PutMapping("update/workSpace")
    public ResponseEntity<?> addWorkSpace(@RequestBody WorkSpace workSpace){
        try{
            responseEntity = new ResponseEntity(workSpaceService.addWorkSpace(workSpace), HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error !!!! Try  after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }

    @DeleteMapping("api/workSpace/{workSpaceName}")
    public ResponseEntity<?> removeWorkSpace(@PathVariable String workSpaceName) throws WorkSpaceNotFoundException {
        try{
            responseEntity = new ResponseEntity(workSpaceService.removeWorkSpace(workSpaceName), HttpStatus.OK);
        }
        catch (WorkSpaceNotFoundException e) {
            throw new WorkSpaceNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error !!!! Try  after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

<<<<<<< HEAD
    @GetMapping("api/workSpace")
    public ResponseEntity<?> getWorkSpace() throws WorkSpaceNotFoundException {
        try{
            responseEntity = new ResponseEntity(workSpaceService.getWorkSpace(), HttpStatus.OK);
=======
    @GetMapping("api/workSpace/{workspaceName}")
    public ResponseEntity<?> getWorkSpaceByName(@PathVariable String workSpaceName) throws WorkSpaceNotFoundException {
        try{
            responseEntity = new ResponseEntity(workSpaceService.getWorkSpaceByName(workSpaceName), HttpStatus.OK);
>>>>>>> 700d41520eb1a769e20c64eda50092463e27999c
        }
        catch (WorkSpaceNotFoundException e) {
            throw new WorkSpaceNotFoundException();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error !!!! Try  after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
