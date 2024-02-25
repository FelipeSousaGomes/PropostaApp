package com.gomes.propostaapp.repository;

import com.gomes.propostaapp.entity.Proposta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropostaRepository extends CrudRepository<Proposta,Long> {

    List<Proposta> findAllByIntegradaIsFalse();



}
