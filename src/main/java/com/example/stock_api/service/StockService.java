package com.example.stock_api.service;

import com.example.stock_api.repository.StockRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StockService {

    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    public void createOrUpdateStock(Long productId, int stock) {
        stockRepository.upsertStock(productId, stock, 0, 0);
    }

    @Transactional
    public void sellProduct(Long productId, int quantity) {
        try {
            stockRepository.addSell(productId, quantity);
        } catch (DataAccessException ex) {
            if (ex.getRootCause() != null &&
                    ex.getRootCause().getMessage().contains("Not enough stock")) {

                throw new IllegalStateException("Not enough stock available");
            }
            throw ex;
        }
    }

    @Transactional
    public void ingress(Long productId, int quantity) {
        stockRepository.addIngress(productId, quantity);
    }

    public int getTotal(Long productId) {
        return stockRepository.getTotal(productId);
    }

}
