package com.demo.engine.promotion_engine.service;

import com.demo.engine.promotion_engine.model.SKU;
import com.demo.engine.promotion_engine.model.SKUPrices;

import java.util.List;
import java.util.Map;

public class PromotionEngine {

    private List<Promotion> promotions;

    public PromotionEngine(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    public int calculateTotal(Map<String, Integer> cart) {
        int total = 0;

        for (Promotion promo : promotions) {
            total += promo.apply(cart);
        }

        // Calculate remaining items without promotion
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += entry.getValue() * SKUPrices.getSKUPrice(entry.getKey());
        }

        return total;
    }
}
