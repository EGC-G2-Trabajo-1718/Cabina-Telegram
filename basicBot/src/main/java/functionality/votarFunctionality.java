package functionality;

import java.util.ArrayList;
import java.util.List;

public class votarFunctionality {
	
	public static List<Integer> votacionesSistema() {
		List<Integer> res = new ArrayList<Integer>();
		for (int i=0; i <= 10; i++) {
			res.add(i);
		}
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
