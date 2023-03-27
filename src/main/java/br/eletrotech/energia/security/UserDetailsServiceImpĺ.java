package br.eletrotech.energia.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.eletrotech.energia.model.User;
import br.eletrotech.energia.repository.UserRepository;

@Component
public class UserDetailsServiceImpĺ implements UserDetailsService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> userOpt = repository.findByEmail(email);
		if (userOpt.isEmpty()) {
			throw new UsernameNotFoundException("User [ "+email+" ] is not found!");
		}
		return new UserDetailsDTO(userOpt.get());
	}
	
	

}
