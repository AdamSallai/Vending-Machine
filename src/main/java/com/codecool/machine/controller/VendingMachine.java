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
			} else {
				if(money < product.getCost()) {
					putCoinIn();
				}
			}
		}
		
	}
	
	private void putCoinIn() {
		
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
	

	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public Product getProduct() {
		return product;
	}
}
