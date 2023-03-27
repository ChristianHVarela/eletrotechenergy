package br.eletrotech.energia.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class ConfigurationSecurity extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsServiceImpĺ userDetailsServiceImpĺ;
	@Autowired
	private PasswordEncoder passwordEncoder;
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpĺ).passwordEncoder(passwordEncoder);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.csrf().disable().authorizeRequests()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilter(new AuthenticationFilter(authenticationManager()))
			.addFilter(new JWTValidationFilter(authenticationManager()))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
	}
	
}
