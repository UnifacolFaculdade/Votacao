package com.sylviavitoria.votacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sylviavitoria.votacao.dto.ResultadoVotacaoDTO;
import com.sylviavitoria.votacao.enums.OpcaoVoto;
import com.sylviavitoria.votacao.model.Associado;
import com.sylviavitoria.votacao.model.Pauta;
import com.sylviavitoria.votacao.model.Voto;
import com.sylviavitoria.votacao.repository.AssociadoRepository;
import com.sylviavitoria.votacao.repository.PautaRepository;
import com.sylviavitoria.votacao.repository.VotoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;
    
    @Autowired
    private PautaRepository pautaRepository;
    
    @Autowired
    private AssociadoRepository associadoRepository;
    
    public Voto registrarVoto(Long pautaId, Long associadoId, OpcaoVoto opcao) {
        Associado associado = associadoRepository.findById(associadoId)
                .orElseThrow(() -> new IllegalArgumentException("Associado não encontrado"));
        
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        
        if (pauta.getSessao() == null || !pauta.getSessao().isAberta()) {
            throw new IllegalStateException("Esta pauta não possui uma sessão aberta para votação");
        }
        
        if (votoRepository.findAll().stream()
                .anyMatch(v -> v.getAssociado().getId().equals(associadoId) && 
                         v.getPauta().getId().equals(pautaId))) {
            throw new IllegalStateException("O associado já votou nesta pauta");
        }

        Voto voto = new Voto();
        voto.setAssociado(associado);
        voto.setPauta(pauta);
        voto.setVotoFavoravel(opcao);
        voto.setDataVoto(LocalDateTime.now());
        
        return votoRepository.save(voto);
    }
    
    public ResultadoVotacaoDTO contabilizarVotos(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId)
                .orElseThrow(() -> new IllegalArgumentException("Pauta não encontrada"));
        
        if (pauta.getSessao() != null && pauta.getSessao().isAberta()) {
            throw new IllegalStateException("A sessão de votação ainda está aberta");
        }
        
        List<Voto> votos = votoRepository.findAll().stream()
                .filter(v -> v.getPauta().getId().equals(pautaId))
                .toList();

        int votosSim = (int) votos.stream()
                .filter(v -> v.getVotoFavoravel() == OpcaoVoto.SIM)
                .count();
        
        int votosNao = (int) votos.stream()
                .filter(v -> v.getVotoFavoravel() == OpcaoVoto.NAO)
                .count();
        
        ResultadoVotacaoDTO resultado = new ResultadoVotacaoDTO();
        resultado.setPautaId(pautaId);
        resultado.setTituloPauta(pauta.getTitulo());
        resultado.setTotalVotos(votos.size());
        resultado.setVotosSim(votosSim);
        resultado.setVotosNao(votosNao);
        resultado.setResultado(votosSim > votosNao ? "APROVADA" : "REPROVADA");
        
        return resultado;
    }
}
