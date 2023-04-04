package com.project.LayOutService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.LayOutService.domain.WorkSpace;

@Repository
public interface WorkSpaceRepository extends MongoRepository<WorkSpace,String> {
}
