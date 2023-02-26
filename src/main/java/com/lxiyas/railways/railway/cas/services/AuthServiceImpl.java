package com.lxiyas.railways.railway.cas.services;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lxiyas.railways.railway.cas.messages.TokenTypes;
import com.lxiyas.railways.railway.cas.modals.AuthView;
import com.lxiyas.railways.railway.cas.modals.TokenContents;
import com.lxiyas.railways.railway.cas.modals.TokenRequest;
import com.lxiyas.railways.railway.cas.modals.TokenResponse;
import com.lxiyas.railways.railway.cas.utils.AuthTokenHandler;
import com.lxiyas.railways.railway.cas.utils.JWTUtils;
import com.lxiyas.railways.railway.organization.service.OrganizationService;
import com.lxiyas.railways.railway.user.modals.UserView;
import com.lxiyas.railways.railway.user.service.UserService;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private JWTUtils jWTUtils;
    @Autowired
    private AuthTokenHandler authTokenHandler;
    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private UserService userService;

    @Override
    public TokenResponse generateToken(TokenRequest tokenRequest, HttpServletRequest request) {
        AuthView authView = authTokenHandler.validateRequest(request);
        if (null == tokenRequest && organizationService.verifyServiceUrl(authView.getServiceUrl())) {
            return null;
        }
        if (tokenRequest.getGrandType() == TokenTypes.accessToken) {
            UserView userView = userService.getUserViewByEmailAndPassword(tokenRequest.getUsername(),
                    tokenRequest.getPassword());
            if (null == userView) {
                return null;
            }
            TokenContents user = new TokenContents();
            user.setEmaill(userView.getEmail());
            user.setUserId(userView.getId());
            user.setServiceUrl(authView.getServiceUrl());
            return jWTUtils.generateAccessToken(user);
        }
        if (tokenRequest.getGrandType() == TokenTypes.anounnimous) {
            if (organizationService.verifyServiceUrl(authView.getServiceUrl())) {
                TokenContents user = new TokenContents();
                user.setServiceUrl(authView.getServiceUrl());
                return jWTUtils.generateAnounnimusToken(user);
            }
        }
        return null;
    }

}
