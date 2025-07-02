package com.betacom.car.process;

import com.betacom.car.Models.Bici;
import com.betacom.car.exception.AcademyException;
import com.betacom.car.singletone.ListManager;

/*
 * public final static int NUMERO_MARCHE=8;
	public final static int TIPO_SOSPENZIONE=9;
	public final static int PIEGEVOLE=10;

 */
public class ProcessBici {
	public void execute(String[] params) throws AcademyException{
		System.out.println("Begin ProcessBici");
		if (params.length != StartCar.BICI_PARAMETERS)
			throw new AcademyException("Errore nel numeri di parametri passaot per la bici");

		
		Bici bici = new Bici();

		bici = (Bici)new VeicoloControl().verify(bici, params);
		
		try {
			bici.setNumeroMarche(Integer.parseInt(params[StartCar.NUMERO_MARCHE]));			
		} catch (Exception e) {
			throw new AcademyException("numero marche invalido");
		}

		if (!ListManager.getInstance().isValidValue("sospenzione", params[StartCar.TIPO_SOSPENZIONE]))
			throw new AcademyException("Tipo sospenzione invalida");
		bici.setTipoSospenzione(params[StartCar.TIPO_SOSPENZIONE]);
		
		bici.setPiegevole((params[StartCar.TIPO_SOSPENZIONE].trim().equalsIgnoreCase("true"))? true : false);


		bici = (Bici) ListManager.getInstance().insertVeicolo(bici);
		
		System.out.println(".... Bici inserita");

	}
}
