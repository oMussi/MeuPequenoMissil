package com.javanauta.cadastro_missil.infrastructure.repository;

import com.javanauta.cadastro_missil.infrastructure.entitys.Missil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MissilRepository extends JpaRepository<Missil, Integer> {

    Optional<Missil> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);
}
