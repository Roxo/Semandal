package com.example.semandal.aux;

public class Amigo{

	private String Usuario;
	private String Nombrellidos;
	private String Pueblo;
	
	public Amigo(String Usuario, String Nombreapellidos, String Pueblo){
		this.Usuario=Usuario;
		this.Nombrellidos=Nombreapellidos;
		this.Pueblo = Pueblo;
	}

	public String getNombrellidos() {
		return Nombrellidos;
	}

	public void setNombrellidos(String nombrellidos) {
		Nombrellidos = nombrellidos;
	}

	public String getPueblo() {
		return Pueblo;
	}

	public void setPueblo(String pueblo) {
		Pueblo = pueblo;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

}
