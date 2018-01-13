package functionality;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginFunctionality {

	// Se comprueba que la contraseña introducida sea correcta
	public static boolean comprobarContrasena(String nombre, String text) throws NoSuchAlgorithmException {
		boolean res = false;
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] hash = md.digest(text.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < hash.length; i++) {
			sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
		}
		String contrasenaAProbar = sb.toString();

		Map<String, String> contrasenas = new HashMap<String, String>();
		contrasenas.put("alberto", "4d186321c1a7f0f354b297e8914ab240");
		contrasenas.put("alejandro", "4d186321c1a7f0f354b297e8914ab240");
		contrasenas.put("victor", "4d186321c1a7f0f354b297e8914ab240");
		contrasenas.put("daniel", "6e6e2ddb6346ce143d19d79b3358c16a");
		contrasenas.put("julio", "6e6e2ddb6346ce143d19d79b3358c16a");
		if (contrasenas.get(nombre.toLowerCase()) != null && contrasenas.get(nombre.toLowerCase()).equals(contrasenaAProbar)) {
			res = true;
		}
		return res;
	}

	// Se comprueba que el mapa de votaciones esté creado y si no se crea,
	// además de añadir al usuario logueado.
	public static void comprobarMapa(String nombre, Map<String, List<String>> votacionesHechas) {
		if (votacionesHechas == null) {
			votacionesHechas = new HashMap<>();
			List<String> listaVotaciones = new ArrayList<>();
			votacionesHechas.put(nombre, listaVotaciones);
		} else {
			if (votacionesHechas.get(nombre) == null) {
				List<String> listaVotaciones = new ArrayList<>();
				votacionesHechas.put(nombre, listaVotaciones);
			}
		}
	}

}
