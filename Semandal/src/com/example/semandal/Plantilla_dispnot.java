package com.example.semandal;

import java.util.List;

import com.example.semandal.aux.Comentario;
import com.example.semandal.aux.Noticia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

public class Plantilla_dispnot extends BaseAdapter{
	private final Activity actividad;
	private final List<Noticia> lista;

	public Plantilla_dispnot(Activity actividad, List<Noticia> lista){
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
		View view = inflater.inflate(R.layout.activity_plantilla_dispnot,null,true);
		TextView textView1 =(TextView)view.findViewById(R.id.fecha);
		textView1.setText(lista.get(position).getFecha());
		TextView textView2 =(TextView)view.findViewById(R.id.titular);
		textView2.setText(lista.get(position).getTitular());
		TextView textView4 =(TextView)view.findViewById(R.id.nlikes);
		textView4.setText(lista.get(position).getNlikes());
		TextView textView5 =(TextView)view.findViewById(R.id.pueblo);
		textView5.setText(lista.get(position).getPueblo());
		TextView textView6 =(TextView)view.findViewById(R.id.ncomentarios);
		textView6.setText(lista.get(position).getNcomentarios());
		if(lista.get(position).getFecha().equalsIgnoreCase("")){
			TextView comentarios = (TextView)view.findViewById(R.id.TextView02);
			TextView votos = (TextView)view.findViewById(R.id.TextView01);
			comentarios.setVisibility(View.GONE);
			votos.setVisibility(View.GONE);
		}
		boolean cambiocolor = lista.get(position).isVista();
		if(cambiocolor){
			view.setBackgroundResource(R.drawable.gradiente_leido);
		}
		else{
			view.setBackgroundResource(R.drawable.gradiente);
			textView1.setTextColor(Color.BLACK);
			textView2.setTextColor(Color.BLACK);
			textView4.setTextColor(Color.BLACK);
			textView5.setTextColor(Color.BLACK);
			textView6.setTextColor(Color.BLACK);
			TextView textView7 = (TextView)view.findViewById(R.id.TextView01);
			TextView textView8 = (TextView)view.findViewById(R.id.TextView02);
			textView7.setTextColor(Color.BLACK);
			textView8.setTextColor(Color.BLACK);


		}
		return view;
		}
}