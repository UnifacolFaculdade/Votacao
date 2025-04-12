package com.sylviavitoria.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sylviavitoria.votacao.model.Pauta;
import com.sylviavitoria.votacao.repository.PautaRepository;
import com.sylviavitoria.votacao.service.PautaService;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {

    @Autowired
    private PautaService pautaService;

    @PostMapping
    public ResponseEntity<Pauta> cadastrarPauta(@RequestBody Pauta pauta) {
        Pauta novaPauta = pautaService.cadastrar(pauta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPauta);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pauta> buscarPautaPorId(@PathVariable Long id) {
        return pautaService.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<Iterable<Pauta>> listarTodasPautas() {
        return ResponseEntity.ok(pautaService.listarTodas());
    }
}