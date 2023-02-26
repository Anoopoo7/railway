package com.lxiyas.railways.railway.common;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.lxiyas.railways.railway.user.modals.UserView;

@Component
public class UserContext {
    public UserView getuserContext() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        UserView userDetails = (UserView) authentication.getPrincipal();
        return userDetails;
    }
}