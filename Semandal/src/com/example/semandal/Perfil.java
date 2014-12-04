package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Perfil extends Activity {
	String datos,iduser,pid,id,notid;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		id = getIntent().getStringExtra("id");
		pid = getIntent().getStringExtra("p_id");
		iduser = getIntent().getStringExtra("user_id");
		datos = getIntent().getStringExtra("datos");
		Asincperfil tarea = null;
		tarea = new Asincperfil(this,(TextView)this.findViewById(R.id.nperfil),
				(Button) this.findViewById(R.id.municipio),
				(TextView) this.findViewById(R.id.puntuacion),
				(TextView) findViewById(R.id.textView5),
				(TextView) findViewById(R.id.ln),
				Singleton.url+":8000/api/usuario/"+id
				);
		tarea.execute();
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Perfil.this, Amigos.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Perfil.this, Lnoticias.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Perfil.this, Deuda.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Perfil.this, Logueado.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
	}
	
	public class Asincperfil extends AsyncTask<Void, Void, Void> {
		Context contexto;
		String url;
		TextView nombre,puntuacion,comentario,noticia;
		Button municipio;
		JSONObject perfil;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asincperfil(Context contexto,TextView nombre,Button municipio,
				TextView puntuacion,TextView comentario,TextView noticia,String url){
			this.contexto = contexto;
			this.nombre = nombre;
			this.puntuacion = puntuacion;
			this.comentario = comentario;
			this.noticia = noticia;
			this.municipio = municipio;
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

			  public void leerperfil() throws IOException, JSONException {
			    InputStream is = new URL(url).openStream();
			    try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			      String jsonText = readAll(rd);
			       perfil = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
			  }

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leerperfil();
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
			String nombre="",municipio="",puntuacion="",comentario="",noticia="";
			try {
				nombre = perfil.getString("dsusuario");
				municipio = perfil.getString("dspueblo");
				JSONArray comentarios = perfil.getJSONArray("comentarios_recientes");
				JSONObject k = comentarios.getJSONObject(comentarios.length()-1);
				comentario = k.getString("comentario");
				JSONArray noticias = perfil.getJSONArray("noticias");
				JSONObject l = noticias.getJSONObject(noticias.length()-1);
				noticia = l.getString("dstitular");
				notid = l.getString("idnoticia");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			this.nombre.setText(nombre);
			this.puntuacion.setText(puntuacion);
			this.municipio.setText(municipio);
			this.comentario.setText(comentario);
			this.noticia.setText(noticia);
		}	
		

	}

}
