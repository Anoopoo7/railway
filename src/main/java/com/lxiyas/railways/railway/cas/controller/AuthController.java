package com.lxiyas.railways.railway.cas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lxiyas.railways.railway.cas.messages.CasMessages;
import com.lxiyas.railways.railway.cas.modals.TokenRequest;
import com.lxiyas.railways.railway.cas.services.AuthService;
import com.lxiyas.railways.railway.common.Response;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/token")
    public ResponseEntity<Response> generateToken(@RequestBody TokenRequest tokenRequest, HttpServletRequest request) {
        return new ResponseEntity<Response>(
                new Response(true, authService.generateToken(tokenRequest, request), CasMessages.TOKEN_CREATED, null),
                HttpStatus.OK);
    }

}
