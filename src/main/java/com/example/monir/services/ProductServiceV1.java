package com.example.monir.services;

import com.example.monir.entity.Product;
import com.example.monir.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceV1 {

    @Autowired
    private ProductRepository productRepository;


    public Mono<Product> getProduct(int id){
        return this.productRepository.findById(id);
    }

    public Mono<Product> updateProduct(int id, Mono<Product> productMono){
        return this.productRepository.findById(id)
                .flatMap(p-> productMono.doOnNext(pr->pr.setId(id)))
                .flatMap(this.productRepository::save);
    }
}
