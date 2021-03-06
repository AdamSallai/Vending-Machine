package com.codecool.machine.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductTest {

	@Test
	public void testCokeProductCost() {
		Product cokeProduct = Product.COKE;
		
		int cost = cokeProduct.getCost();
		
		assertEquals(25, cost);
	}
	
	@Test
	public void testPepsiProductCost() {
		Product pepsiProduct = Product.PEPSI;
		
		int cost = pepsiProduct.getCost();
		
		assertEquals(35, cost);
	}
	
	@Test
	public void testSodaProductCost() {
		Product sodaProduct = Product.SODA;
		
		int cost = sodaProduct.getCost();
		
		assertEquals(45, cost);
	}
}
