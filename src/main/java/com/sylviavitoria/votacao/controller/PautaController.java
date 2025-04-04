package com.sylviavitoria.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sylviavitoria.votacao.model.Pauta;
import com.sylviavitoria.votacao.repository.PautaRepository;

@RestController
@RequestMapping("/api/v1/pautas")
public class PautaController {

    @Autowired
    private PautaRepository pautaRepository;

    @PostMapping
    public ResponseEntity<Pauta> criarPauta(@RequestBody Pauta pauta) {
        Pauta novaPauta = pautaRepository.save(pauta);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPauta);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pauta> buscarPautaPorId(@PathVariable Long id) {
        return pautaRepository.findById(id)
                .map(pauta -> ResponseEntity.ok(pauta))
                .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<Iterable<Pauta>> listarTodasPautas() {
        return ResponseEntity.ok(pautaRepository.findAll());
    }
}