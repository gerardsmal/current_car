package com.betacom.car.singletone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.car.Models.Veicolo;

/*
 * gestione dell'ID veicolo
 * gestione della targa (univoca)
 * gestrion della lista veicolo (inserimento)
 * display della lista4
 */
public class ListManager {

	private static ListManager instance = null;
	
	private List<Veicolo> listV = new ArrayList<Veicolo>();
	Map<String, String[]> controlli = new HashMap<String, String[]>(); // key colore, string[] valori
	Map<String, String> lTarge = new HashMap<String, String>();
	private Integer id = 0;

	String alim = "benzina, diesel,electica,ibrida,manuale";
	String cat = "strada,fuoristrada,suv,mtb,cross";
	String colore = "bianca,nero,verde,giallo,marrone,rossa";
	String marca = "Fiat,Renault,BMW,Telsla,Bianchi,Yamaha,Mercedes";
	String sospenzione = "senza,mono,bi";
	
	private ListManager() {
	}

	public static ListManager getInstance() {
		if (instance == null) {
			instance = new ListManager();
		}
		return instance;
	}
	
	public void loadConstant() {
		controlli.put("alim", alim.split(","));		
		controlli.put("cat", cat.split(","));	
		controlli.put("colore", colore.split(","));	
		controlli.put("marca", marca.split(","));	
		controlli.put("sospenzione", sospenzione.split(","));
	}
	
	
	public boolean isValidValue(String key, String value) {
		String[] values = controlli.get(key);
		for (String it:values) {
			if (value.equalsIgnoreCase(it))
				return true;
		}
		return false;
		
	}
	
	public boolean isTargaExist(String targa) {
		if (lTarge.containsKey(targa))
			return true;
		
		lTarge.put(targa, "");
		return false;
		
		
	}
	
	public Veicolo insertVeicolo(Veicolo v) {
		v.setId(++id);
		listV.add(v);
		return v;
		
	}
	public List<Veicolo> getList(){
		return listV;
	}
}
