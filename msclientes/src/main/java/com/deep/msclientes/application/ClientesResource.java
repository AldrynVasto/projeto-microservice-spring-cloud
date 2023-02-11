package com.deep.msclientes.application;

import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.deep.msclientes.application.representation.ClienteSaveRequest;
import com.deep.msclientes.domain.Cliente;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClientesResource {
	
	@Autowired
	private  ClienteService service;
	
	final static Logger log = LoggerFactory.getLogger(ClientesResource.class);
	
	@GetMapping
	public String status() {
		log.info("Obtendo o status do microservice de cliente");
		return "ok";
	}
	
    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request){
        Cliente cliente = request.toModel();
        service.save(cliente);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }
	
	@GetMapping(params = "cpf")
	public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf) {
		Optional<Cliente> cliente = service.getByCPF(cpf);
		if(cliente.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cliente);
	}

}
