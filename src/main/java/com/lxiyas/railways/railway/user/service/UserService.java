package com.lxiyas.railways.railway.user.service;

import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.user.modals.UserView;

@Service
public interface UserService {

    UserView createUser(UserView userView);

    UserView getUserViewByEmail(String email);

    UserView getUserViewByEmailAndPassword(String email, String password);

}
