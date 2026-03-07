package com.waldyr.restaurante.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Entity //Criando banco de dados
@Data //Getters e Setters
@NoArgsConstructor //Construtor vazio
@AllArgsConstructor //Construtor preenchido
public class Produto {

    @Id //Chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank //Não pode ser vazio
    //length = tamanho da string. unique = não tá repetindo nomes.
    @Column(name = "comida", length = 50, unique = true)
    private String name;

    @NotBlank
    @Column(name = "descricao", length = 100)
    private String description;

    @NonNull
    @Min(value = 0) //Definindo um valor mínimo
    @Column(name = "valores", scale = 2)
    private BigDecimal price; //Bigdecimal para termos precisão nas contas

    @Column(name = "imagem")
    private String image;

    @Column(name = "status")
    private boolean active;

}