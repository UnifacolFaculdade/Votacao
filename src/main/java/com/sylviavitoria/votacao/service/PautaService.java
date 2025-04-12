package com.sylviavitoria.votacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sylviavitoria.votacao.model.Pauta;
import com.sylviavitoria.votacao.repository.PautaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;
    
    public Pauta cadastrar(Pauta pauta) {
        return pautaRepository.save(pauta);
    }
    
    public Optional<Pauta> buscarPorId(Long id) {
        return pautaRepository.findById(id);
    }
    
    public List<Pauta> listarTodas() {
        return pautaRepository.findAll();
    }
}
