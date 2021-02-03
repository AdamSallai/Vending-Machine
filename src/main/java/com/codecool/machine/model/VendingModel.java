package com.codecool.machine.model;

import java.util.Map;

public class VendingModel {

	public Product getProductByName(String productName) throws Exception {
		productName = productName.toLowerCase();
		switch (productName) {
			case "coke":
				return Product.COKE;
			case "pepsi":
				return Product.PEPSI;
			case "soda":
				return Product.SODA;
			default:
				throw new Exception();
		}
	}

	public boolean validateCoin(int coin) {
		return coin == 1 || coin == 5 || coin == 10 || coin == 25;
	}

	public int calculateDifference(int productCost, int userCurrentMoney) {
		return userCurrentMoney - productCost;
	}

	public void addToConsumption(Map<Product, Integer> productInventory, Product product) {
		try {
			int newAmount = productInventory.get(product) + 1;
			productInventory.put(product, newAmount);
		} catch (Exception e) {
			productInventory.put(product, 0);
		}

	}

	public void decreaseInventory(Map<Product, Integer> productInventory, Product product) {
		// TODO Auto-generated method stub
		
	}

}
