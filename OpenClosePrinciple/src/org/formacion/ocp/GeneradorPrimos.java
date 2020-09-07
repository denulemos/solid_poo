package org.formacion.ocp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GeneradorPrimos {


	//Devuelvo una lista de numeros primos entre 2 y el numero dado
	public List<Integer> primos (int limit) {
		
		List<Integer> primos = new ArrayList<>();
		for (int i = 2; i < limit; i++) {
			if (esPrimo(i)) {
				primos.add(i);
			}
		}
		
		//Implementamos al comparador
		Collections.sort(primos,  getOrden());
		
		return primos;

	}
	
	//Numero es primo o no?
	private boolean esPrimo (int candidato) {
		for (int i = 2; i < candidato; i++) {
			if (candidato % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	//Sobreescribimos este metodo y podemos cambiar el orden de los numeros, sin cambiar nada mas. 
	
	protected Comparator<Integer> getOrden(){
		//Si b es mayor que a, devolvemos un valor negativo, de lo contrario, positivo
		return (a,b) -> a> b? 1: -1;
	}
}
