package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.school.entity.RefreshToken;
import com.school.entity.User;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
	
	 Optional<RefreshToken> findByToken(String token);

	 @Modifying
	 @Transactional
	 int deleteByUser(User user);
	

}
