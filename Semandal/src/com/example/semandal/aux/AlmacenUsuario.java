package com.example.semandal.aux;

import android.content.Context;
import android.content.SharedPreferences;

public class AlmacenUsuario {
	private static String PREFERENCIAS = "usuarios";
	private static String TABLAS = "versiones";
	private Context context;
	
	public AlmacenUsuario(Context context){
		this.context = context;
	}
	
	public void GuardarVersiones(String tabla, int version){
		SharedPreferences preferencias = context.getSharedPreferences(TABLAS,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putInt(tabla,version);
		editor.commit();
	}

	
	public int GetVcat(){
		SharedPreferences preferencias = context.getSharedPreferences(TABLAS, Context.MODE_PRIVATE);
		int id = preferencias.getInt("categorias", 0);
		return id;
	}

	public int GetVpbs(){
		SharedPreferences preferencias = context.getSharedPreferences(TABLAS, Context.MODE_PRIVATE);
		int id = preferencias.getInt("pueblo", 0);
		return id;
	}
	
	public void GuardaridUsuario(int id){
		SharedPreferences preferencias = context.getSharedPreferences(PREFERENCIAS,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putInt("id",id);
		editor.commit();
	}
	
	public void GuardarStringUsuario(String nombre){
		SharedPreferences preferencias = context.getSharedPreferences(PREFERENCIAS,Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = preferencias.edit();
		editor.putString("name",nombre);
		editor.commit();
	}
	public String GetUsuario(){
		SharedPreferences preferencias = context.getSharedPreferences(PREFERENCIAS, Context.MODE_PRIVATE);
		int id = preferencias.getInt("id", 0);
		String a = preferencias.getString("name","");
		return a+"-"+id;
	}
}
