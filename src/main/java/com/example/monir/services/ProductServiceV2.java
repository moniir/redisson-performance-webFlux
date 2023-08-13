package com.example.monir.services;


import com.example.monir.entity.Product;
import com.example.monir.services.util.CacheTemplate;
import com.example.monir.services.util.ProductCacheTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceV2 {

    @Autowired
    private CacheTemplate<Integer, Product> cacheTemplate;

    public Mono<Product> getProduct(int id){
        return this.cacheTemplate.get(id);
    }

    public Mono<Product> updateProduct(int id, Mono<Product> productMono){
        return productMono.flatMap(p-> this.cacheTemplate.update(id,p));
    }

    public Mono<Void> deleteProduct(int id){
        return this.cacheTemplate.delete(id);
    }


}
