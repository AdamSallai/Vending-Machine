package com.codecool.machine.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VendingModelTest {
	
	private VendingModel vendingModel = new VendingModel();
	
	@Test
	public void testGetProductByNameCoke() throws Exception {
		Product expectedProduct = Product.COKE;

		Product actualProduct = vendingModel.getProductByName("coke");
		
		assertEquals(expectedProduct, actualProduct);
		
	}
	
	@Test
	public void testGetProductByNamePepsi() throws Exception {
		Product expectedProduct = Product.PEPSI;

		Product actualProduct = vendingModel.getProductByName("pepsi");
		
		assertEquals(expectedProduct, actualProduct);
		
	}
	
	@Test
	public void testGetProductByNameSoda() throws Exception {
		Product expectedProduct = Product.SODA;

		Product actualProduct = vendingModel.getProductByName("soda");
		
		assertEquals(expectedProduct, actualProduct);
		
	}
}
