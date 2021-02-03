package com.codecool.machine.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

import com.codecool.machine.model.Product;
import com.codecool.machine.model.VendingModel;
import com.codecool.machine.view.VendingView;


class VendingMachineTest {
	private VendingModel vendingModel = new VendingModel();
	private VendingView vendingView = new VendingView();
	private VendingMachine vendingMachine = new VendingMachine(vendingModel,vendingView);

	@Test
	public void testIncreaseMoney() {
		
	}

	@Test
	public void testSelectProductWithValidInput() {
	    String input = "coke";

	    Scanner scanner = new Scanner(input);
	    vendingMachine.setScanner(scanner);
	    vendingMachine.selectProduct();
		
		assertEquals(Product.COKE, vendingMachine.getProduct());
		
	}

	@Test
	public void testSelectProductWithInvalidInput() {
	    String input = "pasta";

	    Scanner scanner = new Scanner(input);
	    vendingMachine.setScanner(scanner);
	    vendingMachine.selectProduct();
		
		assertNull(vendingMachine.getProduct());
		
	}
	
}
