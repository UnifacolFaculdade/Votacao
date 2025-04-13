package com.faculdade.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.faculdade.votacao.dto.ResultadoVotacaoDTO;
import com.faculdade.votacao.dto.VotoDTO;
import com.faculdade.votacao.model.Voto;
import com.faculdade.votacao.service.VotoService;

@RestController
@RequestMapping("/api/v1/votos")
public class VotoController {

    @Autowired
    private VotoService votoService;
    
    @PostMapping
    public ResponseEntity<Voto> registrarVoto(@RequestBody VotoDTO voto) {
        try {
            Voto novoVoto = votoService.registrarVoto(
                voto.getPautaId(), 
                voto.getAssociadoId(), 
                voto.getOpcao()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(novoVoto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    
    @GetMapping("/resultado/{pautaId}")
    public ResponseEntity<ResultadoVotacaoDTO> contabilizarVotos(@PathVariable Long pautaId) {
        try {
            ResultadoVotacaoDTO resultado = votoService.contabilizarVotos(pautaId);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}