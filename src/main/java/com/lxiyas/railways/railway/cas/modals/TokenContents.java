package com.lxiyas.railways.railway.cas.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenContents {
    private String emaill;
    private String serviceUrl;
    private String userId;
    private String toketTokenTypes;
}
