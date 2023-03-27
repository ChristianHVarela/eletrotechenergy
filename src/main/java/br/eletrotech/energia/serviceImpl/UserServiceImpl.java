package br.eletrotech.energia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eletrotech.energia.dto.UserDTO;
import br.eletrotech.energia.repository.UserRepository;
import br.eletrotech.energia.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public List<UserDTO> findAll() {
		return repository.findAllInDTO();
	}
	
	
}
