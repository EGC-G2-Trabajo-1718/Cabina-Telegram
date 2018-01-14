package functionality.test;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import org.junit.Test;

import functionality.LoginFunctionality;


public class LoginFunctionalityTest {
	
	
	@Test
	public void comprobarContrasenaTest() throws NoSuchAlgorithmException{
		
		assertTrue(LoginFunctionality.comprobarContrasena("daniel", "adios"));
	}

}
