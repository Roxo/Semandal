package com.example.semandal;

import java.util.List;

import com.example.semandal.aux.Amigo;
import com.example.semandal.aux.Comentario;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Plantilla_amigos extends BaseAdapter {
	
	private final Activity actividad;
	private final List<Amigo> lista;

	public Plantilla_amigos(Activity actividad, List<Amigo> lista){
		super();
		this.actividad = actividad;
		this.lista = lista;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return lista.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.activity_plantilla_amigos,null,true);
		TextView textView1 =(TextView)view.findViewById(R.id.Pueblo);
		textView1.setText(lista.get(position).getPueblo());
		TextView textView2 =(TextView)view.findViewById(R.id.Usuario);
		textView2.setText(lista.get(position).getUsuario());
		TextView textView3 =(TextView)view.findViewById(R.id.Nombreyapellidos);
		textView3.setText(lista.get(position).getNombrellidos());	
		return view;
	}
	
}
