package com.sylviavitoria.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sylviavitoria.votacao.model.Pauta;

@Repository 
public interface PautaRepository extends JpaRepository<Pauta, Long> {
    
    
}
