package br.eletrotech.energia.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.eletrotech.energia.dto.ConnectionDTO;
import br.eletrotech.energia.repository.ConnectionRepository;
import br.eletrotech.energia.service.ConnectionService;

@Service 
public class ConnectionServiceImpl implements ConnectionService {
	
	@Autowired
	private ConnectionRepository repository;

	@Override
	public List<ConnectionDTO> findAll() {
		return repository.findAllInDTO();
	}

}
