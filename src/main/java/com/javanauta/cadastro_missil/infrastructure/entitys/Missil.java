package com.javanauta.cadastro_missil.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "missil")
@Entity
public class Missil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nome", unique = true)
    private String nome;

    @Column(name = "pais")
    private String pais;

    @Column(name = "potencia")
    private String potencia;


}
