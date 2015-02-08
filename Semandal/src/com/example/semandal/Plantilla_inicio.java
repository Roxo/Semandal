package com.example.semandal;

import java.util.List;

import com.example.semandal.aux.Inicio;
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

public class Plantilla_inicio extends BaseAdapter {

		private final Activity actividad;
		private final List<Inicio> lista;

		public Plantilla_inicio(Activity actividad, List<Inicio> lista){
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
			View view = inflater.inflate(R.layout.activity_plantilla_inicio,null,true);
			TextView textView1 =(TextView)view.findViewById(R.id.fecha);
			textView1.setText(lista.get(position).getFecha());
			TextView textView2 =(TextView)view.findViewById(R.id.titular);
			textView2.setText(lista.get(position).getTitular());
			TextView textView3 =(TextView)view.findViewById(R.id.pueblo);
			textView3.setText(lista.get(position).getPueblo());
			TextView textView4 =(TextView)view.findViewById(R.id.fc1);
	
			if(lista.get(position).getFc1().equalsIgnoreCase("")){
				textView4.setVisibility(View.GONE);
			}else{
				textView4.setText(lista.get(position).getFc1());
			}
			
			TextView textView5 =(TextView)view.findViewById(R.id.autor1);
			
			if(lista.get(position).getUser1().equalsIgnoreCase("")){
				textView5.setVisibility(View.GONE);
			}else{
				textView5.setText(lista.get(position).getUser1());
			}
			
			TextView textView6 =(TextView)view.findViewById(R.id.c1);
			
			if(lista.get(position).getC1().equalsIgnoreCase("")){
				textView6.setVisibility(View.GONE);
			}else{
				textView6.setText(lista.get(position).getC1());			
			}			
			
			TextView textView7 =(TextView)view.findViewById(R.id.fc2);
			if(lista.get(position).getFc2().equalsIgnoreCase("")){
				textView7.setVisibility(View.GONE);
			}else{
				textView7.setText(lista.get(position).getFc2());
			}			
					
			
			TextView textView8 =(TextView)view.findViewById(R.id.autor2);
			if(lista.get(position).getUser2().equalsIgnoreCase("")){
				textView8.setVisibility(View.GONE);
			}else{
				textView8.setText(lista.get(position).getUser2());
			}	
			
			
			TextView textView9 =(TextView)view.findViewById(R.id.c2);
			
			if(lista.get(position).getC2().equalsIgnoreCase("")){
				textView8.setVisibility(View.GONE);
			}else{
				textView9.setText(lista.get(position).getC2());
			}	
			return view;
			}		
}
