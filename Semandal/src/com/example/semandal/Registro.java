package com.example.semandal;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Registro extends Activity {
	private Spinner spinner1;
	private List<String> lista;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
				Button b1 = (Button)this.findViewById(R.id.loggin);
				Button b2 = (Button)this.findViewById(R.id.info);
				Button b3 = (Button)this.findViewById(R.id.busqueda);

				b1.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(Registro.this, LoginActivity.class);
						startActivity(i);
					}
					
				});		
				b2.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(Registro.this, Informacion.class);
						startActivity(i);
					}
					
				});
				b3.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(Registro.this, Bnolog.class);
						startActivity(i);
					}
					
				});
				DatosPorDefecto();
	}
	private void DatosPorDefecto() {
		   spinner1 = (Spinner) findViewById(R.id.cat);
		   lista = new ArrayList<String>();
		   spinner1 = (Spinner) this.findViewById(R.id.cat);
		   lista.add("Panchos");
		   lista.add("Choripán");
		   lista.add("Hamburguesas");
		   lista.add("Pollo al horno");
		   lista.add("Asado");
		   lista.add("Arroz");
		   ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
		   adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner1.setAdapter(adaptador);
		}
}
