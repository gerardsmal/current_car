package com.betacom.car.process;

import java.util.List;

import com.betacom.car.exception.AcademyException;
import com.betacom.car.singletone.ListManager;
import com.betacom.car.utilities.ReflectionManager;

public class StartCar extends ReflectionManager{

	/*
	 * Gestione del parametri -> params
	 * Dispatch della class del tipo veicolo (Macchina, Moto, Bici)
	 */
	
	
	public final static int TIPO_VEICOLO=0;
	public final static int NUMERO_RUOTE=1;
	public final static int TIPO_ALIMENTAZIONE=2;
	public final static int CATEGORIA=3;
	public final static int COLORE=4;
	public final static int MARCA=5;
	public final static int ANNO_PRODUZIONE=6;
	public final static int MODELLO=7;
	// macchina
	public final static int NUMERO_PORTE=8;
	public final static int TARGA_MACCHINA=9;
	public final static int CC_MACCINA=10;
	// moto
	public final static int TARGA_MOTO=8;
	public final static int CC_MOTO=9;
	// bici
	public final static int NUMERO_MARCHE=8;
	public final static int TIPO_SOSPENZIONE=9;
	public final static int PIEGEVOLE=10;

	public final static int MAC_PARAMETERS = 11;
	public final static int MOTO_PARAMETERS = 10;
	public final static int BICI_PARAMETERS = 11;
	
	public boolean execute(List<String> params) {

		System.out.println("Begin StartCar");
		ListManager.getInstance().loadConstant();
		
		for(String inp:params) {
			String[] oper = inp.split(":");
			if ("add".equalsIgnoreCase(oper[0].trim())) {
				String[] param = oper[1].split(",");
				try {
					invokeExecute(param);					
				} catch (AcademyException e) {
					System.out.println(e.getMessage());
				} 
			} else if ("import".equalsIgnoreCase(oper[0].trim())) {
				String path=oper[1].trim(); 
				System.out.println("Import veicoli da " + path);
				ListManager.getInstance().importVeicoli(path);
			} else if ("export".equalsIgnoreCase(oper[0].trim())) {
				String path=oper[1].trim(); 
				System.out.println("Export veicoli dentro " + path);
				ListManager.getInstance().exportVeicoli(path);				
			} else if ("list".equalsIgnoreCase(oper[0].trim())) {
				System.out.println("Elenco veicoli ");
				ListManager.getInstance().showVeicoli();
				
			}
			
		}

		
		return true;
	}
	
	
}
