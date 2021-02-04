package com.codecool.machine.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codecool.machine.model.Product;

class VendingViewTest {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;
	private final VendingView view = new VendingView();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void testSelectProductMessage() {
		String expectedMessage = "To select product please write Coke(25), Pepsi(35) or Soda(45).\n";

		view.selectProductMessage();

		assertEquals(expectedMessage, outContent.toString());

	}

	@Test
	public void testPutCoinInMessage() {
		String expectedMessage = "Put in a coin (1, 5, 10 or 25 or write 'refund' to cancel).\n";

		view.putCoinMessage();

		assertEquals(expectedMessage, outContent.toString());

	}

	@Test
	public void testInvalidCoinMessage() {
		String expectedMessage = "The machine didn't accept your coin! It only accepts 1, 5, 10 or 25.\n";

		view.invalidCoinMessage();

		assertEquals(expectedMessage, outContent.toString());

	}
	
	@Test
	public void testRefundMessage() {
		String expectedMessage = "Your 25 coins are refunded.\n";

		view.refundMessage(25);

		assertEquals(expectedMessage, outContent.toString());

	}
	
	@Test
	public void testTransactionSuccessMessage() {
		String expectedMessage = "You successfully bought a Soda. Returning 5 coins.\n";

		view.transactionSuccessMessage("Soda", 5);

		assertEquals(expectedMessage, outContent.toString());

	}
	
	@Test
	public void testInvalidProductMessage() {
		String expectedMessage = "The product you chose doesn't exist. Try again.\n";

		view.invalidProductMessage();

		assertEquals(expectedMessage, outContent.toString());

	}
	
	@Test
	public void testConsumptionMessage() {
		String expectedMessage = "Total consumption: {COKE=2}\n";
		Map<Product, Integer> consumption = new HashMap<Product, Integer>();
		consumption.put(Product.COKE, 2);
		
		view.consumptionMessage(consumption);

		assertEquals(expectedMessage, outContent.toString());
	}
	
	@Test
	public void testInventorynMessage() {
		String expectedMessage = "Products left in inventory: {COKE=2}\n";
		Map<Product, Integer> inventory = new HashMap<Product, Integer>();
		inventory.put(Product.COKE, 2);
		
		view.inventoryMessage(inventory);

		assertEquals(expectedMessage, outContent.toString());
	}

	@Test
	public void testProductIsNotInInventoryMessage() {
		String expectedMessage = "COKE is not in inventory.\n";
		
		view.productIsNotInInventoryMessage(Product.COKE.name());

		assertEquals(expectedMessage, outContent.toString());
	}
	

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
		outContent.reset();
		errContent.reset();
	}

}
