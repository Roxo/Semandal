package com.example.semandal;

import java.util.List;

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

public class Plantilla_Comment extends BaseAdapter{

	private final Activity actividad;
	private final List<Comentario> lista;

	public Plantilla_Comment(Activity actividad, List<Comentario> lista){
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
		View view = inflater.inflate(R.layout.activity_plantilla__comment,null,true);
		TextView textView1 =(TextView)view.findViewById(R.id.p_autor);
		textView1.setText(lista.get(position).getAutor());
		TextView textView2 =(TextView)view.findViewById(R.id.p_puntuacion);
		textView2.setText(lista.get(position).getpuntuacion());
		TextView textView3 =(TextView)view.findViewById(R.id.p_comentario);
		textView3.setText(lista.get(position).getComentario());
		TextView textView4 =(TextView)view.findViewById(R.id.fecha);
		textView4.setText(lista.get(position).getFecha());
		return view;
		}
}
