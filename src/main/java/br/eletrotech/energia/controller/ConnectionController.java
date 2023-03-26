package br.eletrotech.energia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.eletrotech.energia.dto.ConnectionDTO;
import br.eletrotech.energia.service.ConnectionService;

@RestController
@RequestMapping("/api/connections")
public class ConnectionController {

	@Autowired
	private ConnectionService service;
	
	@GetMapping
	private ResponseEntity<List<ConnectionDTO>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}
}
