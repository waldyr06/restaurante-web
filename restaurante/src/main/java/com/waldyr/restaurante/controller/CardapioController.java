package com.waldyr.restaurante.controller;

import com.waldyr.restaurante.model.Produto;
import com.waldyr.restaurante.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cardapio")
public class CardapioController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/comidas")
    public String listarAtivos(Model model){
        List<Produto> cardapio = service.listarApenasAtivos();
        model.addAttribute("produtos", cardapio);
        return "cliente/cardapio";
    }
}
