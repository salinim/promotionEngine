package com.demo.engine.promotion_engine;

import com.demo.engine.promotion_engine.service.BulkPromotion;
import com.demo.engine.promotion_engine.service.ComboPromotion;
import com.demo.engine.promotion_engine.service.Promotion;
import com.demo.engine.promotion_engine.service.PromotionEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication
public class PromotionEngineApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PromotionEngineApplication.class, args);
		PromotionEngineApplication promoEngine = new PromotionEngineApplication();
		promoEngine.scenarioA();
		promoEngine.scenarioB();
		promoEngine.scenarioC();

	}

	public Integer calculatePromotion(Map<String, Integer> cart){
		Promotion bulkA = new BulkPromotion("A", 3, 130);
		Promotion bulkB = new BulkPromotion("B", 2, 45);
		Promotion bundleCD = new ComboPromotion("C", "D", 30);
		PromotionEngine engine = new PromotionEngine(Arrays.asList(bulkA, bulkB, bundleCD));

		return engine.calculateTotal(cart);
	}

	public void scenarioA(){
		Map<String, Integer> cartA = new HashMap<>();
		cartA.put("A", 1);
		cartA.put("B", 1);
		cartA.put("C", 1);
		System.out.println("Total for Scenario A: " + calculatePromotion(cartA));
	}


	public void scenarioB(){
		Map<String, Integer> cartB = new HashMap<>();
		cartB.put("A", 5);
		cartB.put("B", 5);
		cartB.put("C", 1);
		System.out.println("Total Order Value for scenarioB: " + calculatePromotion(cartB));
	}

	public void scenarioC(){
		Map<String, Integer> cartC = new HashMap<>();
		cartC.put("A", 3);
		cartC.put("B", 5);
		cartC.put("C", 1);
		cartC.put("D", 1);
		System.out.println("Total Order Value for scenarioC: " + calculatePromotion(cartC));
	}





}
