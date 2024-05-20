package com.example.cardapio.domain.product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record RequestProduct(
        String id,
        @NotBlank
        String nome,
        @NotNull
        Integer preco,
        String descricao ) {

}
