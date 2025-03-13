package com.demo.engine.promotion_engine.model;

import java.util.HashMap;
import java.util.Map;

public class SKUPrices {

    private static final Map<String, Integer> sKUPrices = new HashMap<>();

    static {
        sKUPrices.put("A", 50);
        sKUPrices.put("B", 30);
        sKUPrices.put("C", 20);
        sKUPrices.put("D", 15);
    }

    public static int getSKUPrice(String sku) {
        return sKUPrices.getOrDefault(sku, 0);
    }
}