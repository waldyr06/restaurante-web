package com.waldyr.restaurante.repository;

import com.waldyr.restaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByActiveTrue();
}
