package com.deepvasto.mscartoes.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepvasto.mscartoes.domain.ClienteCartao;
import com.deepvasto.mscartoes.infra.repository.ClienteCartaoRepository;

@Service
public class ClienteCartaoService {

	@Autowired
	private ClienteCartaoRepository clienteCartaoRepository;
	
	public List<ClienteCartao> listCartoesByCpf(String cpf){
		return clienteCartaoRepository.findByCpf(cpf);
	}
}
