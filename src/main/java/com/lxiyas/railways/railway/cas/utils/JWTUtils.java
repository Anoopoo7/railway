package com.lxiyas.railways.railway.cas.utils;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.lxiyas.railways.railway.cas.messages.TokenTypes;
import com.lxiyas.railways.railway.cas.modals.TokenContents;
import com.lxiyas.railways.railway.cas.modals.TokenResponse;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtils {

  private static final String SECRET_KEY = "secretkey";

  private Date expire(TokenTypes type) {
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.MINUTE, 10);
    return calendar.getTime();
  }

  public TokenResponse generateAccessToken(TokenContents user) {
    return new TokenResponse(generateAccessTokenCore(user), generateRefreshTokenCore(user), null);
  }

  public TokenResponse generateAnounnimusToken(TokenContents user) {
    return new TokenResponse(generateAnounnimusTokenCore(user), null, null);
  }

  private String generateAccessTokenCore(TokenContents user) {
    return Jwts.builder()
        .setSubject(user.getServiceUrl())
        .setIssuedAt(new Date())
        .claim("email", user.getEmaill())
        .claim("userId", user.getUserId())
        .claim("grandType", TokenTypes.accessToken)
        .setExpiration(expire(TokenTypes.accessToken))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  public String generateRefreshTokenCore(TokenContents user) {
    return Jwts.builder()
        .setSubject(user.getServiceUrl())
        .setIssuedAt(new Date())
        .claim("userId", user.getUserId())
        .claim("grandType", TokenTypes.refreshToken)
        .setExpiration(expire(TokenTypes.accessToken))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  public String generateAnounnimusTokenCore(TokenContents user) {
    return Jwts.builder()
        .setSubject(user.getServiceUrl())
        .setIssuedAt(new Date())
        .claim("grandType", TokenTypes.refreshToken)
        .setExpiration(expire(TokenTypes.anounnimous))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
  }

  public static String getUsername(String token) {
    Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }

  public boolean validateToken(String token) {
    try {
      Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public TokenContents decriptToken(String token) {
    Jws<Claims> decriptedData = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
    Claims claims = decriptedData.getBody();
    String tokenTypes = (String) claims.get("grandType");
    String serviceUrl = claims.getSubject();
    String email = (String) claims.get("email");
    String userId = (String) claims.get("userId");
    TokenContents currentUser = new TokenContents(email, serviceUrl, userId, tokenTypes);
    return currentUser;
  }
}
