package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Display_not_nolog extends Activity {
	String notid="",url,url1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_not_nolog);
		notid=getIntent().getStringExtra("id");
		AsincronDNN tarea = null;
		tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
				(TextView) findViewById(R.id.Noticia),
				(TextView) findViewById(R.id.fecha),
				Singleton.url+":8000/api/noticias/"+notid
				);
		tarea.execute();

		
		Button b4 = (Button)this.findViewById(R.id.comment);
		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
		Button b5 = (Button)this.findViewById(R.id.button1);

		
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
				startActivity(browserIntent);
			}
			
		});	
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, LoginActivity.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, Bnolog.class);
				startActivity(i);
			}
			
	});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, Comentarios_nolog.class);
				i.putExtra("id", notid);
				startActivity(i);
			}
			
	});
	}
	
	public class AsincronDNN extends AsyncTask<Void, Void, Void> {
		Context contexto;
		String url;
		TextView titview,cuerpview,dateview;
		JSONObject html, Comentario;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincronDNN(Context contexto,TextView titview,TextView cuerpview,
			TextView dateview,String url){
			this.contexto = contexto;
			this.titview = titview;
			this.cuerpview = cuerpview;
			this.dateview = dateview;
			this.url = url;
			
		}
		
		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }

			  public void leernoticia() throws IOException, JSONException {
			    InputStream is = new URL(url).openStream();
			    try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			      String jsonText = readAll(rd);
			       html = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
			  }
			  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leernoticia();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			return null;
		}



		@Override
		public void onPostExecute(Void result){
			String titular = "ROTO",cuerpo="ROTO", fecha = "Roto";
			try {
				titular = html.getString("titular").replace("-","\n");
				cuerpo = html.getString("cuerpo").replace("-","\n");
				fecha = html.getString("fecha");
				notid = html.getString("id_noticia");
				url1 = html.getString("url");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    titview.setText(titular);
		    cuerpview.setText(cuerpo);
		    dateview.setText(fecha);
		    cuerpview.setMovementMethod(new ScrollingMovementMethod());
		}	
		

	}
	
	
}
