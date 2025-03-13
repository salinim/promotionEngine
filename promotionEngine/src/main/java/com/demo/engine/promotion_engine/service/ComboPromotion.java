package com.demo.engine.promotion_engine.service;

import com.demo.engine.promotion_engine.model.SKU;

import java.util.Map;

public class ComboPromotion implements Promotion{

    private String skuId1;
    private String skuId2;
    private int fixedPrice;

    public ComboPromotion(String skuId1, String skuId2, int fixedPrice) {
        this.skuId1 = skuId1;
        this.skuId2 = skuId2;
        this.fixedPrice = fixedPrice;
    }

    @Override
    public int apply(Map<String, Integer> cart) {
        if (!cart.containsKey(skuId1) || !cart.containsKey(skuId2)) return 0;

        int count1 = cart.get(skuId1);
        int count2 = cart.get(skuId2);
        int promoSets = Math.min(count1, count2);

        cart.put(skuId1, count1 - promoSets);
        cart.put(skuId2, count2 - promoSets);

        return promoSets * fixedPrice;
    }
}
