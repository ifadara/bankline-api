package com.dio.santander.bakline.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dio.santander.bakline.api.dto.MovimentacaoDto;
import com.dio.santander.bakline.api.model.Correntista;
import com.dio.santander.bakline.api.model.Movimentacao;
import com.dio.santander.bakline.api.model.MovimentacaoTipo;
import com.dio.santander.bakline.api.repository.CorrentistaRepository;
import com.dio.santander.bakline.api.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repository;
	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	public void create(MovimentacaoDto movimentacaoDto) {
		Movimentacao movimentacao = new Movimentacao();
		
		Double valor = movimentacaoDto.getTipo()==MovimentacaoTipo.RECEITA ? movimentacaoDto.getValor() : movimentacaoDto.getValor() * -1;
				
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(movimentacaoDto.getDescricao());
		movimentacao.setIdConta(movimentacaoDto.getIdConta());
		movimentacao.setTipo(movimentacaoDto.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(movimentacaoDto.getIdConta()).orElse(null);
		
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
			correntistaRepository.save(correntista);
		}
		
		repository.save(movimentacao);
	}
	
}
