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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.aux.AlmacenUsuario;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
	int iduser, vpactual=0, vcactual=0,vcmine=0,vpmine=0;
	boolean actualizar;
	AlmacenUsuario j;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		j = new AlmacenUsuario(this);
		iduser = Integer.parseInt(j.GetUsuario().split("-")[1]);
		vcmine = j.GetVcat();
		vpmine = j.GetVpbs();		
		setContentView(R.layout.activity_main);
		GetVersion tarea = new GetVersion(this,Singleton.url+":8000/api/versiones",
				vpmine,vcmine,this);
		tarea.execute();
	}
	
	
	public void onPause(){
		super.onPause();
	}

	public void onResume(){
		super.onResume();
	}


		void onTaskCompleted(Object _response) 
		{ 
			if(actualizar){
				Asinc tarea =new Asinc(this,Singleton.url+":8000/api/pueblos",
						Singleton.url+":8000/api/noticias/categorias/",vpmine,vcmine,this);
				tarea.execute();		
			}else {
				j.GuardarVersiones("pueblo",vpactual);
				j.GuardarVersiones("categorias",vcactual);
				if(iduser == 0){
					Intent i = new Intent(MainActivity.this, Nolog.class);
					startActivity(i);
				}
				else{
					Intent i =  new Intent(MainActivity.this,Logueado.class);
					i.putExtra("user_id",iduser);
					startActivity(i);
				}	
			}		

		}

		public class Asinc extends AsyncTask<Void, Void, Object> {
			Context contexto;
			String urlpueblos,urlcategorias;
			JSONObject pueblos, categorias;
			int vcmine,vpmine;
			private boolean completed;
		    private Object _response;
		    private MainActivity activity;
			/*
			 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
			 * 
			 * */
			
			public Asinc(Context contexto,String urlpueblos, String urlcategorias,int vpmine, int vcmine, MainActivity activity){
				this.contexto = contexto;
				this.urlpueblos=urlpueblos;
				this.urlcategorias=urlcategorias;
	            this.activity = activity;
	            this.vpmine = vpmine;
	            this.vcmine = vcmine;
			}
			
			  private String readAll(Reader rd) throws IOException {
				    StringBuilder sb = new StringBuilder();
				    int cp;
				    while ((cp = rd.read()) != -1) {
				      sb.append((char) cp);
				    }
				    return sb.toString();
				  }

				  public void leerpueblos() throws IOException, JSONException {
				    InputStream is = new URL(urlpueblos).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				       pueblos = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }
				  
				  public void leercategoria() throws IOException, JSONException {
					    InputStream is = new URL(urlcategorias).openStream();
					    try {
					      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
					      String jsonText = readAll(rd);
					       categorias = new JSONObject(jsonText);
					    } finally {
					      is.close();
					    }
				  }		  

			@Override
			protected Void doInBackground(Void... params) {

					try {
						if(vpmine != vpactual)
						leerpueblos();
						if(vcmine!=vcactual)
						leercategoria();
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
				try {
			        BDClass admin = new BDClass(contexto,"administracion", null, 1);
			        SQLiteDatabase bd = admin.getWritableDatabase();
					if(vpmine!=vpactual){
						bd.execSQL("DELETE FROM pueblos");
						int npueblos = pueblos.getInt("npueblos");
						if(npueblos!=0){
							JSONArray p = pueblos.getJSONArray("pueblos");
							for(int i = 0;i<npueblos;i++){
								JSONObject f = (JSONObject)p.get(i);
								bd.execSQL("INSERT INTO pueblos VALUES ("+f.getInt("idpueblo")+", '"+f.getString("nombre")+"')");
							}
						}
					}
					if(vcmine!=vcactual){
					bd.execSQL("DELETE FROM categorias");
					int ncategorias = categorias.getInt("ncategorias");
						if(ncategorias!=0){
							JSONArray c = categorias.getJSONArray("categorias");
							for(int i = 0;i<ncategorias;i++){
								JSONObject f = (JSONObject)c.get(i);
								String cat = f.getString("dscategoria");
								int idcat = f.getInt("id_categoria");
								if(idcat != 53)
									bd.execSQL("INSERT INTO categorias VALUES ("+idcat+", '"+cat+"')");
							}
						}
					}
					bd.close();
				} catch (Exception e) {
					 String answer = "Se necesita conexión a internet";
					 Toast.makeText(contexto.getApplicationContext(), answer, Toast.LENGTH_LONG).show();
				}
	            completed = true;
	            _response = response;
	            notifyActivityTaskCompleted();
			}	
		    public void setActivity(MainActivity activity) 
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
	    } 

	    
	   //Notify activity of async task completion
	    private void notifyActivityTaskCompleted() 
	    { 
	        if ( null != activity ) { 
	        	actualizar = false;
	            activity.onTaskCompleted(_response); 
	        } 
	    } 

	//for maintain attached the async task to the activity in phone states changes
	   //Sets the current activity to the async task

		}
		public class GetVersion extends AsyncTask<Void, Void, Object> {
			Context contexto;
			String urlversiones;
			JSONObject versiones;
			private boolean completed;
		    private Object _response;
		    private MainActivity activity;
		    int vpmine, vcmine;
		    
		GetVersion(Context contexto,String urlversiones,int vpmine,int vcmine,MainActivity activity){
			this.contexto = contexto;
			this.urlversiones=urlversiones;
            this.activity = activity;
            this.vpmine = vpmine;
            this.vcmine = vcmine;
		}
		
		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }

			  public void leerversiones() throws IOException, JSONException {
			    InputStream is = new URL(urlversiones).openStream();
			    try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			      String jsonText = readAll(rd);
			       versiones = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
			  }
			  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leerversiones();
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
			try {
				if(versiones.getBoolean("ret")){
					JSONArray ver = versiones.getJSONArray("versiones");
					for(int i = 0; i<ver.length();i++){
						JSONObject tab = ver.getJSONObject(i);
						if(tab.getString("TName").equalsIgnoreCase("pueblo"))
							vpactual=tab.getInt("version");
						else
							vcactual=tab.getInt("version");
					}
				}
			} catch (Exception e) {
				 String answer = "Se necesita conexión a internet";
				 Toast.makeText(contexto.getApplicationContext(), answer, Toast.LENGTH_LONG).show();
			}
            completed = true;
            _response = response;
            notifyActivityTaskCompleted();
		}	
	    public void setActivity(MainActivity activity) 
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
    } 

    
   //Notify activity of async task completion
    private void notifyActivityTaskCompleted() 
    { 
        if ( null != activity ) { 
        	if(vpactual!=vpmine || vcactual != vcmine)
        		actualizar = true;
            activity.onTaskCompleted(_response); 
        } 
    } 

//for maintain attached the async task to the activity in phone states changes
   //Sets the current activity to the async task

	}
}
