package com.example.semandal.aux;

public class Noticia {
	
	private String id;
	private String fecha;
	private String titular;
	
	
	public Noticia(String id, String fecha, String titular){
		this.id = id;
		this.fecha = fecha;
		this.titular = titular;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
