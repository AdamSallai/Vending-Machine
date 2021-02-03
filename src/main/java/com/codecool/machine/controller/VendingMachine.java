package com.codecool.machine.controller;

import java.util.Scanner;

import com.codecool.machine.model.Product;
import com.codecool.machine.model.VendingModel;
import com.codecool.machine.view.VendingView;

public class VendingMachine {
	
	private VendingModel model;
	private VendingView view;
	private Product product = null;
	private Scanner scanner;
	private int money = 0;
	
	
	public VendingMachine(VendingModel model, VendingView view) {
		this.model = model;
		this.view = view;
		setScanner(new Scanner(System.in));
	}

	public void run() {
		boolean exit = false;
		
		while(!exit) {
			if(product == null) {
				selectProduct();
			}
			if(product == null && money < product.getCost()) {
				putCoinIn();
			}
			if(product == null && product.getCost() <= money) {
				transactionFinish();
			}
		}
		
	}
	
	public void transactionFinish() {
		String name = product.name();
		int coin = model.calculateDifference(product.getCost(), money);
		view.transactionSuccessMessage(name, coin);
		setMoneyToZero();
		product = null;
	}

	public void putCoinIn() {
		view.putCoinMessage();
		int coin = scanner.nextInt();
		if(model.validateCoin(coin)) {
			money += coin;
		} else {
			view.invalidCoinMessage();
		}
	}

	public void selectProduct() {
		view.selectProductMessage();
		String productName = scanner.next();
		try {
			product = model.getProductByName(productName);
		} catch (Exception e) {
			view.invalidProductMessage();
		}
	}
	
	public int getMoney() {
		return money;
	}
	
	public void setMoneyToZero() {
		money = 0;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
