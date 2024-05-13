package com.example.cardapio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.cardapio.product.Product;
import com.example.cardapio.product.ProductRepository;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    public ProductRepository repository;
    @GetMapping
    public List<Product> getAll(){
        List<Product> productsList = repository.findAll();
        return productsList;
    }
}
