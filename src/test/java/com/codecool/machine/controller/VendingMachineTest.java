package com.codecool.machine.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.codecool.machine.model.VendingModel;
import com.codecool.machine.view.VendingView;


class VendingMachineTest {
	private VendingModel vendingModel = new VendingModel();
	private VendingView vendingView = new VendingView();
	private VendingMachine vendingMachine;
	
	@Test
	public void testIncreaseMoney() {
		vendingMachine = new VendingMachine(vendingModel,vendingView);
		
	}

}
