package com.school.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.dto.SignupRequestDto;
import com.school.entity.AuthResponse;
import com.school.entity.RefreshToken;
import com.school.entity.Role;
import com.school.entity.TokenRefreshResponse;
import com.school.entity.User;
import com.school.repository.RoleRepository;
import com.school.repository.UserRepository;
import com.school.security.JwtTokenUtil;
import com.school.security.TokenRefreshRequest;
import com.school.service.RefreshTokenService;
import com.school.service.UserDetailsImpl;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private RefreshTokenService refreshTokenService;

	public static List<String> roleList;

	@PostMapping("/login")
	public ResponseEntity<?> userLogin(@RequestBody User user) {
		System.out.println("AuthController -- userLogin");

		if (!userRepository.existsByUserName(user.getUserName())) {
			return ResponseEntity.badRequest().body("Username does not Exist");
		}

		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword()));
		
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtTokenUtil.generateJwtToken(authentication);
		 UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream().map(auth -> auth.getAuthority())
				.collect(Collectors.toList());

		roleList = roles;
		//System.out.println("Role List" + " " + roleList.get(0) + " " + roleList.get(1));

		RefreshToken refreshToken = refreshTokenService.createRefreshToken(userDetails.getUserId());
		System.out.println(refreshToken.getToken());
		

		AuthResponse authResponse = new AuthResponse();
		authResponse.setToken(token);
		authResponse.setRoles(roles);
		authResponse.setName(userDetails.getName());
		authResponse.setUserName(userDetails.getUsername());
		authResponse.setPassword(userDetails.getPassword());
		authResponse.setEmail(userDetails.getEmail());
		authResponse.setRefreshToken(refreshToken.getToken());

		return ResponseEntity.ok(authResponse);
	}

	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@RequestBody TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		Optional<RefreshToken> option = refreshTokenService.findByToken(requestRefreshToken);
		RefreshToken refreshToken = refreshTokenService.verifyExpiration(option.get());
		User user = refreshToken.getUser();
		String refresToken = jwtTokenUtil.generateTokenFromUsername(user.getUserName());
		return ResponseEntity.ok(new TokenRefreshResponse(refresToken, requestRefreshToken));

		/*
		 * .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
		 * "Refresh token is not in database!"));
		 */

		/*
		 * return refreshTokenService.findByToken(requestRefreshToken)
		 * .map(refreshTokenService::verifyExpiration) .map(RefreshToken::getUser)
		 * .map(user ->{ String token =
		 * jwtTokenUtil.generateTokenFromUsername(user.getUserName()); return
		 * ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken)); } )
		 * .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
		 * "Refresh token is not in database!"));
		 */

	}

	@PostMapping("/signup")
	public ResponseEntity<?> userSignup(@RequestBody SignupRequestDto signupRequest) {

		Set<Role> roles = new HashSet<>();
		if (userRepository.existsByUserName(signupRequest.getUserName())) {
			return ResponseEntity.badRequest().body("Username is already taken");
		}
		if (userRepository.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body("Email is already taken");
		}
		User user = new User();
		user.setName(signupRequest.getName());
		user.setUserName(signupRequest.getUserName());
		user.setEmail(signupRequest.getEmail());
		user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));

		String[] roleArr = signupRequest.getRoles();

		if (roleArr == null) {

			roles.add(roleRepository.findByRoleName("User"));
		}

		for (String role : roleArr) {

			switch (role) {
			case "Admin": {

				roles.add(roleRepository.findByRoleName("Admin"));

				break;
			}

			case "HR": {

				roles.add(roleRepository.findByRoleName("HR"));

				break;
			}
			case "User": {

				roles.add(roleRepository.findByRoleName("User"));
				break;
			}

			default:
				return ResponseEntity.badRequest().body("Specified role not found");
			}
			System.out.println("Inside Loop");
		}

		user.setRoles(roles);

		return new ResponseEntity<User>(userRepository.save(user), HttpStatus.CREATED);

	}

}
