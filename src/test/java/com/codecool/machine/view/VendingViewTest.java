package com.codecool.machine.view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class VendingViewTest {
	private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private static final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private static final PrintStream originalOut = System.out;
	private static final PrintStream originalErr = System.err;
	private static final VendingView view = new VendingView();

	@BeforeAll
	public static void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@Test
	public void testSelectProductMessage() {
		String expectedMessage = "To select project please write Coke, Pepsi or Soda.\n";
		
		view.selectProductMessage();
		
		assertEquals(expectedMessage, outContent.toString());
		
	}
	

	@AfterAll
	public static void restoreStreams() {
	    System.setOut(originalOut);
	    System.setErr(originalErr);
	}


}
