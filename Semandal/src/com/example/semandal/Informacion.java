package com.example.semandal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Informacion extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacion);
		ImageView b1 = (ImageView)this.findViewById(R.id.Entrar);
		ImageView b2 = (ImageView)this.findViewById(R.id.Info);
		ImageView b3 = (ImageView)this.findViewById(R.id.Buscar);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);

		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Informacion.this, Nolog.class);
				startActivity(i);
			}
			
		});
	
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Informacion.this, Log.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Informacion.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Informacion.this, Bnolog.class);
				startActivity(i);
			}
			
		});

	}
}
