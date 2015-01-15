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

import com.example.semandal.Log.loguear;
import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Perfil extends Activity {
	String datos;
	int iduser,pid,id,notid;
	private static Asincperfil backgroundTask;
	private static ProgressDialog pleaseWaitDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		TextView text = (TextView)this.findViewById(R.id.munc);
		id = getIntent().getIntExtra("id",0);
		pid = getIntent().getIntExtra("p_id",0);
		iduser = getIntent().getIntExtra("user_id",0);
		datos = getIntent().getStringExtra("datos");
		Asincperfil tarea = null;
		tarea = new Asincperfil(this,(TextView)this.findViewById(R.id.nperfil),
				text,
				(TextView) this.findViewById(R.id.puntuacion),
				(TextView) findViewById(R.id.textView5),
				(TextView) findViewById(R.id.ln),
				Singleton.url+":8000/api/usuario/"+id,this
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
				Intent i = new Intent(Perfil.this, LPueblos.class);
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
	public void onPause(){
		super.onPause();
		if (pleaseWaitDialog != null)
			pleaseWaitDialog.dismiss();
	}

	public void onResume(){
		super.onResume();
		if((backgroundTask!=null)&&(backgroundTask.getStatus()==Status.RUNNING)){
			if(pleaseWaitDialog != null)
				pleaseWaitDialog.show();
		}
	}


		void onTaskCompleted(Object _response) 
		{ 

		}

	public class Asincperfil extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		TextView nombre,puntuacion,comentario,noticia,municipio;
		JSONObject perfil;
	    private Perfil activity;
	    private boolean completed;
	    private Object _response;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asincperfil(Context contexto,TextView nombre,TextView municipio,
				TextView puntuacion,TextView comentario,TextView noticia,String url,Perfil activity){
			this.contexto = contexto;
			this.nombre = nombre;
			this.puntuacion = puntuacion;
			this.comentario = comentario;
			this.noticia = noticia;
			this.municipio = municipio;
			this.url = url;
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
		public void onPostExecute(Object response){
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
				notid = l.getInt("idnoticia");

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			this.nombre.setText(nombre);
			this.puntuacion.setText(puntuacion);
			this.municipio.setText(municipio);
			this.comentario.setText(comentario);
			this.noticia.setText(noticia);
	           completed = true;
	            _response = response;
	            notifyActivityTaskCompleted();
	        //Close the splash screen
	        if (pleaseWaitDialog != null)
	        {
	            pleaseWaitDialog.dismiss();
	            pleaseWaitDialog = null;
	        }

			}	
		    public void setActivity(Perfil activity) 
		    { 
		        this.activity = activity; 
		        if ( completed ) { 
		            notifyActivityTaskCompleted(); 
		        } 
		    } 
	    //Pre execution actions
	    @Override 
	    protected void onPreExecute() {
	            //Start the splash screen dialog
	            if (pleaseWaitDialog == null)
	                pleaseWaitDialog= ProgressDialog.show(activity, "Entrando",
	                                                       "Cargando datos", 
	                                                       false);

	    } 

	    
	   //Notify activity of async task completion
	    private void notifyActivityTaskCompleted() 
	    { 
	        if ( null != activity ) { 
	            activity.onTaskCompleted(_response); 
	        } 
	    } 

	//for maintain attached the async task to the activity in phone states changes
	   //Sets the current activity to the async task

		}



}
