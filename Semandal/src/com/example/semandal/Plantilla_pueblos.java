package com.example.semandal;

import java.util.List;

import com.example.semandal.aux.Noticia;
import com.example.semandal.aux.Pueblo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Plantilla_pueblos extends BaseAdapter {
	private final Activity actividad;
	private final List<Pueblo> lista;

	
	public Plantilla_pueblos(Activity actividad, List<Pueblo> lista){
		super();
		this.actividad=actividad;
		this.lista=lista;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = actividad.getLayoutInflater();
		View view = inflater.inflate(R.layout.activity_plantilla_pueblos,null,true);
		TextView textView1 =(TextView)view.findViewById(R.id.pueblos);
		textView1.setText(lista.get(position).getPueblo());
		ImageView imagen = (ImageView)view.findViewById(R.id.escudo);
		if(lista.get(position).getEsc()!=null)
				imagen.setImageDrawable(lista.get(position).getEsc());
		return view;
	}
}
