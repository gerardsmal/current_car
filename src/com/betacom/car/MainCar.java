package com.betacom.car;

import java.util.ArrayList;
import java.util.List;

import com.betacom.car.process.StartCar;

public class MainCar {

	public static void main(String[] args) {
	
		
		List<String> params = new ArrayList<String>();
		params.add("Macchina,4,benzina,strada,verde,Renault,2020,Clio,3,EL123GX,1200");
		params.add("Moto,2,benzina,strada,bianca,Yamaha,2021,R1,EL22230,900");
		params.add("Bici,2,manuale,strada,rossa,Bainchi,2022,B1,9,senza,false");
		// .....
		
		
		
		if (new StartCar().execute(params)) {
			System.out.println("fine normale");
		} else {
			System.out.println("Error found");
		}
	}

}
