package functionality;

import java.util.ArrayList;
import java.util.List;

import objetos.Votacion;

public class votarFunctionality {
	
	public static List<Votacion> votacionesSistema() {
		List<Votacion> res = new ArrayList<Votacion>();
		Votacion a1 = new Votacion(1l, "Titulo 1", "pregunta 1"); 
		Votacion a2 = new Votacion(2l, "Titulo 2", "pregunta 1", "pregunta 2");
		Votacion a3 = new Votacion(3l, "Titulo 3", "pregunta 1", "pregunta 2", "pregunta 3");
		Votacion a4 = new Votacion(4l, "Titulo 4", "pregunta 1", "pregunta 2", "pregunta 3", "pregunta 4");
		res.add(a1);
		res.add(a2);
		res.add(a3);
		res.add(a4);
		return res;
	}
	
	public static List<String> preguntasDeUnaVotacion(String idVotacion) {
		List<String> res = new ArrayList<String>();
		
	}
	
	public static void votar() {
		
		// Método que enviará un voto, pasando el id de votación, la pregunta y la respuesta.
		// Se necesita la API del subsistema de cabina de votaciones
		
	}
	
	public static Boolean comprobarVotaciones(String idVotacion) {
		Boolean res = false;
		List<Integer> lista = votacionesSistema();
		for (Integer ids : lista) {
			if (idVotacion.equals(ids)) {
				res = true;
			}
		}
		return res;
	}
	
	public static Boolean comprobarPreguntasDeVotacion(String idVotacion, String idPregunta) {
		Boolean res = false;
		List<String> listaPreguntas = preguntasDeUnaVotacion(idVotacion);
	}

}
