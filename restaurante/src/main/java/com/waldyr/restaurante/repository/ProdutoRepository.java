package com.waldyr.restaurante.repository;

import com.waldyr.restaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByActiveTrue();
}

//Produto é a entidade que vira tabela no banco de dados.
//Long é o tipo da chave primária (id).
//Em resumo essa interface vai tá listando todos os produtos que estiverem ativos.