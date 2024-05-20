package com.example.cardapio.controllers;

import com.example.cardapio.domain.product.Product;
import com.example.cardapio.domain.product.ProductRepository;
import com.example.cardapio.domain.product.RequestProduct;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    @PutMapping
    @Transactional
    public ResponseEntity updateProduct (@RequestBody @Valid RequestProduct data){
        Optional<Product> produtoExistente = repository.findById(data.id());
                if(produtoExistente.isPresent()){
                    Product product = produtoExistente.get();
                    product.setNome(data.nome());
                    product.setPreco(data.preco());
                    product.setDescricao(data.descricao());

                    return ResponseEntity.ok(product);
                } else{
                    return ResponseEntity.notFound().build();

                }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarProduto(@PathVariable String id) {
        Optional<Product> produtoExistente = repository.findById(id);
        if (produtoExistente.isPresent()) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
