package com.faculdade.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.faculdade.votacao.dto.AberturaSessaoDTO;
import com.faculdade.votacao.model.Sessao;
import com.faculdade.votacao.service.SessaoService;

@RestController
@RequestMapping("/api/v1/sessoes")
public class SessaoController {

    @Autowired
    private SessaoService sessaoService;
    
    @PostMapping
    public ResponseEntity<Sessao> abrirSessao(@RequestBody AberturaSessaoDTO dto) {
        try {
            Sessao sessao = sessaoService.abrirSessao(dto.getPautaId(), dto.getMinutos());
            return ResponseEntity.status(HttpStatus.CREATED).body(sessao);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Sessao> buscarSessao(@PathVariable Long id) {
        return sessaoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
