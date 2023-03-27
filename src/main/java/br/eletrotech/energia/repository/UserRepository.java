package br.eletrotech.energia.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.eletrotech.energia.dto.UserDTO;
import br.eletrotech.energia.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query(value = "SELECT NEW br.eletrotech.energia.dto.UserDTO(u.id, u.name, u.email, u.password) FROM User u")
	List<UserDTO> findAllInDTO();

	@Query(value = "SELECT u FROM User u WHERE UPPER(u.name) LIKE UPPER(?1)")
	Optional<User> findByName(String username);
	
	@Query(value = "SELECT u FROM User u WHERE u.email = ?1")
	Optional<User> findByEmail(String email);

}
