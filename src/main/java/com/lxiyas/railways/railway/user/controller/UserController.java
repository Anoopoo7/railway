package com.lxiyas.railways.railway.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiyas.railways.railway.common.Response;
import com.lxiyas.railways.railway.user.messages.UserMessages;
import com.lxiyas.railways.railway.user.modals.UserView;
import com.lxiyas.railways.railway.user.service.UserService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Response> createUser(@RequestBody UserView userView, HttpServletRequest request) {
        return new ResponseEntity<Response>(
                new Response(true, userService.createUser(userView) , UserMessages.USER_CREATED, null),
                HttpStatus.OK);
    }
}
