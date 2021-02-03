package com.codecool.machine.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.codecool.machine.model.Product;
import com.codecool.machine.model.VendingModel;
import com.codecool.machine.view.VendingView;


class VendingMachineTest {
	private VendingModel vendingModel = Mockito.mock(VendingModel.class);
	private VendingView vendingView = Mockito.mock(VendingView.class);
	private VendingMachine vendingMachine = new VendingMachine(vendingModel,vendingView);


	@Test
	public void testSelectProductWithValidInput() throws Exception {
	    String input = "coke";
	    Scanner scanner = new Scanner(input);
	    vendingMachine.setScanner(scanner);
	    Mockito.when(vendingModel.getProductByName(input)).thenReturn(Product.COKE);
	    
	    vendingMachine.selectProduct();
		
		assertEquals(Product.COKE, vendingMachine.getProduct());
		
	}

	@Test
	public void testSelectProductWithInvalidInput() throws Exception {
	    String input = "pasta";
	    Scanner scanner = new Scanner(input);
	    vendingMachine.setScanner(scanner);
	    Mockito.when(vendingModel.getProductByName(input)).thenThrow(new Exception());
	    
	    vendingMachine.selectProduct();
		
		assertNull(vendingMachine.getProduct());
		
	}
	
	@Test
	public void testPutCoinIn() {
	    String input = "1";
	    Scanner scanner = new Scanner(input);
	    vendingMachine.setScanner(scanner);
	    Mockito.when(vendingModel.validateCoin(Integer.parseInt(input))).thenReturn(true);

	    vendingMachine.setMoneyToZero();
		vendingMachine.putCoinIn();
		
		assertEquals(1, vendingMachine.getMoney());
		
	}
	
	@Test
	public void testPutCoinInWithInvalidInput() {
	    String input = "2";
	    Scanner scanner = new Scanner(input);
	    vendingMachine.setScanner(scanner);
	    Mockito.when(vendingModel.validateCoin(Integer.parseInt(input))).thenReturn(false);

	    vendingMachine.setMoneyToZero();
		vendingMachine.putCoinIn();
		
		assertEquals(0, vendingMachine.getMoney());
		
	}

	@Test
	public void testTransactionFinish() {
		vendingMachine.setProduct(Product.COKE);
		vendingMachine.setMoney(25);
		
		vendingMachine.transactionFinish();
		
		assertEquals(0, vendingMachine.getMoney());
		assertNull(vendingMachine.getProduct());
	}
}






