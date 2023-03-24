package br.eletrotech.energia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.eletrotech.energia.model.Connection;

public interface ConnectionRepository extends JpaRepository<Connection, Long>{

}
