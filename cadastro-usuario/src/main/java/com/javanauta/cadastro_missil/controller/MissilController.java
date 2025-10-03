package com.javanauta.cadastro_missil.controller; // Correct package for a controller

import com.javanauta.cadastro_missil.business.MissilService;
import com.javanauta.cadastro_missil.infrastructure.entitys.Missil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/missil") // Base path for all endpoints in this controller
public class MissilController {

    private final MissilService missilService;

    // Dependency Injection of the service
    public MissilController(MissilService missilService) {
        this.missilService = missilService;
    }

    @PostMapping
    public ResponseEntity<Void> salvarMissil(@RequestBody Missil missil) {
        missilService.salvarMissil(missil);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/buscar") // Changed from @GetMapping
    public ResponseEntity<Missil> buscarMissilPorNome(@RequestParam("nome") String nome) {
        return ResponseEntity.ok(missilService.buscarMissilPorNome(nome));
    }

    @GetMapping
    public ResponseEntity<List<Missil>> listarTodos() {
        return ResponseEntity.ok(missilService.listarTodosMisseis());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarMissil(@PathVariable("id") Integer id, @RequestBody Missil missil) {
        missilService.atualizarMissilPorId(id, missil);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarMissilPorNome(@RequestParam("nome") String nome) {
        missilService.deletarMissilPorNome(nome);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}