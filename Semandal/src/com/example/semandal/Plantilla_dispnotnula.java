package com.example.semandal;

import java.util.List;

import com.example.semandal.aux.Noticia;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class Plantilla_dispnotnula extends BaseAdapter{
	private final Activity actividad;
	private final List<Noticia> lista;

	public Plantilla_dispnotnula(Activity actividad, List<Noticia> lista){
		super();
		this.actividad=actividad;
		this.lista=lista;
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
		View view = inflater.inflate(R.layout.activity_plantilla_dispnotnula,null,true);
		TextView textView2 =(TextView)view.findViewById(R.id.titular);
		textView2.setText(lista.get(position).getTitular());
		return view;
		}
}