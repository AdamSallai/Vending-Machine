package com.codecool.machine.view;

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
}
