package com.example.semandal;

import java.util.List;

import com.example.semandal.aux.Categoria;
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

public class Plantilla_categoria extends BaseAdapter{
	private final Activity actividad;
	private final List<Categoria> lista;

	public Plantilla_categoria(Activity actividad, List<Categoria> lista){
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
		View view = inflater.inflate(R.layout.activity_plantilla_categoria,null,true);
		TextView categoria = (TextView)view.findViewById(R.id.categoria);
		categoria.setText(lista.get(position).getCategoria());
		return view;
		}
}