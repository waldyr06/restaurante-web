package com.waldyr.restaurante.repository;

import com.waldyr.restaurante.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
