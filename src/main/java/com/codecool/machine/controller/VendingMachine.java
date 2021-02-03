package com.codecool.machine.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
	private Map<Product, Integer> productInventory;
	
	
	public VendingMachine(VendingModel model, VendingView view) {
		this.model = model;
		this.view = view;
		setScanner(new Scanner(System.in));
		productInventory = new HashMap<Product, Integer>();
		Arrays.stream(Product.values()).forEach(product -> {
			productInventory.put(product, 0);
		});
	}

	public void run() {
		boolean exit = false;
		
		while(!exit) {
			if(product == null) {
				System.out.println(productInventory);
				selectProduct();
			}
			if(product != null && money < product.getCost()) {
				putCoinIn();
			}
			if(product != null && product.getCost() <= money) {
				transactionFinish();
			}
		}
		
	}
	
	public void transactionFinish() {
		String name = product.name();
		int coin = model.calculateDifference(product.getCost(), money);
		view.transactionSuccessMessage(name, coin);
		setMoneyToZero();
		model.addToInventory(productInventory, product);
		product = null;
	}

	public void putCoinIn() {
		view.putCoinMessage();
		String coin = scanner.next();
		boolean validCoin = false;
		if(coin.matches("-?\\d+") && model.validateCoin(Integer.parseInt(coin))) {
			money += Integer.parseInt(coin);
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
