package br.eletrotech.energia.service;

import java.util.List;

import br.eletrotech.energia.dto.UserDTO;

public interface UserService {
	
	List<UserDTO> findAll();
	
}
