package com.deep.msclientes.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.deep.msclientes.domain.Cliente;

@Component
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Optional<Cliente> findByCpf(String cpf);

}
