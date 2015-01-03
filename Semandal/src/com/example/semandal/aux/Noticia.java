package com.example.semandal.aux;

public class Noticia {
	
	private String id;
	private String fecha;
	private String titular;
	private String ncomentarios;
	private String nlikes;
	private String categoria;
	private String dspueblo;
	
	
	public Noticia(String id, String fecha, String titular, String nlikes, 
			String comentarios, String categoria, String dspueblo){
		this.id = id;
		this.fecha = fecha;
		this.titular = titular;
		this.nlikes = nlikes;
		this.ncomentarios = comentarios;
		this.categoria = categoria;
		this.dspueblo = dspueblo;
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
	public String getNcomentarios() {
		return ncomentarios;
	}
	public void setNcomentarios(String ncomentarios) {
		this.ncomentarios = ncomentarios;
	}
	public String getNlikes() {
		return nlikes;
	}
	public void setNlikes(String nlikes) {
		this.nlikes = nlikes;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getPueblo() {
		return dspueblo;
	}
	public void setPueblo(String pueblo) {
		this.dspueblo = pueblo;
	}
	
}
