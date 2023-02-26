package com.lxiyas.railways.railway.cas.modals;

import com.lxiyas.railways.railway.cas.messages.TokenTypes;

import lombok.Data;

@Data
public class TokenRequest {
    private String username;
    private String password;
    private TokenTypes grandType;
}
