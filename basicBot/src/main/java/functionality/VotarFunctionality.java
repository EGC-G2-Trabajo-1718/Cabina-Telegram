package functionality;

import java.util.ArrayList;
import java.util.List;

import objetos.Votacion;

public class VotarFunctionality {

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
	
	public static String construyeTextoVotacionesDisponibles() {
		String texto = "Las votaciones actuales del sistema son las siguientes:";
		for (Votacion v : votacionesSistema()) {
			texto += "Id: " + v.getId() + " - " + v.getTitulo()+", ";
		}
		texto += "Escribe la Id de la votacion en la que quieras participar.";
		return texto;
	}

	// Devuelve TRUE si la votacion existe en el sistema tras meterle una ID.
	public static Boolean comprobarVotacion(String idVotacion) {
		Boolean res = false;
		try {
			for (Votacion v : votacionesSistema()) {
				if (v.getId().equals(Long.parseLong(idVotacion))) {
					res = true;
					break;
				}
			}		
		}catch (Exception e) {
			// necesario para que responda cuando introduces algo que no es un id
		}
		return res;
	}

	// Devuelve las preguntas especificas de una votacion dada.
	public static List<String> preguntasDeVotacion(String idVotacion) {
		List<String> preguntas = new ArrayList<String>();
		Votacion votacion;
		for (Votacion v : votacionesSistema()) {
			if (v.getId().equals(Long.parseLong(idVotacion))) {
				votacion = v;
				preguntas = votacion.getPreguntas();
				break;
			}
		}
		return preguntas;
	}
	
	public static String construyeTextoPreguntasVotacion(String idVotacion) {
		String texto = "Conteste a las siguientes preguntas:";
		List<String> preguntas = preguntasDeVotacion(idVotacion);
		Integer contador = preguntas.size();
		for (String p : preguntas) {
			texto += "\r\n" + p;
			contador = contador - 1;
			if (contador == 0) {
				return texto;
			}
		}
		return texto;
	}

}
