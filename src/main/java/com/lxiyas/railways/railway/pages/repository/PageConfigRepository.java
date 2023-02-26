package com.lxiyas.railways.railway.pages.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lxiyas.railways.railway.pages.model.PageConfigurations;

@Repository
public interface PageConfigRepository extends MongoRepository<PageConfigurations,String> {
    
}
