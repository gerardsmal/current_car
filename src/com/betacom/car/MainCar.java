package com.betacom.car;

import static com.betacom.car.utilities.Utils.readRecord;

import java.util.List;

import com.betacom.car.process.StartCar;

public class MainCar {

	public static void main(String[] args) {
		
		String path = "src/input_car.txt";
		List<String> params = readRecord(path);
		
		if (new StartCar().execute(params)) {
			System.out.println("fine normale");
		} else {
			System.out.println("Error found");
		}
	}

}
