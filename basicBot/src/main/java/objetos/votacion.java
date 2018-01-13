package objetos;

import java.util.Arrays;
import java.util.List;

public class votacion {
	
	public String id;
	public Long titulo;
	public List<String> preguntas;
	
	public votacion(String id, Long titulo, String... preguntas){
		this.id = id;
		this.titulo = titulo;
		this.preguntas = Arrays.asList(preguntas);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getTitulo() {
		return titulo;
	}

	public void setTitulo(Long titulo) {
		this.titulo = titulo;
	}

	public List<String> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<String> preguntas) {
		this.preguntas = preguntas;
	}

}
