package com.school.security;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.school.config.JwtProerties;
import com.school.service.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

	@Autowired
	private JwtProerties jwtConfig;

	private static final Logger logger = LoggerFactory.getLogger(JwtTokenUtil.class);

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder().setSubject(userPrincipal.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getJwtAccessToken_Expiration()))

				.signWith(key(), SignatureAlgorithm.HS256).compact();
	}

	// https://8gwifi.org/jwsgen.jsp

	public String generateTokenFromUsername(String username) {
		return Jwts.builder().setSubject(username).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtConfig.getJwtAccessToken_Expiration()))
				.signWith(key(), SignatureAlgorithm.HS256)

				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody().getSubject();
	}

	private Key key() {
		return Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtConfig.getJwtToken_Secret()));

	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parserBuilder().setSigningKey(key()).build().parse(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}

}
