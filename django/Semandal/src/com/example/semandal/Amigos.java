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

import com.example.semandal.Lnoticias.AsincLN;
import com.example.semandal.aux.Amigo;
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Amigos extends Activity {
	private String datos,pid,iduser;
	LinkedList<String> auxlist=new LinkedList<String>(), auxlistpueblo = new LinkedList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_amigos);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		final ListView lista = (ListView)this.findViewById(R.id.listView1);
		pid = getIntent().getStringExtra("p_id");
		iduser = getIntent().getStringExtra("user_id");
		datos = getIntent().getStringExtra("datos");
		AsincA tarea = null;
		tarea = new AsincA(this,
				Singleton.url+":8000/api/usuario/"+iduser+"/amigos/",lista, this
				);
		tarea.execute();

		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Amigos.this, Amigos.class);
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
				Intent i = new Intent(Amigos.this, Lnoticias.class);
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
				Intent i = new Intent(Amigos.this, Deuda.class);
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
				Intent i = new Intent(Amigos.this, Logueado.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        Intent i= new Intent(Amigos.this,Perfil.class);
		        int k =  (Integer) lista.getAdapter().getItem(pos);
		        String l = auxlist.get(k);
		        i.putExtra("id",l);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
				 finish();
		    }
		});


	}
	
	public class AsincA extends AsyncTask<Void, Void, Void> {
		Context contexto;
		String url;
		ListView lista;
		JSONObject Amigos;
		Activity activity;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincA(Context contexto,
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
				      Amigos = new JSONObject(jsonText);
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
			List<Amigo> mandar = new ArrayList<Amigo>();
			Amigo k;
			try {
				int namigos = Integer.parseInt(Amigos.getString("namigos"));
				if(namigos==0){
					k=new Amigo("En este momento no tiene amigos","","");
					mandar.add(k);
				}
				JSONArray lcoment = Amigos.getJSONArray("amigos");
				for(int i = 0; i<lcoment.length();i++){
						JSONObject coment = (JSONObject) lcoment.get(i);
						String id_friend = coment.getString("id_amigo");
						String nombre = coment.getString("nombre");
						String ap1 = coment.getString("ap1");
						String ap2 = coment.getString("ap2");
						String nya = nombre + " " + ap1 + " " + ap2;
						String usuario = coment.getString("amigo");
						String pueblo = coment.getString("pueblo");
						String idpueblo = coment.getString("idpueblo");
						auxlist.add(id_friend);
						auxlistpueblo.add(idpueblo);
						k = new Amigo(usuario,nya,pueblo);
						mandar.add(k);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.setAdapter(new Plantilla_amigos(activity,mandar));

			
		}	
		

	}

}
