package com.example.vendasapi.repository;

import com.example.vendasapi.model.ItemVenda;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Tag(name = "ItemVenda Repository", description = "Repository da classe Itemvenda")
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Integer> {

}
