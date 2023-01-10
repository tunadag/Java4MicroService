package com.tunadag.service;

import com.tunadag.repository.IProductRepository;
import com.tunadag.repository.entity.Product;
import com.tunadag.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceManager<Product, Long> {

    private IProductRepository productRepository;

    public ProductService(IProductRepository repository){
        super(repository);
        this.productRepository = repository;
    }
}
