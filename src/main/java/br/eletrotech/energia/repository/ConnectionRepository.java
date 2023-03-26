package br.eletrotech.energia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.eletrotech.energia.dto.ConnectionDTO;
import br.eletrotech.energia.model.Connection;

public interface ConnectionRepository extends JpaRepository<Connection, Long>{
	
	@Query(value = "SELECT NEW br.eletrotech.energia.dto.ConnectionDTO(c.id, c.number) FROM Connection c")
	List<ConnectionDTO> findAllInDTO();

}
