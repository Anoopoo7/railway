package com.lxiyas.railways.railway.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.common.Logger;
import com.lxiyas.railways.railway.user.helper.UserServiceHelper;
import com.lxiyas.railways.railway.user.modals.UserView;
import com.lxiyas.railways.railway.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceHelper userServiceHelper;

    @Override
    public UserView createUser(UserView userView) {
        Logger.log("237b957e-b044-11ed-8af5-325096b39f47", "recieved userview" + userView);
        if (null != this.getUserViewByEmail(userView.getEmail())) {
            return null;
        }
        userView.setPassword(userServiceHelper.encodePassword(userView.getPassword()));
        return userRepository.save(userView);
    }

    @Override
    public UserView getUserViewByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserView getUserViewByEmailAndPassword(String email, String password) {
        UserView user = this.getUserViewByEmail(email);
        if (null != user) {
            if (userServiceHelper.decodePassword(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}
