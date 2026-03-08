package com.waldyr.restaurante.controller;

import com.waldyr.restaurante.model.Produto;
import com.waldyr.restaurante.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

@Controller //Indicando que vai receber requisições HTTP
@RequestMapping("/admin/cardapio") //Definindo o prefixo da URL para todas as rotas daqui
@SessionAttributes("carrinho") //Se alguma coisa tem a etiqueta "carrinho", guarde na memória
public class CardapioController {

    @Autowired //Injetando o ProdutoService
    private ProdutoService service;

    @GetMapping("/comidas")
    public String listarAtivos(Model model){
        List<Produto> cardapio = service.listarApenasAtivos();
        model.addAttribute("produtos", cardapio);
        return "cliente/cardapio";
    }

    @ModelAttribute("carrinho")
    public List<Produto> inicializarCarrinho(){
        return new ArrayList<>();
    }

    @GetMapping("/adicionar/{id}")
    public String adicionarAoCarrinho(
            @PathVariable Long id,
            @ModelAttribute("carrinho") List<Produto> carrinho)
    {
        Produto pratoEscolhido = service.buscarPorId(id);
        carrinho.add(pratoEscolhido);
        return "redirect:/admin/cardapio/comidas";
    }

    @GetMapping("/resumo")
    public String resumoDoPedido(
            @ModelAttribute("carrinho") List<Produto> carrinho,
            Model model
    ){
        BigDecimal totalDaConta = BigDecimal.ZERO;

        for (Produto prato : carrinho) {
            totalDaConta = totalDaConta.add(prato.getPrice());
        }

        model.addAttribute("total", totalDaConta);

        return "cliente/resumo";
    }

    @GetMapping("/finalizar")
    public String finalizarPedido(
            @ModelAttribute("carrinho") List<Produto> carrinho
    ){
        carrinho.clear();

        return "redirect:/admin/cardapio/comidas";
    }
}