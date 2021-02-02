package com.codecool.machine.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingModelTest {
	
	private VendingModel vendingModel = new VendingModel();
	
	@Test
	public void testGetProductByName() throws Exception {
		Product expectedProduct = Product.COKE;

		Product actualProduct = vendingModel.getProductByName("coke");
		
		assertEquals(expectedProduct, actualProduct);
		
	}
}
