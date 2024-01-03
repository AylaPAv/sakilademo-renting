package es.aylait.sakilademo.renting.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityProjectConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeRequests((authR) -> authR.anyRequest().authenticated())
			.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authManager(UserDetailsService userDetailsService,
			  PasswordEncoder passwordEncoder) {
	  DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
	  daoAuthProvider.setUserDetailsService(userDetailsService);
	  daoAuthProvider.setPasswordEncoder(passwordEncoder);
		  
	  return new ProviderManager(daoAuthProvider);
	}
	  
	@Bean
	public UserDetailsService userDetailsService() {
	  UserDetails userDetails = User.withDefaultPasswordEncoder()
			  .username("aylap")
			  .password("$2a$10$aNoR88g5b5TzSKb7mQ1nQOkyEwfHVQOxHY0HX7irI8qWINvLDWRyS")
			  .roles("USER","ADMIN")
			  .build();
	  return new InMemoryUserDetailsManager(userDetails);
	}
	  
	@Bean
	public PasswordEncoder passwordEncoder() {
	  return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
