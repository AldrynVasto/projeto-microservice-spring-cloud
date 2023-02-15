package com.deepvasto.mscartoes.application;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deepvasto.mscartoes.domain.Cartao;
import com.deepvasto.mscartoes.infra.repository.CartaoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoService {

	@Autowired
	private  CartaoRepository repository;
	
	@Transactional
    public Cartao save(Cartao cartao) {
    	return repository.save(cartao);
    }
    
    public List<Cartao> getCartoesRendaMenorIgual(Long renda) {
    	BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
    	return repository.findByRendaLessThanEqual(rendaBigDecimal);
    }
}
