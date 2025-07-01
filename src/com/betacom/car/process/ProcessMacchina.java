package com.betacom.car.process;

import com.betacom.car.Models.Macchina;
import com.betacom.car.exception.AcademyException;

public class ProcessMacchina {

	/*
	 * control dei parametri specifici 
	 * I parametri  della class Veicolo devono essere generale per tutti ..
	 * 
	 */
	
	public void execute(String[] params) throws AcademyException{
		Macchina mac = new Macchina();
		
		try {
			mac = (Macchina)new VeicoloControl().verify(mac, params);
			// control specifici
		
		
		
		} catch (AcademyException e) {
			
		}
	}
}
