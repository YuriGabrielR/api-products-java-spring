package com.example.cardapio.domain.product;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "product")
@EqualsAndHashCode(of ="id")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;
    private Integer preco;
    private String descricao;

    public Product(RequestProduct requestProduct){
        this.nome = requestProduct.nome();
        this.preco = requestProduct.preco();
        this.descricao = requestProduct.descricao();
    }
}
