package com.deep.msclientes.application;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deep.msclientes.domain.Cliente;
import com.deep.msclientes.infra.repository.ClienteRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Transactional
	public Cliente save(Cliente cliente) {
		return repository.save(cliente);
	}
	
	public Optional<Cliente> getByCPF(String cpf){
		return repository.findByCpf(cpf);
	}
}
