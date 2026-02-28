package com.waldyr.restaurante.controller;


import com.waldyr.restaurante.model.Produto;
import com.waldyr.restaurante.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/lista")
    public String listar(Model model){
        List<Produto> listaDoCardapio = service.listarTodos();
        model.addAttribute("produtos", listaDoCardapio);
        return "produtos/lista";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovo(){
        return "produtos/formulario";
    }

    @PostMapping("/salvar")
    public String salvarProduto(Produto produtoPreenchido){
        service.salvar(produtoPreenchido);
        return "redirect:/admin/produtos/lista";
    }
}