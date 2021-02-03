package com.codecool.machine.view;

import java.util.Map;

import com.codecool.machine.model.Product;

public class VendingView {

	public void selectProductMessage() {
		System.out.println("To select product please write Coke, Pepsi or Soda.");
	}

	public void putCoinMessage() {
		System.out.println("Put in a coin (1, 5, 10 or 25).");
	}

	public void invalidCoinMessage() {
		System.out.println("The machine didn't accept your coin! It only accepts 1, 5, 10 or 25.");

	}

	public void refundMessage(int coin) {
		System.out.println("Your " + coin + " coins are refunded.");
	}

	public void transactionSuccessMessage(String name, int coin) {
		System.out.println("You successfully bought a " + name + ". Returning " + coin + " coins.");
	}

	public void invalidProductMessage() {
		System.out.println("The product you chose doesn't exist. Try again.");
	}

	public void consumptionMessage(Map<Product, Integer> productConsumption) {
		System.out.println("Total consumption: " + productConsumption.toString()); 
	}

	public void inventoryMessage(Map<Product, Integer> productInventory) {
		System.out.println("Products left in inventory: " + productInventory.toString()); 
	}
	
	public void productIsNotInInventoryMessage(String productName) {
		System.out.println(productName+" is not in inventory."); 
	}
}
