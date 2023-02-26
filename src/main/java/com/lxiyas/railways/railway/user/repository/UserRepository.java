package com.lxiyas.railways.railway.user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lxiyas.railways.railway.user.modals.UserView;

@Repository
public interface UserRepository extends MongoRepository<UserView,String> {

    UserView findByEmail(String email);
    
}
