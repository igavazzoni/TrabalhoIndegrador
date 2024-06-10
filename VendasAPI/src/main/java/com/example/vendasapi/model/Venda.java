package com.example.vendasapi.model;


import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Tag(name = "Modelo Venda", description = "Modelo da classe Venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double total;

    private String obs;

    private String data;

    @ManyToOne
    private Cliente cliente;

}
