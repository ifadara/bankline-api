package com.dio.santander.bakline.api.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bakline.api.dto.CorrentistaDto;
import com.dio.santander.bakline.api.model.Conta;
import com.dio.santander.bakline.api.model.Correntista;
import com.dio.santander.bakline.api.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	
	@Autowired
	private CorrentistaRepository repository;

	public void create(CorrentistaDto correntistaDto) {
		Correntista correntista = new Correntista();
		correntista.setCpf(correntistaDto.getCpf());
		correntista.setNome(correntistaDto.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(0.0);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		repository.save(correntista);
		
	}
}
