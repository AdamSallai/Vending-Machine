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
	
	@Test
	public void testGetProductByNameWaterThrowsException() throws Exception {
		assertThrows(Exception.class, () -> {
			Product actualProduct = vendingModel.getProductByName("water");
		});
	
	}
	
	@Test
	public void testValidateCoin() {
		boolean valid1 = vendingModel.validateCoin(1);
		boolean valid2 = vendingModel.validateCoin(5);
		boolean valid3 = vendingModel.validateCoin(10);
		boolean valid4 = vendingModel.validateCoin(25);
		
		assertTrue(valid1);
		assertTrue(valid2);
		assertTrue(valid3);
		assertTrue(valid4);
	}
	

	@Test
	public void testValidateCoinWithInvalidParameter() {
		boolean invalid = vendingModel.validateCoin(0);
		
		assertFalse(invalid);
	}

	@Test
	public void testCalculateDifference() {
		int actual = vendingModel.calculateDifference(10, 5);
		
		assertEquals(5, actual);
	}
	
}
