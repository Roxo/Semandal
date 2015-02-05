package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Log.loguear;
import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Perfil extends Activity {
	int iduser,indice;
	private static Asincperfil backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private List<String> lista1;
	private List<Integer> lista1aux;
	boolean from = false;
	TextView municipio;
	TextView usuario;
	Perfil a = this;
	AutoCompleteTextView auto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		
		ImageView b1 = (ImageView)this.findViewById(R.id.Amigos);
		ImageView b2 = (ImageView)this.findViewById(R.id.Noticias);
		ImageView b3 = (ImageView)this.findViewById(R.id.deuda);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		Button exit = (Button)this.findViewById(R.id.modificar);
		municipio = (TextView)this.findViewById(R.id.munc);
		usuario = (TextView)this.findViewById(R.id.nperfil);
		auto = (AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView1);
		iduser = getIntent().getIntExtra("user_id",0);
		indice = getIntent().getIntExtra("indice",0);
		Asincperfil tarea = null;
		tarea = new Asincperfil(this,municipio,usuario,auto,
				Singleton.url+":8000/api/usuario/"+iduser);
		tarea.execute();
	
		
		exit.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String pueblo = auto.getText().toString().replace(" ","%20");
				if(!auto.getText().toString().equalsIgnoreCase("")){
					Cambiar tarea = new Cambiar(Singleton.url+":8000/api/usuario/mprincipal/"+iduser+"/"+pueblo,a);
					tarea.execute();
				}
			}
			
		});		
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			/*	Intent i = new Intent(Perfil.this, Amigos.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
				startActivity(i);*/
				showDialogSalir(a,"Confirmación","Desea desloguearse?");

			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Perfil.this, Lnoticias.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Perfil.this, LPueblos.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Perfil.this, Logueado.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
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
			if(from){
				from = false;
				Asincperfil tarea = new Asincperfil(this,municipio,usuario,auto,
						Singleton.url+":8000/api/usuario/"+iduser);
				tarea.execute();
			}
		}

		public void showDialogSalir(Activity activity, String title, CharSequence message) {
			AlertDialog.Builder b = new AlertDialog.Builder(Perfil.this);
			final AlertDialog builder = b.create();
			b.setTitle(title);
			b.setMessage(message);
			b.setNegativeButton("No", new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int id) {
			    	builder.cancel();
			    }
			});
			b.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
			    public void onClick(DialogInterface dialog, int id) {
					Intent i = new Intent(Perfil.this, Nolog.class);
					startActivity(i);
			    }
			});
			b.show();
		}	

	public class Asincperfil extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		TextView nombre,municipio;
		 AutoCompleteTextView auto;
		JSONObject perfil;
	    private Perfil activity;
	    private boolean completed;
	    private Object _response;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		  public Asincperfil(Perfil perfil2, TextView municipio2,
				TextView usuario, AutoCompleteTextView auto, String string) {
			  this.contexto = perfil2;
			  this.activity = perfil2;
			  this.nombre = usuario;
			  this.auto = auto;
			  this.municipio = municipio2;
			  this.url = string;
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
				String name = "",mun = "";
		        BDClass admin = new BDClass(contexto,"administracion", null, 1);
			    SQLiteDatabase db = admin.getReadableDatabase();
				String sql = "SELECT * FROM pueblos" ;
				Cursor c = db.rawQuery(sql, null);
				int a = c.getCount();
				lista1= new ArrayList<String>();
				lista1aux= new ArrayList<Integer>();
				if (c.moveToFirst()){
					do{
						lista1.add(c.getString(1));
						lista1aux.add(c.getInt(0));
					}while(c.moveToNext());
				}
				db.close();
			
			try {
				name = perfil.getString("dsusuario");
				mun = perfil.getString("dspueblo");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			this.nombre.setText(name);
			this.municipio.setText(mun);
			
			ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item, lista1);
			auto.setAdapter(adaptador1);

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


	public class Cambiar extends AsyncTask<Void, Void, Object> {
		String url;
	    private Perfil activity;
	    private boolean completed;
	    private Object _response;
	    private JSONObject html;

		public Cambiar(String url, Perfil t){
			this.url=url;
			this.activity = t;
		}
		@Override
		protected Void doInBackground(Void... params) {
			try {
				try {
					actualizar();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }

			  public void actualizar() throws IOException, JSONException {
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
	    protected void onPreExecute() {
	            //Start the splash screen dialog
	                pleaseWaitDialog= ProgressDialog.show(activity, 
	                                                       "Espere un segundo", 
	                                                       "Modificando municipio principal", 
	                                                       false);

	    } 

	    public void onPostExecute(Object response){
	    	Boolean votado = false;
	    	String answer="";
	    	try {
				votado = html.getBoolean("ret");
				answer = html.getString("message");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
            from = true;

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
	   //Notify activity of async task completion
	    private void notifyActivityTaskCompleted() 
	    { 
	        if ( null != activity ) { 
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	}
}
