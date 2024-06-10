package com.example.vendasapi.controller;

import com.example.vendasapi.model.Venda;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.vendasapi.service.VendaService;

import java.util.List;

@Controller
@Tag(name = "Vendas WEB", description = "Controllador Web conectado ao HTML")
public class VendaWebController {
    private final VendaService vendaService;

    public VendaWebController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping(path = "/venda/save")
    public String saveVenda(Venda venda){
        vendaService.save(venda);
        return "redirect:/venda";
    }

    @GetMapping(path = "venda")
    public String getAllVenda(Model model){
        List<Venda> venda = vendaService.getAll();
        model.addAttribute("vendas", venda);
        return "venda";
    }


}
