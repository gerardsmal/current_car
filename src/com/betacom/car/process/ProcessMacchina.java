package com.betacom.car.process;

import com.betacom.car.Models.Macchina;
import com.betacom.car.exception.AcademyException;
import com.betacom.car.singletone.ListManager;

public class ProcessMacchina {

	
	public void execute(String[] params) throws AcademyException{
		System.out.println("Begin ProcessMacchina");
		if (params.length != StartCar.MAC_PARAMETERS)
			throw new AcademyException("Errore nel numeri di parametri passaot per la macchine");
		
		Macchina mac = new Macchina();

		mac = (Macchina)new VeicoloControl().verify(mac, params);
		
		try {
			mac.setNumeroPorte(Integer.parseInt(params[StartCar.NUMERO_PORTE]));			
		} catch (Exception e) {
			throw new AcademyException("numero porte invalido");
		}
		
		if (!isValidFormat(params[StartCar.TARGA_MACCHINA])) {
			throw new AcademyException("formato della targa invalida");
		}
		
		if (ListManager.getInstance().isTargaExist(params[StartCar.TARGA_MACCHINA]))
			throw new AcademyException("Targa già inserita");
		mac.setTarga(params[StartCar.TARGA_MACCHINA]);
		
		try {
			mac.setCc(Integer.parseInt(params[StartCar.CC_MACCINA]));			
		} catch (Exception e) {
			throw new AcademyException("cilindrato invalido");
		}

		mac = (Macchina) ListManager.getInstance().insertVeicolo(mac);
		
		
		System.out.println(".... Macchina inserita");
		
	}
	
	private boolean isValidFormat(String str) {
		// espressione regolare  per 2 char 3 numeric 2 char
		String regex = "^[A-Za-z]{2}\\d{3}[A-Za-z]{2}$";
		
		// verifica della string
		return str !=null && str.matches(regex);
		
		
	}
}
