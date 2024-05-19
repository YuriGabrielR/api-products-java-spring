package com.example.cardapio.controllers;

import com.example.cardapio.domain.product.Product;
import com.example.cardapio.domain.product.ProductRepository;
import com.example.cardapio.domain.product.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController{
    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public  ResponseEntity addProduct (@RequestBody @Valid RequestProduct data){
        Product novoProduto = new Product(data);
        repository.save(novoProduto);
        return ResponseEntity.ok().build();
    }
}
