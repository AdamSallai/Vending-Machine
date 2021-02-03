package com.codecool.machine.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.management.modelmbean.ModelMBean;

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
		int actual = vendingModel.calculateDifference(5, 10);
		
		assertEquals(5, actual);
	}
	
	@Test
	public void testAddToConsumption() {
		Map<Product, Integer> consumption = new HashMap<Product, Integer>();
		consumption.put(Product.COKE, 0);
		vendingModel.addToConsumption(consumption, Product.COKE);
		vendingModel.addToConsumption(consumption, Product.PEPSI);
		
		assertEquals(1, consumption.get(Product.COKE));
		assertEquals(0, consumption.get(Product.PEPSI));
	}

	@Test
	public void testDecreaseInventory() {
		Map<Product, Integer> inventory = new HashMap<Product, Integer>();
		inventory.put(Product.COKE, 3);
		vendingModel.decreaseInventory(inventory, Product.COKE);
		
		assertEquals(2, inventory.get(Product.COKE));
	}
	
	@Test
	public void testProductIsInInventory() {
		Map<Product, Integer> productInventory = new HashMap<Product, Integer>();
		productInventory.put(Product.COKE, 2);
		productInventory.put(Product.PEPSI, 0);
		
		boolean valid = vendingModel.productIsInInventory(Product.COKE, productInventory);
		boolean invalid = vendingModel.productIsInInventory(Product.PEPSI, productInventory);
		
		assertTrue(valid);
		assertFalse(invalid);
	}
	
}
