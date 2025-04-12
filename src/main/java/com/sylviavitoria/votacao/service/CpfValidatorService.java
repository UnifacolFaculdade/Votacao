package com.sylviavitoria.votacao.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@Service
public class CpfValidatorService {
    
    private Random random = new Random();
    
    public enum CpfStatus {
        ABLE_TO_VOTE,
        UNABLE_TO_VOTE
    }
    
    /**
     * Simula uma validação de CPF e verificação se o associado pode votar
     * @param cpf CPF a ser validado
     * @return status do CPF
     * @throws ResponseStatusException se o CPF for inválido
     */
    public CpfStatus validarCpf(String cpf) {
        // Validação básica de CPF (formato)
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF inválido");
        }
        
        // Simulação de validação aleatória: 70% de chance de ser válido
        if (random.nextDouble() <= 0.7) {
            // Entre os válidos, 80% podem votar
            if (random.nextDouble() <= 0.8) {
                return CpfStatus.ABLE_TO_VOTE;
            } else {
                return CpfStatus.UNABLE_TO_VOTE;
            }
        }
        
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "CPF inválido");
    }
}
