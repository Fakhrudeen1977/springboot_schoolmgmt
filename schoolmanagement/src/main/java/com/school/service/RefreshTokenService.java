package com.school.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.school.entity.RefreshToken;
import com.school.exception.TokenRefreshException;
import com.school.repository.RefreshTokenRepository;
import com.school.repository.UserRepository;

@Service
public class RefreshTokenService {
	
	 @Value("${jwtRefreshExpirationMs}")
	  private Long refreshTokenDurationMs;

	  @Autowired
	  private RefreshTokenRepository refreshTokenRepository;

	  @Autowired
	  private UserRepository userRepository;

	  public Optional<RefreshToken> findByToken(String token) {
	    return refreshTokenRepository.findByToken(token);
	  }

	  public RefreshToken createRefreshToken(Long userId) {
	    RefreshToken refreshToken = new RefreshToken();

	    refreshToken.setUser(userRepository.findByUserId(userId).get());
	    refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
	    refreshToken.setToken(UUID.randomUUID().toString());

	    refreshToken = refreshTokenRepository.save(refreshToken);
	    return refreshToken;
	  }

	  public RefreshToken verifyExpiration(RefreshToken token) {
	    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
	      refreshTokenRepository.delete(token);
	      throw new TokenRefreshException(token.getToken(), "Refresh token was expired. Please make a new signin request");
	    }

	    return token;
	  }

	  @Transactional
	  public int deleteByUserId(Long userId) {
	    return refreshTokenRepository.deleteByUser(userRepository.findByUserId(userId).get());
	  }

}
