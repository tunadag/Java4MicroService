package com.tunadag.service;

import com.tunadag.repository.ISalesRepository;
import com.tunadag.repository.entity.Sale;
import com.tunadag.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class SaleService extends ServiceManager<Sale, Long> {

    private final ISalesRepository repository;

    public SaleService(ISalesRepository repository){
        super(repository);
        this.repository = repository;
    }
}
