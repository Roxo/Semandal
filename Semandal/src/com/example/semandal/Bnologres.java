package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Comentarios_nolog.AsincCNL;
import com.example.semandal.aux.Comentario;
import com.example.semandal.aux.Noticia;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;

public class Bnologres extends Activity{
	LinkedList<String> auxlist = new LinkedList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bnologres);
		String datos = getIntent().getStringExtra("datos");
		Button b4 = (Button)this.findViewById(R.id.button1);
		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
		final ListView lista = (ListView)this.findViewById(R.id.listView1);
		AsincBNL tarea = null;
		tarea = new AsincBNL(this,
				Singleton.url+":8000/api/busqueda/"+datos,lista, this
				);
		tarea.execute();

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Log.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Bnolog.class);
				startActivity(i);
			}
			
		});
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Bnolog.class);
				startActivity(i);
			}
			
		});		
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        Intent i= new Intent(Bnologres.this,Display_not_nolog.class);
		        int k =  (Integer) lista.getAdapter().getItem(pos);
		        i.putExtra("id",auxlist.get(k));
				startActivity(i);
		        finish();                       
		    }
		});
		
	}
	
	


	public class AsincBNL extends AsyncTask<Void, Void, Void> {
		Context contexto;
		String url;
		ListView lista;
		JSONObject Noticias;
		Activity activity;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincBNL(Context contexto,
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
				      Noticias = new JSONObject(jsonText);
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
			List<Noticia> mandar = new ArrayList<Noticia>();
			Noticia k;
			try {
				JSONArray lcoment = Noticias.getJSONArray("resultado");
				for(int i = 0; i<lcoment.length();i++){
						JSONObject coment = (JSONObject) lcoment.get(i);
						String autor = coment.getString("noticia_id");
						String comentario = coment.getString("titular");
						String puntuacion = coment.getString("fecha");
						auxlist.add(autor);
						k = new Noticia(autor,puntuacion,comentario);
						mandar.add(k);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.setAdapter(new Plantilla_dispnot(activity,mandar));

			
		}	
		

	}

}
