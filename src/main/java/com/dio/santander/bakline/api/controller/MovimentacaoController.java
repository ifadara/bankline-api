package com.dio.santander.bakline.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.santander.bakline.api.dto.MovimentacaoDto;
import com.dio.santander.bakline.api.model.Movimentacao;
import com.dio.santander.bakline.api.repository.MovimentacaoRepository;
import com.dio.santander.bakline.api.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {
	
	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private MovimentacaoService service;
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	@PostMapping
	public void create(@RequestBody MovimentacaoDto movimentacao) {
		service.create(movimentacao);
	}
}
