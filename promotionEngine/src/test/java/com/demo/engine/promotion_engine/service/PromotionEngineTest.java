package com.demo.engine.promotion_engine.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromotionEngineTest {


    private Map<String,Integer> cart =new HashMap<>();
    private PromotionEngine engine;

    @BeforeEach
    public void setUp() {
        Promotion bulkA = new BulkPromotion("A", 3, 130);
        Promotion bulkB = new BulkPromotion("B", 2, 45);
        Promotion bundleCD = new ComboPromotion("C", "D", 30);
        engine = new PromotionEngine(Arrays.asList(bulkA, bulkB, bundleCD));
    }

    @Test
    public void testScenarioA() {
        cart.put("A", 1);
        cart.put("B", 1);
        cart.put("C", 1);

        assertEquals(100, engine.calculateTotal(cart));
    }

    @Test
    public void testScenarioB() {
        cart.put("A", 5);
        cart.put("B", 5);
        cart.put("C", 1);

        assertEquals(370, engine.calculateTotal(cart));
    }

    @Test
    public void testScenarioC() {
        cart.put("A", 3);
        cart.put("B", 5);
        cart.put("C", 1);
        cart.put("D", 1);

        assertEquals(280, engine.calculateTotal(cart));
    }
}
