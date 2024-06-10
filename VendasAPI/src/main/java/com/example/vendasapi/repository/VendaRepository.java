package com.example.vendasapi.repository;

import com.example.vendasapi.model.Venda;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "Repository Venda", description = "Repository da classe Venda")
public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
