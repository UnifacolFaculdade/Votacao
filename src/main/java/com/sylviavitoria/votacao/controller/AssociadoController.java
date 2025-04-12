package com.sylviavitoria.votacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sylviavitoria.votacao.model.Associado;
import com.sylviavitoria.votacao.service.AssociadoService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/associados")
public class AssociadoController {

    @Autowired
    private AssociadoService associadoService;
    
    @PostMapping
    public ResponseEntity<?> cadastrarAssociado(@RequestBody Associado associado) {
        try {
            Associado novoAssociado = associadoService.cadastrar(associado);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoAssociado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Não foi possível cadastrar o associado. O CPF já pode estar em uso.");
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Associado> buscarPorId(@PathVariable Long id) {
        return associadoService.buscarPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Associado>> listarTodos() {
        return ResponseEntity.ok(associadoService.listarTodos());
    }
}
