package com.betacom.car.process;

import com.betacom.car.Models.Veicolo;
import com.betacom.car.exception.AcademyException;
import com.betacom.car.singletone.ListManager;

public class VeicoloControl {

	public Veicolo verify(Veicolo vei, String[] params) throws AcademyException{
		
		
	vei.setTipoVeicolo(params[StartCar.TIPO_VEICOLO]);
		
		try {
			vei.setNumeroRuote(Integer.parseInt(params[StartCar.NUMERO_RUOTE]));			
		} catch (Exception e) {
			throw new AcademyException("numero route invalido");
		}
		if (!ListManager.getInstance().isValidValue("alim", params[StartCar.TIPO_ALIMENTAZIONE]))
			throw new AcademyException("Tipo alimentazione invalida");
		vei.setTipoAlimentazione(params[StartCar.TIPO_ALIMENTAZIONE]);
		
		if (!ListManager.getInstance().isValidValue("cat", params[StartCar.CATEGORIA]))
			throw new AcademyException("Categoria invalida");
		vei.setCategoria(params[StartCar.CATEGORIA]);

		if (!ListManager.getInstance().isValidValue("colore", params[StartCar.COLORE]))
			throw new AcademyException("Colore invalida");
		vei.setColore(params[StartCar.COLORE]);


		if (!ListManager.getInstance().isValidValue("marca", params[StartCar.MARCA]))
			throw new AcademyException("Marca invalida");
		vei.setMarca(params[StartCar.MARCA]);
		
		
		try {
			vei.setAnnoProduzione(Integer.parseInt(params[StartCar.ANNO_PRODUZIONE]));			
		} catch (Exception e) {
			throw new AcademyException("Anno produzione invalida");
		}
		if (vei.getAnnoProduzione() < 2000 || vei.getAnnoProduzione() > 2025)
			throw new AcademyException("Anno produzione invalida");
		
		vei.setModello(params[StartCar.MODELLO]);
		return vei;
	}
}
