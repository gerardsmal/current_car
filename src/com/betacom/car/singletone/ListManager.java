package com.betacom.car.singletone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.car.Models.Veicolo;


public class ListManager {

	private static ListManager instance = null;
	
	private List<Veicolo> listV = new ArrayList<Veicolo>();
	Map<String, String[]> controlli = new HashMap<String, String[]>(); // key colore, string[] valori
	Map<String, String> lTarge = new HashMap<String, String>();
	private Integer id = 0;

	
	private ListManager() {
	}

	public static ListManager getInstance() {
		if (instance == null) {
			instance = new ListManager();
		}
		return instance;
	}
	
	public void loadConstant() {		
		String path = "src/constants_car.txt";
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){
			String line = reader.readLine();
			while (line != null) {
				String[] pp = line.split("=");
				controlli.put(pp[0], pp[1].split(","));
				line = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public void showVeicoli(){
		for (Veicolo v:listV) {
			System.out.println(v);
		}
	}
}
