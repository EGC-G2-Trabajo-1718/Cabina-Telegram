package functionality;

<<<<<<< HEAD:basicBot/src/main/java/functionality/exitFunctionality.java
import java.util.List;

public class exitFunctionality {

	public static void exit(List<String> usuariosLogueados, String usuario) {
		// Método que se ejecutará cuando se de la orden de salir del sistema.
		usuariosLogueados.remove(usuario);
	}

	public static boolean comprobarUsuario(List<String> usuarioLogueado, String usuario) {
		return usuarioLogueado.contains(usuario);
=======
public class ExitFunctionality {
	
	public static void exit() {
		
		//Método que se ejecutará cuando se de la orden de salir del sistema.
>>>>>>> votar:basicBot/src/main/java/functionality/ExitFunctionality.java
	}

}
