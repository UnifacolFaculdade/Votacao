package com.sylviavitoria.votacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sylviavitoria.votacao.model.Associado;

@Repository 
public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    
    
}
