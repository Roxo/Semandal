package com.example.semandal;

import java.io.BufferedReader;

import com.example.semandal.Logueado.Asinlog;
import com.example.semandal.aux.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;

public class Nolog extends ActionBarActivity {
	String idnoticia="",answer = "";
	String idnoticiacomentario="";
	private static Nolog backgroundTask;
	private static ProgressDialog pleaseWaitDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_nolog);


		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
	//	Button b4 = (Button)this.findViewById(R.id.auxiliar);
		Button b5 = (Button)this.findViewById(R.id.notrel);
		Button b6 = (Button)this.findViewById(R.id.Noticiaentera);

		AsincronNolog tarea = null;
		tarea = new AsincronNolog(this,(TextView) findViewById(R.id.titnoticia),
				(TextView) findViewById(R.id.lastnew),
				(TextView) findViewById(R.id.fecha),
				(TextView) findViewById(R.id.lastcomment),
				(TextView) findViewById(R.id.commentaut),
				Singleton.url+":8000/api/noticias/ultima/",
				Singleton.url+":8000/api/comentarios/ultimo",b5
			);
		tarea.execute();
		
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if (null != activeNetwork) {
			if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
				answer="You are connected to a WiFi Network";
			if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
				answer="You are connected to a Mobile Network";
		}
		 else{
			 answer = "Se necesita conexión a internet";
			 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
		 }

		
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Display_not_nolog.class);
				i.putExtra("id", idnoticiacomentario);
				startActivity(i);
			}
			
		});	
		
		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Display_not_nolog.class);
				i.putExtra("id", idnoticia);
				startActivity(i);
			}
			
		});		
		
	/*	b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Logueado.class);
				i.putExtra("user_id", "2");
				startActivity(i);
			}
			
		});		*/
		
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Log.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Bnolog.class);
				startActivity(i);
			}
			
		});
		
	}
	
	public class AsincronNolog extends AsyncTask<Void, Void, Void> {
		Context contexto;
		String url;
		TextView titview,cuerpview,dateview,commentview,authview;
		JSONObject html, Comentario;
		String urlcomment;
		String devolver;
		Button b;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincronNolog(Context contexto,TextView titview,TextView cuerpview,
				TextView dateview,TextView commentview,TextView authview,String url,
				String urlcomment,Button b){
			this.contexto = contexto;
			this.titview = titview;
			this.cuerpview = cuerpview;
			this.dateview = dateview;
			this.commentview = commentview;
			this.authview = authview;
			this.urlcomment = urlcomment;
			this.url = url;
			this.b = b;
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
			  
			  public void leercomentario() throws IOException, JSONException {
				    InputStream is = new URL(urlcomment).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				       Comentario = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					if (!answer.equals("Se necesita conexión a internet")){
					leernoticia();
					leercomentario();
					}
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
			String titular = "",cuerpo="", fecha = "",user="",comentario="No existen comentarios";
				if(html != null && Comentario != null){
				try{
					if(html.getBoolean("existe")){
					titular = html.getString("titular").replace("-","\n");
					cuerpo = html.getString("cuerpo").replace("-", "\n");
					fecha = html.getString("fecha");
					idnoticia = html.getString("notid");
					}
					if(Comentario.getBoolean("existe")){
					user = Comentario.getString("autor");
					comentario=Comentario.getString("cuerpo");
					idnoticiacomentario=Comentario.getString("notid");
					}
					if(comentario=="No existen comentarios")
						b.setEnabled(false);
				
				} catch (JSONException e) {
					// TODO Auto-generated catch block
			}
				}
		    titview.setText(titular);
		    cuerpview.setText(cuerpo);
		    dateview.setText(fecha);
		    authview.setText(user);
		    commentview.setText(comentario);
		    cuerpview.setMovementMethod(new ScrollingMovementMethod());
		    commentview.setMovementMethod(new ScrollingMovementMethod());
		}	
		

	}
	
	

	}
	


