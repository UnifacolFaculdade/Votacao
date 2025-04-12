package com.sylviavitoria.votacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sylviavitoria.votacao.model.Pauta;
import com.sylviavitoria.votacao.model.Sessao;
import com.sylviavitoria.votacao.repository.PautaRepository;
import com.sylviavitoria.votacao.repository.SessaoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;
    
    @Autowired
    private PautaRepository pautaRepository;
    
    /**
     * Abre uma sessão de votação para uma pauta específica
     * @param pautaId ID da pauta
     * @param minutos tempo em minutos que a sessão ficará aberta (default: 1)
     * @return a sessão criada
     * @throws IllegalArgumentException se a pauta não existir
     * @throws IllegalStateException se a pauta já tiver uma sessão aberta
     */
    public Sessao abrirSessao(Long pautaId, Integer minutos) {
        // Tempo padrão de 1 minuto se não for especificado
        if (minutos == null || minutos <= 0) {
            minutos = 1;
        }
        
        // Busca a pauta pelo ID
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        
        // Verifica se já existe uma sessão para esta pauta
        if (pauta.getSessao() != null) {
            throw new IllegalStateException("Esta pauta já possui uma sessão de votação");
        }
        
        // Cria a nova sessão
        Sessao sessao = new Sessao();
        sessao.setPauta(pauta);
        sessao.setDataAbertura(LocalDateTime.now());
        sessao.setDataFechamento(LocalDateTime.now().plusMinutes(minutos));
        
        return sessaoRepository.save(sessao);
    }
    
    public Optional<Sessao> buscarPorId(Long id) {
        return sessaoRepository.findById(id);
    }
}
