package com.waldyr.restaurante.service;

import com.waldyr.restaurante.model.Produto;
import com.waldyr.restaurante.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public void inativar(Long id) {
        produtoRepository.findById(id).ifPresent(produto -> {
            produto.setActive(true);
            produtoRepository.save(produto);
        });
    }
}