package com.betacom.car.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.betacom.car.exception.AcademyException;
import com.betacom.car.process.StartCar;

public class ReflectionManager {
	private static final String PACKAGE_NAME = "com.betacom.car.process";
	
	public void invokeExecute(String[] param  ) throws AcademyException{
		try {
			String methodName = "execute";
			String className = "Process" + param[StartCar.TIPO_VEICOLO];
			Class<?> cl = Class.forName(PACKAGE_NAME + "." + className);
			Constructor<?> ctor = cl.getConstructor();
			
			Object myClass = ctor.newInstance();  // new instance della class
			Method executeMethod = myClass.getClass().getMethod(methodName,String[].class);
			
			executeMethod.invoke(myClass,(Object) param);
			
		} catch (ClassNotFoundException e) {
			throw new AcademyException("tipo veicolo not found :" + param[StartCar.TIPO_VEICOLO]);
		} catch (NoSuchMethodException e) {
			throw new AcademyException("error sul contructore.." + e.getMessage());
		} catch (SecurityException e) {
			throw new AcademyException("error di sicurezza.." + e.getMessage());
		} catch (InstantiationException e) {
			throw new AcademyException("Errore nel costructore.." + e.getMessage());
		} catch (IllegalAccessException e) {
			throw new AcademyException("Errore IllegalAccess" + e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new AcademyException("Errore IllegalArgument" + e.getMessage());
		} catch (InvocationTargetException e) {            // retrieve error from invoke method (AcademyException)
			throw new AcademyException(e.getCause().getMessage());
		}

		
		
		
	}
	
}
