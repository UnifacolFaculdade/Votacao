package com.faculdade.votacao.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_associados")
@Getter
@Setter
public class Associado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @Column(unique = true, nullable = false)
    private String cpf;
    
    @JsonBackReference
    @OneToMany(mappedBy = "associado")
    private List<Voto> votos;
    
    public Associado() {
        
    }
    
    public Associado(Long id, String nome, String cpf) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
    }
    
    @Override
    public String toString() {
        return "Associado [id=" + id + ", nome=" + nome + ", cpf=" + cpf + "]";
    }
}