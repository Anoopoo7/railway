package com.lxiyas.railways.railway.cas.modals;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TokenResponse {
    public String token;
    public String refreshToken;
    public List<String> roles;
}
