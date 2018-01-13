package objetos;

import java.util.Arrays;
import java.util.List;

public class Votacion {
	
	public Long id;
	public String titulo;
	public List<String> preguntas;
	
	public Votacion(Long id, String titulo, String... preguntas){
		this.id = id;
		this.titulo = titulo;
		this.preguntas = Arrays.asList(preguntas);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getPreguntas() {
		return preguntas;
	}

	public void setPreguntas(List<String> preguntas) {
		this.preguntas = preguntas;
	}

}
