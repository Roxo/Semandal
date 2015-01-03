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

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Asinc tarea =new Asinc(this,Singleton.url+":8000/api/pueblos",
				Singleton.url+":8000/api/noticias/categorias/",this);
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
			Intent i = new Intent(MainActivity.this, Nolog.class);
			startActivity(i);
		}

		public class Asinc extends AsyncTask<Void, Void, Object> {
			Context contexto;
			String urlpueblos,urlcategorias;
			JSONObject pueblos, categorias;
			private boolean completed;
		    private Object _response;
		    private MainActivity activity;
			/*
			 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
			 * 
			 * */
			
			public Asinc(Context contexto,String urlpueblos, String urlcategorias,MainActivity activity){
				this.contexto = contexto;
				this.urlpueblos=urlpueblos;
				this.urlcategorias=urlcategorias;
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
						leerpueblos();
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
					bd.execSQL("DELETE FROM pueblos");
					bd.execSQL("DELETE FROM categorias");
					int npueblos = pueblos.getInt("npueblos");
					int ncategorias = categorias.getInt("ncategorias");
					if(npueblos!=0){
						JSONArray p = pueblos.getJSONArray("pueblos");
						for(int i = 0;i<npueblos;i++){
							JSONObject f = (JSONObject)p.get(i);
							bd.execSQL("INSERT INTO pueblos VALUES ('"+f.getString("idpueblo")+"', '"+f.getString("nombre")+"')");
						}
					}
					if(ncategorias!=0){
						JSONArray c = categorias.getJSONArray("categorias");
						for(int i = 0;i<ncategorias;i++){
							JSONObject f = (JSONObject)c.get(i);
							String cat = f.getString("categoria");
							JSONArray cat2 = f.getJSONArray("identificadores");
							for(int j = 0;j<cat2.length();j++){
								JSONObject k = (JSONObject)cat2.get(j);
								bd.execSQL("INSERT INTO categorias VALUES ('"+k.getString("id")+"', '"+cat+"')");
							}
						}
					}
					bd.close();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
	            activity.onTaskCompleted(_response); 
	        } 
	    } 

	//for maintain attached the async task to the activity in phone states changes
	   //Sets the current activity to the async task

		}

}
