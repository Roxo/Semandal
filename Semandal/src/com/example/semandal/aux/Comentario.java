package com.example.semandal.aux;

public class Comentario {
	
	private String Autor;
	private String puntuacion;
	private String Comentario;
	private String fecha;
	
	public Comentario(String Autor, String puntuacion, String Comentario,String fecha){
		this.setAutor(Autor);
		this.setpuntuacion(puntuacion);
		this.setComentario(Comentario);
		this.setFecha(fecha);
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


}
