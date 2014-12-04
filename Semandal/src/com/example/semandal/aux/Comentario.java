package com.example.semandal.aux;

public class Comentario {
	
	private String Autor;
	private String puntuacion;
	private String Comentario;
	
	public Comentario(String Autor, String puntuacion, String Comentario){
		this.setAutor(Autor);
		this.setpuntuacion(puntuacion);
		this.setComentario(Comentario);
	}

	public String getAutor() {
		return Autor;
	}

	public void setAutor(String autor) {
		Autor = autor;
	}

	public String getpuntuacion() {
		return puntuacion;
	}

	public void setpuntuacion(String puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}
}
