package com.deep.msclientes.domain;


import javax.persistence.*;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
	@Column
    private String nome;
    @Column
    private Integer idade;
    
    public Cliente() {
    	
    }
    
    public Cliente(String cpf, String nome, Integer idade) {
 		this.cpf = cpf;
 		this.nome = nome;
 		this.idade = idade;
 	}
    
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}

  
	
}
