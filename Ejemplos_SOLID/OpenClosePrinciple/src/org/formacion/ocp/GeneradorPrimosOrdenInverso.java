package org.formacion.ocp;

import java.util.Comparator;

//HERENCIA DISEÑADA APRIORI, PLANIFICADA
public class GeneradorPrimosOrdenInverso extends GeneradorPrimos{
 
	protected Comparator<Integer> getOrden(){
		//Damos vuelta la funcion original
		return (a, b) -> a > b? -1 : 1;
	}
}
