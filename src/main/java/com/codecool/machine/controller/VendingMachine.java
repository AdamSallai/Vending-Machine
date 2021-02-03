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
	private Map<Product, Integer> productConsumption;
	private Map<Product, Integer> productInventory;
	
	
	public VendingMachine(VendingModel model, VendingView view) {
		this.model = model;
		this.view = view;
		setScanner(new Scanner(System.in));
		productConsumption = new HashMap<Product, Integer>();
		productInventory = new HashMap<Product, Integer>();
		Arrays.stream(Product.values()).forEach(product -> {
			productConsumption.put(product, 0);
		});
		Arrays.stream(Product.values()).forEach(product -> {
			productInventory.put(product, 10);
		});
	}

	public void run() {
		boolean exit = false;
		
		while(!exit) {
			if(product == null) {
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
		model.addToConsumption(productConsumption, product);
		model.decreaseInventory(productInventory, product);
		product = null;
		view.consumptionMessage(productConsumption);
		view.inventoryMessage(productInventory);
	}

	public void putCoinIn() {
		view.putCoinMessage();
		String input = scanner.next();

		if(!checkIfRefund(input)) {
			if(input.matches("-?\\d+") && model.validateCoin(Integer.parseInt(input))) {
				money += Integer.parseInt(input);
			} else {
				view.invalidCoinMessage();
			}
		} else {
			refund();
		}
	}
	

	public void selectProduct() {
		view.selectProductMessage();
		String input = scanner.next();
		if(!checkIfRefund(input)) {
			try {
				product = model.getProductByName(input);
			} catch (Exception e) {
				view.invalidProductMessage();
			}
		}else {
			refund();
		}
	}
	
	public void refund() {
		view.refundMessage(money);
		setMoneyToZero();
		product = null;
	}
	
	public boolean checkIfRefund(String input) {
		if(input == "refund") {
			return true;
		}
		return false;
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
