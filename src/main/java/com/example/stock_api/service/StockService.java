package com.example.stock_api.service;

import com.example.stock_api.repository.StockRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void createOrUpdateStock(Long productId, int stock) {
        repository.upsertStock(productId, stock, 0, 0);
    }

    @Transactional
    public void sell(Long productId, int quantity) {
        repository.addSell(productId, quantity);
    }

    @Transactional
    public void ingress(Long productId, int quantity) {
        repository.addIngress(productId, quantity);
    }

    public int getTotal(Long productId) {
        return repository.getTotal(productId);
    }
}
