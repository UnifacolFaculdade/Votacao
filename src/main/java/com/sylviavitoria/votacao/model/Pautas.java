package com.sylviavitoria.votacao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_pautas")
public class Pautas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(nullable = false)
    private String titulo;

    public Pautas() {
        
    }

    public Pautas(Long id, String descricao, String titulo) {
        this.id = id;
        this.descricao = descricao;
        this.titulo = titulo;
    }
}
