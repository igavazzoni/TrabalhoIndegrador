package com.example.vendasapi.repository;

import com.example.vendasapi.model.Cliente;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "Cliente Repository", description = "Repository da classe Cliente")
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
