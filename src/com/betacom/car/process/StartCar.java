package com.betacom.car.process;

import java.util.List;

public class StartCar {

	/*
	 * Gestione del parametri -> params
	 * Dispatch della class del tipo veicolo (Macchina, Moto, Bici)
	 */

	private ProcessMacchina mac = new ProcessMacchina();
	private ProcessMoto moto = new ProcessMoto();
	private ProcessBici bifi = new ProcessBici();
	public boolean execute(List<String> params) {
		System.out.println("Begin StartCar");
		
		for(String par:params) {
			
			
			
			
		}
		
		
		return true;
	}
}
