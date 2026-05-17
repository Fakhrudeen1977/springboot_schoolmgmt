package com.school.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
		
	
	 @Bean
	  public JwtAuthTokenFilter authenticationJwtTokenFilter() {
	    return new JwtAuthTokenFilter();
	  }

	@Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(userDetailsService);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }
	  
	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
	    return authConfig.getAuthenticationManager();
	  }

	  @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
	  @Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		  
		  http
	      // Disable CSRF for this example (not recommended for production web apps)
	      .csrf(csrf -> csrf.disable())
		    
		  .authorizeHttpRequests(auth -> auth
			.antMatchers("/auth/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/**").permitAll()
						
			.antMatchers("/master/**").permitAll()
			.antMatchers(HttpMethod.DELETE, "/master/deleteBloodGroupId").hasAuthority("Admin")
			.antMatchers(HttpMethod.POST, "/master/**").permitAll()
			.antMatchers(HttpMethod.POST, "/upload").permitAll()
		
			.antMatchers("/student/**").permitAll()
			.antMatchers(HttpMethod.POST, "/student/**").permitAll()
					
			.anyRequest().authenticated()
			
			 )
		  .authenticationProvider(authenticationProvider())
	       .addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
			
	      
		  return http.build(); 
		
		}
	 
	     
	  
	  
	
	
}
