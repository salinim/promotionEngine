package com.demo.engine.promotion_engine.service;

import com.demo.engine.promotion_engine.model.SKU;

import java.util.Map;

public class BulkPromotion implements Promotion{

    private String skuId;
    private int quantity;
    private int fixedPrice;

    public BulkPromotion(String skuId, int quantity, int fixedPrice) {
        this.skuId = skuId;
        this.quantity = quantity;
        this.fixedPrice = fixedPrice;
    }

    @Override
    public int apply(Map<String, Integer> cart) {
        if (!cart.containsKey(skuId) || cart.get(skuId) < quantity) return 0;

        int count = cart.get(skuId);
        int promoSets = count / quantity;
        int remaining = count % quantity;

        cart.put(skuId, remaining);

        return promoSets * fixedPrice;
    }
}
