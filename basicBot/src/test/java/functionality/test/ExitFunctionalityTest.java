package functionality.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import functionality.ExitFunctionality;



public class ExitFunctionalityTest {

	@Test
	public void exitTest(){
		ArrayList<String> usuarios = new ArrayList<String>();
		usuarios.add("Victor");
		ExitFunctionality.exit(usuarios, "Victor");
		
		assertTrue(!usuarios.contains("Victor"));
	}
	
	
	
	@Test
	public void comprobarUsuarioTest(){
		ArrayList<String> usuarios = new ArrayList<String>();
		usuarios.add("Victor");
		
		assertTrue(ExitFunctionality.comprobarUsuario(usuarios, "Victor"));
	}
}
