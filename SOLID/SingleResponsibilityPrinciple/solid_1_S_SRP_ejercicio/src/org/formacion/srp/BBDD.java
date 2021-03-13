package org.formacion.srp;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BBDD {
//Es un recomendador de peliculas, nos basamos en las pelis favoritas del cliente (este solo tiene ET) y recomendar peliculas del mismo director. 
	
	//Simula una base de datos
	
	private static final String GENERO_FANTASTICO = "fantastica";
	private static final String GENERO_BELICO = "belico";
	
	public static final String DIRECTOR_SPIELBERG = "Spielberg";
	
	//Peliculas
	public static final Pelicula ET = new Pelicula("ET", GENERO_FANTASTICO, DIRECTOR_SPIELBERG);
	
	public static final Pelicula SOLDADO_RYAN = new Pelicula("Salvar al soldado Ryan", GENERO_BELICO, DIRECTOR_SPIELBERG);
	
	public static final Pelicula [] TODAS = { ET, SOLDADO_RYAN};
	
	//Cliente
	public static final Cliente JUAN = new Cliente("Juan", ET);
	
	public static Map<String, List<Pelicula>> PELIS_POR_DIRECTOR = Arrays.stream(TODAS)
			.collect(Collectors.groupingBy(Pelicula::getDirector));
			
	
}
