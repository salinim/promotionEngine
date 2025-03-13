package com.demo.engine.promotion_engine.service;

import com.demo.engine.promotion_engine.model.SKU;

import java.util.Map;

public interface Promotion {
    int apply(Map<String, Integer> cart);
}
