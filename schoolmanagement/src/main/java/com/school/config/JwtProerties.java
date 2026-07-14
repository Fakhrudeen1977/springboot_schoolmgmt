package com.school.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtProerties {

	@Value("${jwt.secret}")
	private String jwtToken_Secret;
	
	@Value("${jwt.expiration}")
	private long jwtAccessToken_Expiration;
	 
	@Value("${jwt.refresh-expiration}") 
	private long jwtRefreshToken_Expiration;
	
	
	
	public String getJwtToken_Secret() {
		return jwtToken_Secret;
	}
	public void setJwtToken_Secret(String jwtToken_Secret) {
		this.jwtToken_Secret = jwtToken_Secret;
	}
	public long getJwtAccessToken_Expiration() {
		return jwtAccessToken_Expiration;
	}
	public void setJwtAccessToken_Expiration(long jwtAccessToken_Expiration) {
		this.jwtAccessToken_Expiration = jwtAccessToken_Expiration;
	}
	public long getJwtRefreshToken_Expiration() {
		return jwtRefreshToken_Expiration;
	}
	public void setJwtRefreshToken_Expiration(long jwtRefreshToken_Expiration) {
		this.jwtRefreshToken_Expiration = jwtRefreshToken_Expiration;
	}
	

	
}
