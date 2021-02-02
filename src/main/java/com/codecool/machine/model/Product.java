package com.codecool.machine.model;

public enum Product {
	COKE(25), 
	PEPSI(35), 
	SODA(45);

	
	private int cost;
	
	private Product(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}

}
