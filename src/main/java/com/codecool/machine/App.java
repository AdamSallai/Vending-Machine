package com.codecool.machine;

import com.codecool.machine.controller.VendingMachine;
import com.codecool.machine.model.VendingModel;
import com.codecool.machine.view.VendingView;

public class App {
	public static void main(String[] args) {
		
		VendingModel model = new VendingModel();
		VendingView view = new VendingView();
		VendingMachine vendingMachine = new VendingMachine(model, view);
		
		vendingMachine.run();
		
	}
}
