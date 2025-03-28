package com.sylviavitoria.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sylviavitoria.votacao.model.Sessao;

@Repository 
public interface SessaoRepository extends JpaRepository<Sessao, Long> {
    
    
}
