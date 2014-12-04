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
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Logueado extends Activity {
	String pid="",notid="",iduser="";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logueado);
		
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		iduser = getIntent().getStringExtra("user_id");
		TextView bienvenida=(TextView) this.findViewById(R.id.bienvenida);
		TextView noticia=(TextView) this.findViewById(R.id.noticias);
		TextView pueblo=(TextView) this.findViewById(R.id.pueblo);
		Asinlog tarea = null;
		tarea = new Asinlog(this,bienvenida,noticia,pueblo,
				Singleton.url+":8000/api/logginuser/"+iduser
				);
		tarea.execute();
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Amigos.class);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Lnoticias.class);
				i.putExtra("datos", "(id_p:"+pid+")");
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Deuda.class);
				i.putExtra("p_id", pid);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
	

	}
	public class Asinlog extends AsyncTask<Void, Void, Void> {
		Context contexto;
		String url;
		TextView bienvenida,noticia,pueblo;
		JSONObject datosuser;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asinlog(Context contexto,TextView bienvenida,TextView noticia,TextView pueblo,String url){
			this.contexto = contexto;
			this.noticia = noticia;
			this.url = url;
			this.bienvenida = bienvenida;
			this.pueblo = pueblo;
			
		}
		
		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }


			  
			  public void leerdatos() throws IOException, JSONException {
				    InputStream is = new URL(url).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				       datosuser = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leerdatos();
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
			try {
				notid=datosuser.getString("notid");
				pid=datosuser.getString("pid");
				bienvenida.setText("Bienvenido "+datosuser.getString("dsusuario"));
			    noticia.setText(datosuser.getString("dstitular"));
			    pueblo.setText(datosuser.getString("dspueblo"));
			    iduser=datosuser.getString("id");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		

	}
	
	

}
