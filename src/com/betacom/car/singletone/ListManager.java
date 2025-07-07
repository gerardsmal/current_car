package com.betacom.car.singletone;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.car.Models.Bici;
import com.betacom.car.Models.Macchina;
import com.betacom.car.Models.Moto;
import com.betacom.car.Models.Veicolo;
import com.betacom.car.utilities.RuntimeTypeAdapterFactory;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

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
	    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
	        reader.lines()   // crea un stream di lines
	              .map(line -> line.split("="))
	              .filter(parts -> parts.length == 2)
	              .forEach(parts -> controlli.put(parts[0], parts[1].split(",")));
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	public boolean isValidValue(String key, String value) {
	    String[] values = controlli.get(key);
	    return values != null && 
	    		Arrays.stream(values)
	    			.anyMatch(it -> value.equalsIgnoreCase(it));
	}

	public boolean isTargaExist(String targa) {
		if (lTarge.containsKey(targa))
			return true;
		
		lTarge.put(targa.toUpperCase(), "");
		return false;
		
		
	}
	
	public Veicolo insertVeicolo(Veicolo v) {
		v.setId(++id);
		listV.add(v);
		return v;
		
	}
	public void showVeicoli(){
		listV.forEach(v -> System.out.println(v));
	}
	
	public void exportVeicoli(String path) {
		// set json format
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		// transform list in json and write json file
	    try (Writer writer = new FileWriter(path)) {
            gson.toJson(listV, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	
	public void importVeicoli(String path) {
		Gson gson = new GsonBuilder()
				  .registerTypeAdapterFactory(
					        RuntimeTypeAdapterFactory
					            .of(Veicolo.class, "tipoVeicolo") // "tipoVeicolo" è il campo discriminante nel JSON
					            .registerSubtype(Macchina.class, "Macchina")
					            .registerSubtype(Moto.class, "Moto")
					            .registerSubtype(Bici.class, "Bici")
					    )
					    .create();
        // Read JSON from a file
        try (Reader reader = new FileReader(path)) {
            // convert the JSON data to a Java object
        	Type listType = new TypeToken<List<Veicolo>>(){}.getType(); // se si utilizza List.class Gson no riconoesce l'oggetto reale
        															    // e per risolvere il problema indica lo crea come LinkedTreeMap
        																// per risolvere il problema dobbiamo 		
        																// indicare a Gson di serializzare l'elenco come
        																// una lista concreta di oggetti Veicolo, 
        																// non LinkedTreeMap.
            List<Veicolo> listV1 = gson.fromJson(reader, listType);

            listV.forEach(v -> {
            	if (v instanceof Macchina)
            		v.setTipoVeicolo("Macchina");
               	if (v instanceof Moto)
            		v.setTipoVeicolo("Moto");
               	if (v instanceof Bici)
            		v.setTipoVeicolo("Bici");
            	
            	v.setId(++id);
            	listV.add(v);
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
	}
	
}
