package com.waldyr.restaurante.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    //length = tamanho da string. unique = não tá repetindo nomes. updatable = não pode alterar
    @Column(name = "comida", length = 50, unique = true)
    private String name;

    @NotBlank
    @Column(name = "descricao", length = 100)
    private String description;

    @NonNull
    @Min(value = 0)
    @Column(name = "valores", scale = 2)
    private BigDecimal price;

    @NotBlank
    @Column(name = "imagem")
    private String image;

    @Column(name = "status")
    private boolean active;

}