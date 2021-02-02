package com.codecool.machine.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VendingViewTest {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private static final PrintStream originalOut = System.out;
	private static final PrintStream originalErr = System.err;
	private static final VendingView view = new VendingView();
	private static final String os = System.getProperty("os.name");

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void testSelectProductMessage() {
		String expectedMessage = "To select project please write Coke, Pepsi or Soda.\n";

		view.selectProductMessage();

		assertEquals(expectedMessage, outContent.toString());

	}

	@Test
	public void testPutCoinInMessage() {
		String expectedMessage = "Put in a coin (1, 5, 10 or 25).\n";

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

	@AfterEach
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
		outContent.reset();
		errContent.reset();
	}

}
