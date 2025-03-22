package com.sylviavitoria.votacao.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Sessao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;
    
    private LocalDateTime dataAbertura;
    
    private LocalDateTime dataFechamento;
    
    public Sessao() {
        
    }
    // public boolean isAberta() {
    //     LocalDateTime agora = LocalDateTime.now();
    //     return agora.isAfter(dataAbertura) && agora.isBefore(dataFechamento);
    // }
    
}