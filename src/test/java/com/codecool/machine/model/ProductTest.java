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
}
