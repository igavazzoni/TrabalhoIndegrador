package com.example.vendasapi.service;

import com.example.vendasapi.model.ItemVenda;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Service;
import com.example.vendasapi.repository.ItemVendaRepository;

import java.util.List;
import java.util.Optional;

@Service
@Tag(name = "ItemVenda Service", description = "Service da classe ItemVenda")
public class ItemVendaService {
    private final ItemVendaRepository itemVendaRepository;

    public ItemVendaService(ItemVendaRepository itemVendaRepository) {
        this.itemVendaRepository = itemVendaRepository;
    }
    public List<ItemVenda> getAll() {return this.itemVendaRepository.findAll();}

    public ItemVenda save(ItemVenda itemVenda) {return this.itemVendaRepository.save(itemVenda);}

    public void deleteById(int id){ this.itemVendaRepository.deleteById(id);}

    public Optional<ItemVenda> getById(int id) {return this.itemVendaRepository.findById(id);}

}
