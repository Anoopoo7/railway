package com.lxiyas.railways.railway.cas.modals;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthView {
    private String token;
    private String serviceUrl;
}
