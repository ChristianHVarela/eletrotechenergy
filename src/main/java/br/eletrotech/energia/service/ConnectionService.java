package br.eletrotech.energia.service;

import java.util.List;

import br.eletrotech.energia.dto.ConnectionDTO;

public interface ConnectionService {

	List<ConnectionDTO> findAll();
	
}
