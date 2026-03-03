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

    public List<Produto> listarApenasAtivos(){
        return produtoRepository.findByActiveTrue();
    }

    public void inativarOuAtivar(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.setActive(!produto.isActive());
        produtoRepository.save(produto);
    }

    public Produto buscarPorId(Long id){
        return produtoRepository.findById(id).orElseThrow();
    }
}