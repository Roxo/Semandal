package com.example.semandal.aux;

public class Noticia {
	
	private int id;
	private String fecha;
	private String titular;
	private int ncomentarios;
	private int nlikes;
	private String categoria;
	private String dspueblo;
	private boolean vista;
	
	public Noticia(int id, String fecha, String titular,int nlikes, 
			int comentarios, String categoria, String dspueblo,boolean vista){
		this.id = id;
		this.fecha = fecha;
		this.titular = titular;
		this.nlikes = nlikes;
		this.ncomentarios = comentarios;
		this.categoria = categoria;
		this.dspueblo = dspueblo;
		this.vista=vista;
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
		return ""+id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNcomentarios() {
		return ""+ncomentarios;
	}
	public void setNcomentarios(int ncomentarios) {
		this.ncomentarios = ncomentarios;
	}
	public String getNlikes() {
		return ""+nlikes;
	}
	public void setNlikes(int nlikes) {
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
	public boolean isVista() {
		return vista;
	}
	public void setVista(boolean vista) {
		this.vista = vista;
	}
	
}
