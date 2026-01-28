package com.school.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
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
	  }	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http
			 .csrf().disable()    //Disabling CSRF as not using form based login
			
			.authorizeRequests()
			.antMatchers("/auth/**").permitAll()
			.antMatchers(HttpMethod.GET, "/api/**").permitAll()
						
			.antMatchers("/master/**").permitAll()
			.antMatchers(HttpMethod.DELETE, "/master/deleteBloodGroupId").hasAuthority("Admin")
			.antMatchers(HttpMethod.POST, "/master/**").permitAll()
			.antMatchers(HttpMethod.POST, "/upload").permitAll()
			//.antMatchers("/master/**").hasAnyAuthority("Admin")
			
			//.antMatchers(HttpMethod.GET, "/student/**").permitAll()
			.antMatchers("/student/**").permitAll()
			.antMatchers(HttpMethod.POST, "/student/**").permitAll()
					
			.anyRequest().authenticated()
		
			 .and()
	            .formLogin().permitAll()
	            .and()
	            .logout().permitAll()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(authenticationEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			//To Verify user from second request onwards............
			.and()
			.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
			 http.authenticationProvider(authenticationProvider());

		
		return http.build();
				}
	
	
	
}
