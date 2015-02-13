package com.example.semandal.aux;

import android.graphics.drawable.Drawable;

public class Pueblo {
	private String pueblo;
	private Drawable esc;
	
	public Pueblo(String pueblo, Drawable esc){
		this.pueblo = pueblo;
		this.esc = esc;
	}
	public String getPueblo() {
		return pueblo;
	}
	public void setPueblo(String pueblo) {
		this.pueblo = pueblo;
	}
	public Drawable getEsc() {
		return esc;
	}
	public void setEsc(Drawable esc) {
		this.esc = esc;
	}
}

