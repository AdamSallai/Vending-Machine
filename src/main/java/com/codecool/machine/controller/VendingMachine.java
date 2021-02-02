package com.codecool.machine.controller;

import java.util.Scanner;

import com.codecool.machine.model.Product;
import com.codecool.machine.model.VendingModel;
import com.codecool.machine.view.VendingView;

public class VendingMachine {
	
	private VendingModel model;
	private VendingView view;
	private Product product;
	private Scanner scanner;
	
	
	public VendingMachine(VendingModel model, VendingView view) {
		this.model = model;
		this.view = view;
		setScanner(new Scanner(System.in));
	}


	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
}
