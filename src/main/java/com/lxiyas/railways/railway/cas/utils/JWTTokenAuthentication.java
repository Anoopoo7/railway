package com.lxiyas.railways.railway.cas.utils;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lxiyas.railways.railway.cas.messages.TokenTypes;
import com.lxiyas.railways.railway.cas.modals.AuthView;
import com.lxiyas.railways.railway.cas.modals.TokenContents;
import com.lxiyas.railways.railway.user.modals.UserView;
import com.lxiyas.railways.railway.user.service.UserService;

@Component
public class JWTTokenAuthentication extends OncePerRequestFilter {
    @Autowired
    private AuthTokenHandler authTokenHandler;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private UserService usersService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        boolean authenticated = false;
        UserView user = new UserView();
        if (!authTokenHandler.validateRequestParams(request.getRequestURI())) {
            AuthView validateRequest = authTokenHandler.validateRequest(request);
            if (jwtUtils.validateToken(validateRequest.getToken())) {
                TokenContents tokenContents = jwtUtils.decriptToken(validateRequest.getToken());
                if (tokenContents.getToketTokenTypes().equals(TokenTypes.accessToken.name())) {
                    UserView currentuser = usersService.getUserViewByEmail(tokenContents.getEmaill());
                    if (null != currentuser) {
                        user = currentuser;
                        authenticated = true;
                    }
                }
                if (tokenContents.getToketTokenTypes().equals(TokenTypes.refreshToken.name())) {
                    user.setBrandId("63e8b5128a86fec7cc0805a5");
                    authenticated = true;
                }
                if (tokenContents.getToketTokenTypes().equals(TokenTypes.anounnimous.name())) {
                    user.setBrandId("63e8b5128a86fec7cc0805a5");
                    authenticated = true;
                }
            }
        }
        if (authenticated || authTokenHandler.validateRequestParams(request.getRequestURI())) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    user, null, null);
            usernamePasswordAuthenticationToken
                    .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            filterChain.doFilter(request, response);
        }
    }
}
