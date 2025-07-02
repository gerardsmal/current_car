package com.betacom.car.process;

import com.betacom.car.Models.Moto;
import com.betacom.car.exception.AcademyException;
import com.betacom.car.singletone.ListManager;


public class ProcessMoto {

	public void execute(String[] params) throws AcademyException{
		System.out.println("Begin ProcessMoto");
		if (params.length != StartCar.MOTO_PARAMETERS)
			throw new AcademyException("Errore nel numeri di parametri passaot per la moto");

		
		Moto moto = new Moto();

		moto = (Moto)new VeicoloControl().verify(moto, params);
		
		if (!isValidFormat(params[StartCar.TARGA_MOTO])) {
			throw new AcademyException("Formato Targa moto invalida");
		}

		if (ListManager.getInstance().isTargaExist(params[StartCar.TARGA_MOTO]))
			throw new AcademyException("Targa già inserita");
		moto.setTarga(params[StartCar.TARGA_MOTO]);

		try {
			moto.setCc(Integer.parseInt(params[StartCar.CC_MOTO]));			
		} catch (Exception e) {
			throw new AcademyException("cilindrato invalido");
		}

		moto = (Moto) ListManager.getInstance().insertVeicolo(moto);
		
		System.out.println(".... Moto inserita");
	}

	private boolean isValidFormat(String str) {
		// Espressione regolare: 2 lettere alfabetiche seguite da 5 numeri
		String regex = "^[A-Za-z]{2}\\d{5}$";
		
		// verifica della string
		return str !=null && str.matches(regex);
		
		
	}
}
