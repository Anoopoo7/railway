package com.lxiyas.railways.railway.user.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHelper {
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean decodePassword(String password1, String password2) {
        return passwordEncoder.matches(password1, password2);
    }
}
