package com.codecool.machine.model;


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

}
