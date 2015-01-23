package com.example.semandal.aux;

public class Inicio {
	private String fecha;
	private String titular;
	private String pueblo;
	private int idnoticia;
	private String user1;
	private String fc1;
	private String c1;
	private String user2;
	private String fc2;
	private String c2;

	public Inicio(int idnoticia, String fecha, String titular, String pueblo,
			String u1, String fc1, String c1, String u2, String fc2, String c2){
		this.setFecha(fecha);
		this.setTitular(titular);
		this.setPueblo(pueblo);
		this.setIdnoticia(idnoticia);
		this.setUser1(u1);
		this.setUser2(u2);
		this.setFc1(fc1);
		this.setFc2(fc2);
		this.setC1(c1);
		this.setC2(c2);
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getIdnoticia() {
		return idnoticia;
	}

	public void setIdnoticia(int idnoticia) {
		this.idnoticia = idnoticia;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getPueblo() {
		return pueblo;
	}

	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}

	public String getUser1() {
		return user1;
	}

	public void setUser1(String user1) {
		this.user1 = user1;
	}

	public String getFc1() {
		return fc1;
	}

	public void setFc1(String fc1) {
		this.fc1 = fc1;
	}

	public String getC1() {
		return c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getUser2() {
		return user2;
	}

	public void setUser2(String user2) {
		this.user2 = user2;
	}

	public String getFc2() {
		return fc2;
	}

	public void setFc2(String fc2) {
		this.fc2 = fc2;
	}

	public String getC2() {
		return c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}
	
	
}
