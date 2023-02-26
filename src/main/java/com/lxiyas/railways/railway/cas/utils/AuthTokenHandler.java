package com.lxiyas.railways.railway.cas.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.cas.modals.AuthView;

@Service
public class AuthTokenHandler {
    public AuthView validateRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = null;
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);
        }

        String serviceUrl = request.getServerName();
        return new AuthView(token, serviceUrl);
    }

    public boolean validateRequestParams(String uri) {
        List<String> permitterUrls = new ArrayList<String>(Arrays.asList("/auth/token", "/auth/refresh"));
        return permitterUrls.contains(uri);
    }
}
