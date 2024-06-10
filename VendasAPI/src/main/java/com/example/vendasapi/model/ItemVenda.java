package com.example.vendasapi.model;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Tag(name = "Modelo ItemVenda", description = "Modelo da classe ItemVenda")
public class ItemVenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int quant;

    private double valorUnitario;

    private double valorTotal;

    @ManyToOne
    private Venda venda;

    @ManyToOne
    private Produto produto;
}
