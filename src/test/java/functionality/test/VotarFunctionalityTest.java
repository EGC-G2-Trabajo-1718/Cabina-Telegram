package functionality.test;


import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import functionality.VotarFunctionality;
import objetos.Votacion;

public class VotarFunctionalityTest {
	
	
	@Test
	public void votacionesSistemaTest(){
		
		List<Votacion> res = VotarFunctionality.votacionesSistema();
		assertFalse(res.isEmpty());
	}
	
	
	@Test
	public void comprobarVotacionTest(){
		
		List<Votacion> res = VotarFunctionality.votacionesSistema();
		String votacionId = res.get(0).getId().toString();
		assertTrue(VotarFunctionality.comprobarVotacion(votacionId));
	}

}
