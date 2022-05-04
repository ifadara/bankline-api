package com.dio.santander.bakline.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.santander.bakline.api.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {

}
