package com.sylviavitoria.votacao.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_pautas")
public class Pauta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(nullable = false)
    private String titulo;

    @JsonBackReference
    @OneToOne(mappedBy = "pauta", cascade = CascadeType.ALL)
    private Sessao sessao;

    @OneToMany(mappedBy = "pauta", cascade = CascadeType.ALL)
    private List<Voto> votos;

    public Pauta() {
        
    }

    public Pauta(Long id, String descricao, String titulo) {
        this.id = id;
        this.descricao = descricao;
        this.titulo = titulo;
    }
    
    
    @Override
    public String toString() {
        return "Pauta [id=" + id + ", titulo=" + titulo + "]";
    }
}