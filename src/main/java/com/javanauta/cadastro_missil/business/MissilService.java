package com.javanauta.cadastro_missil.business;

import com.javanauta.cadastro_missil.infrastructure.entitys.Missil;
import com.javanauta.cadastro_missil.infrastructure.repository.MissilRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MissilService {

    private final MissilRepository repository;

    public MissilService(MissilRepository repository) {
        this.repository = repository;
    }

    public List<Missil> listarTodosMisseis() {
        return repository.findAll();
    }

    public void salvarMissil(Missil missil){
        repository.saveAndFlush(missil);
    }

    public Missil buscarMissilPorNome(String nome){

        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Nome não encontrado")
        );
    }

    public void deletarMissilPorNome(String nome){
        repository.deleteByNome(nome);
    }

    public void atualizarMissilPorId(Integer id, Missil missil){
        Missil missilEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Missil não encontrado"));

        // Corrected update logic
        Missil missilAtualizado = Missil.builder()
                .id(missilEntity.getId()) // Keep the original ID
                .nome(missil.getNome() != null ? missil.getNome() : missilEntity.getNome())
                .pais(missil.getPais() != null ? missil.getPais() : missilEntity.getPais())
                .potencia(missil.getPotencia() != null ? missil.getPotencia() : missilEntity.getPotencia())
                .build();

        repository.saveAndFlush(missilAtualizado);
    }
}
