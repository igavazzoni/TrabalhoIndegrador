package com.example.vendasapi.repository;

import com.example.vendasapi.model.Produto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "Produto Repository", description = "Repository da classe produto")
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {


}
