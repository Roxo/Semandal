package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.aux.*;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Comentarios_nolog extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentarios_nolog);
	ListView lista =(ListView)this.findViewById(R.id.listacomentarios);
	Button b4 = (Button)this.findViewById(R.id.registro);
	Button b1 = (Button)this.findViewById(R.id.loggin);
	Button b2 = (Button)this.findViewById(R.id.info);
	Button b3 = (Button)this.findViewById(R.id.busqueda);
	String notid=getIntent().getStringExtra("id");
	AsincCNL tarea = null;
	tarea = new AsincCNL(this,
			Singleton.url+":8000/api/noticias/"+notid+"/comentarios",lista,this
			);
	tarea.execute();

	b4.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Comentarios_nolog.this, LoginActivity.class);
			startActivity(i);
		}
		
	});		
	
	b1.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Comentarios_nolog.this, LoginActivity.class);
			startActivity(i);
		}
		
	});		
	b2.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Comentarios_nolog.this, Informacion.class);
			startActivity(i);
		}
		
	});
	b3.setOnClickListener(new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent i = new Intent(Comentarios_nolog.this, Bnolog.class);
			startActivity(i);
		}
		
	});
	}
	
	public class AsincCNL extends AsyncTask<Void, Void, Void> {
		Context contexto;
		String url;
		ListView lista;
		JSONObject Comentarios;
		Activity activity;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincCNL(Context contexto,
				String urlcomment,ListView lista,Activity activity){
			this.contexto = contexto;
			this.url = urlcomment;
			this.lista = lista;			
			this.activity = activity;
		}
		
		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }



			  
			  
			  public void leercomentario() throws IOException, JSONException {
				    InputStream is = new URL(url).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				       Comentarios = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		
	


		@Override
		protected Void doInBackground(Void... params) {
			try {
				leercomentario();
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
			List<Comentario> mandar = new ArrayList<Comentario>();
			Comentario k;
			try {
				int ncomentarios = Integer.parseInt(Comentarios.getString("ncomentarios"));
				if (ncomentarios != 0){
				JSONArray lcoment = Comentarios.getJSONArray("comentarios");
				for(int i = 0; i<lcoment.length();i++){
						JSONObject coment = (JSONObject) lcoment.get(i);
						String autor = coment.getString("usuario");
						String comentario = coment.getString("comentario");
						String puntuacion = coment.getString("puntuacion");
						k = new Comentario(autor,puntuacion,comentario);
						mandar.add(k);
				}}else{
					String autor = "";
					String comentario = "No existen comentarios para esta noticia. Se el primero!";
					String puntuacion ="";
					k = new Comentario(autor,puntuacion,comentario);
					mandar.add(k);

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.setAdapter(new Plantilla_Comment(activity,mandar));

			
		}	
		

	}

}
