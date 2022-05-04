package com.dio.santander.bakline.api.model;

public class Correntista {

	
	private Integer id;
	private Integer cpf;
	private String nome;
	
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
