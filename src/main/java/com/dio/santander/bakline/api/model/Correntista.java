package com.dio.santander.bakline.api.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_correntista")
public class Correntista {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	private Integer cpf;
	
	@Column(length = 60)
	private String nome;
	
	@Embedded
	private Conta conta;
	
	public Correntista() {
	}
	
	public Correntista(Integer id, Integer cpf, String nome, Conta conta) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.conta = conta;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
