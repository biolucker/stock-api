package com.example.stock_api.controller;


import com.example.stock_api.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    // Create or update stock
    @PostMapping("/{productId}")
    public void createOrUpdate(
            @PathVariable Long productId,
            @RequestParam int stock
    ) {
        service.createOrUpdateStock(productId, stock);
    }

    // Sell product
    @PostMapping("/{productId}/sell")
    public void sell(
            @PathVariable Long productId,
            @RequestParam int quantity
    ) {
        service.sell(productId, quantity);
    }

    // Ingress stock
    @PostMapping("/{productId}/ingress")
    public void ingress(
            @PathVariable Long productId,
            @RequestParam int quantity
    ) {
        service.ingress(productId, quantity);
    }

    // Get total
    @GetMapping("/{productId}/total")
    public int getTotal(@PathVariable Long productId) {
        return service.getTotal(productId);
    }
}