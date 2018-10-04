package com.leju.oauth2additionalclaim;

import com.leju.oauth2additionalclaim.configuration.CustomUserDetails;
import com.leju.oauth2additionalclaim.entity.User;
import com.leju.oauth2additionalclaim.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Oauth2AdditionalClaimApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AdditionalClaimApplication.class, args);
	}

	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepository) throws Exception {
		builder.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
				User user = userRepository.findByUsername(s);
				if (user == null) throw new UsernameNotFoundException("Username " + s + " not found");
				return new CustomUserDetails(userRepository.findByUsername(s));
			}
		})
				.passwordEncoder(new BCryptPasswordEncoder());

	}
}
