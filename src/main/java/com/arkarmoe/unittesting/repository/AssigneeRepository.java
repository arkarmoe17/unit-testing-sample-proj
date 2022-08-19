package com.arkarmoe.unittesting.repository;

import com.arkarmoe.unittesting.model.entity.Assignee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends MongoRepository<Assignee,String> {

}
