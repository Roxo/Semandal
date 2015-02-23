package com.example.semandal.aux;

import android.content.Context;
import android.content.SharedPreferences;

public class AlmacenUsuario {
	private static String PREFERENCIAS = "usuarios";
	private Context context;
	
	public AlmacenUsuario(Context context){
		this.context = context;
	}
	
	public void GuardarUsuario(int id){
		SharedPreferences preferencias = context.getSharedPreferences(PREFERENCIAS,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putInt("id",id);
		editor.commit();
	}
	
	public int GetUsuario(){
		SharedPreferences preferencias = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
		int id = preferencias.getInt("id", 0);
		return id;
	}
}
