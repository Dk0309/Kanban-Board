package com.project.LayOutService.controller;

import com.project.LayOutService.domain.Pillar;
import com.project.LayOutService.domain.WorkSpace;
import com.project.LayOutService.exception.PillarAlreadyExistsException;
import com.project.LayOutService.exception.PillarNotFoundException;
import com.project.LayOutService.exception.WorkSpaceAlreadyExistsException;
import com.project.LayOutService.exception.WorkSpaceNotFoundException;
import com.project.LayOutService.service.PillarService;
import com.project.LayOutService.service.WorkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PillarController {
    private ResponseEntity responseEntity;
    private PillarService pillarService;
    private WorkSpaceService workSpaceService;

    @Autowired
    public PillarController(PillarService pillarService) {this.pillarService = pillarService;}

    @PostMapping("pillar/{workSpaceName}")
    public ResponseEntity<?> addPillar(@RequestBody Pillar pillar, @PathVariable String workSpaceName) throws PillarAlreadyExistsException {
        System.out.println("In controller");
        try{
            responseEntity = new ResponseEntity(pillarService.addPillar(pillar, workSpaceName), HttpStatus.CREATED);
        }
        catch(PillarAlreadyExistsException   e){
            responseEntity=new ResponseEntity<>("Pillar Already Exists",HttpStatus.CONFLICT);
        }
        catch(WorkSpaceNotFoundException w)
        {
            responseEntity=new ResponseEntity<>("WorkSpace Not Found",HttpStatus.NOT_FOUND);
        }
        catch (Exception e)
        {
            responseEntity=new ResponseEntity<>("Error !!!! Try  after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return  responseEntity;
    }

    @DeleteMapping("api/pillars/{workSpaceName}/{pillarName}")
    public ResponseEntity<?> removePillar(@PathVariable String workSpaceName,@PathVariable String pillarName) throws PillarNotFoundException {
        try{
            responseEntity = new ResponseEntity(pillarService.removePillar(workSpaceName,pillarName), HttpStatus.OK);
        }
        catch (PillarNotFoundException e) {
            responseEntity = new ResponseEntity<>("Pillar Not Found", HttpStatus.NOT_FOUND);

        }
        catch (WorkSpaceNotFoundException w)
        {
            responseEntity = new ResponseEntity<>("WorkSpace Not Found", HttpStatus.NOT_FOUND);
        }
        catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error !!!! Try  after Sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("/api/allPillars/{workSpaceName}")
    public ResponseEntity<?> getAllPillars(@PathVariable String workSpaceName) throws WorkSpaceNotFoundException {
        try {
            responseEntity = new ResponseEntity<>(pillarService.showAllPillar(workSpaceName),HttpStatus.OK);
        } catch (WorkSpaceNotFoundException e)
        {
            throw new WorkSpaceNotFoundException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>("<<<<-ERROR !!!! TRY LATER->>>>",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}
