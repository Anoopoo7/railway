package com.lxiyas.railways.railway.cas.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.cas.modals.TokenRequest;
import com.lxiyas.railways.railway.cas.modals.TokenResponse;

@Service
public interface AuthService {
    public TokenResponse generateToken(TokenRequest tokenRequest, HttpServletRequest request);

    // public 
}
