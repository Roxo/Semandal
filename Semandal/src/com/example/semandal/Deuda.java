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

import com.example.semandal.Bnolog.AsincBnolog;
import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.support.v7.app.ActionBarActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Deuda extends ActionBarActivity implements OnItemSelectedListener{
	String datos;
	int iduser,pid,puebloant,puebloact;
	private Spinner spinner1;
	private static AsinDeuda backgroundTask;
	private static Asinadd backgroundTask1;

	private static ProgressDialog pleaseWaitDialog;
	private List<String> lista1;
	private List<Integer> lista1aux;
	private Deuda a = this;
	private int posicion;
	boolean fromdatos=false,addpueblo=false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deuda);
		// DEFINICIÓN DE LOS BOTONES
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		Button b5 = (Button)this.findViewById(R.id.button1);
		Button b6 = (Button)this.findViewById(R.id.button2);

		// DEFINICIÓN DE LOS TEXTVIEW
		TextView deuda = (TextView)this.findViewById(R.id.textodeuda);
		TextView municipio = (TextView)this.findViewById(R.id.textomunicipio);
		TextView provincia = (TextView)this.findViewById(R.id.Provincia);
		TextView coordenadas = (TextView)this.findViewById(R.id.coordenadas);
		TextView cp = (TextView)this.findViewById(R.id.cp);
		final TextView urlweb = (TextView)this.findViewById(R.id.urlweb);
		TextView habitantes = (TextView)this.findViewById(R.id.habitantes);
		TextView superficie = (TextView)this.findViewById(R.id.superficie);		
		final TextView urlwiki = (TextView)this.findViewById(R.id.wikiurl);
		urlwiki.setTextColor(Color.CYAN);
		urlweb.setTextColor(Color.CYAN);
		//////////////////////////////////////////////
		pid = getIntent().getIntExtra("p_id",0);
		iduser = getIntent().getIntExtra("user_id",0);
		datos = getIntent().getStringExtra("datos");
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		AsinDeuda tarea = null;
		puebloant= pid;
		try{
			puebloact = getIntent().getIntExtra("pb",0);
			if(puebloact != 0){
				puebloant = puebloact;
			}
		}catch(Exception e){
			
		}

		tarea = new AsinDeuda(this,deuda,municipio,provincia,coordenadas,cp,urlweb,habitantes,
				superficie,urlwiki,
				Singleton.url+":8000/api/pueblos",
				Singleton.url+":8000/api/pueblos/"+puebloant,this,
				Singleton.url+":8000/api/usuario/seguimiento/"+puebloant+"/"+iduser,b6
				);
		tarea.execute();
     
		urlweb.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlweb.getText().toString()));
				startActivity(browserIntent);
            }  
        });  
      
      urlwiki.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlwiki.getText().toString()));
				startActivity(browserIntent);

            }  
        });  

		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					Asinadd tarea = new Asinadd(
						Singleton.url+":8000/api/addsigue/"+iduser+"/"+puebloant,a
						);
					tarea.execute();
				}

			
		});		

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(posicion != 0){
					Intent i = new Intent(Deuda.this, Deuda.class);
					i.putExtra("datos", datos);
					i.putExtra("user_id", iduser);
					i.putExtra("pb",lista1aux.get(posicion));
					i.putExtra("p_id", pid);
					startActivity(i);
				}
				else{
					 Toast.makeText(getApplicationContext(), "Necesita seleccionar un pueblo", Toast.LENGTH_LONG).show();
				}
			}
			
		});		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Deuda.this, Amigos.class);
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
				Intent i = new Intent(Deuda.this, Lnoticias.class);
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
				Intent i = new Intent(Deuda.this, Deuda.class);
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
				Intent i = new Intent(Deuda.this, Logueado.class);
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
		if((backgroundTask1!=null)&&(backgroundTask1.getStatus()==Status.RUNNING)){
			if(pleaseWaitDialog != null)
				pleaseWaitDialog.show();
		}

	}
	
	private void onTaskCompleted(Object _response) 
	{ 
		if(fromdatos){
		   spinner1 = (Spinner) findViewById(R.id.cat);
		   ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1);
		   adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner1.setAdapter(adaptador1);
		   spinner1.setOnItemSelectedListener(this);
			fromdatos = false;
		}
		if(addpueblo){
			Intent i = new Intent(Deuda.this, Deuda.class);
			i.putExtra("datos", datos);
			i.putExtra("user_id", iduser);
			i.putExtra("pb",puebloant);
			i.putExtra("p_id", pid);
			startActivity(i);

		}
	}

	public class AsinDeuda extends AsyncTask<Void, Void, Object> {
		Context contexto;
		TextView deuda,municipio,provincia,coordenadas,cp,urlweb,habitantes,
		superficie,urlwiki;
		String urlpueblos,url,usuario;
		JSONObject pueblos,d,usig;
	    private boolean completed;
	    private Deuda activity;
	    private Object _response;
	    Button b6;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsinDeuda(Context contexto,TextView deuda,TextView municipio,TextView provincia,
				TextView coordenadas,TextView cp,TextView urlweb,TextView habitantes,
				TextView superficie,TextView urlwiki,String urlpueblos,
				String url,Deuda activity,String usersigue,Button b6){
			this.usuario = usersigue;
			this.contexto = contexto;
			this.deuda = deuda;
			this.municipio = municipio;
			this.provincia = provincia;
			this.coordenadas = coordenadas;
			this.cp = cp;
			this.urlweb = urlweb;
			this.habitantes = habitantes;
			this.superficie = superficie;
			this.urlwiki = urlwiki;
			this.urlpueblos = urlpueblos;
			this.url = url;
			this.activity=activity;
			this.b6 = b6;
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
			       d = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
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

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leerdatos();
					leerpueblos();
					sigueusuario();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			return null;
		}


		  public void sigueusuario() throws IOException, JSONException {
			    InputStream is = new URL(this.usuario).openStream();
			    try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			      String jsonText = readAll(rd);
			      usig = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
			  }	
		  
		@Override
		public void onPostExecute(Object response){
			try {
			JSONArray p1 = d.getJSONArray("pueblos");
			JSONObject pueblo = (JSONObject) p1.get(0);
			deuda.setText("deuda obtenida a día 1/1/2014 \t\t"+pueblo.getDouble("deuda"));
			municipio.setText("Municipio: \t\t"+pueblo.getString("nombre"));
			cp.setText("Código postal: \t\t"+pueblo.getInt("cp"));
			urlweb.setText(pueblo.getString("url"));
			habitantes.setText("Habitantes: \t\t"+pueblo.getInt("habitantes"));
			provincia.setText("Provincia: \t\t"+d.getString("provincia"));
			superficie.setText("Superficie: \t\t"+pueblo.getDouble("superficie"));
			urlwiki.setText(pueblo.getString("wiki"));
			JSONObject c=  pueblo.getJSONObject("coordenadas");
			coordenadas.setText("Longitud: "+c.getDouble("longitud")+" . Latitud: "+c.getDouble("latitud"));
			///////////////////////////////////////////////////////////////////////
			if(usig.getBoolean("sigue")){
				b6.setEnabled(false);
			}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
	        BDClass admin = new BDClass(contexto,"administracion", null, 1);
		    SQLiteDatabase db = admin.getReadableDatabase();
			String sql = "SELECT * FROM pueblos" ;
			Cursor c = db.rawQuery(sql, null);
			int a = c.getCount();
			lista1= new ArrayList<String>();
			lista1aux= new ArrayList<Integer>();
	    	lista1.add("Pueblos");
	    	lista1aux.add(0);
			if (c.moveToFirst()){
				do{
					lista1.add(c.getString(1));
					lista1aux.add(c.getInt(0));
				}while(c.moveToNext());
			}
			
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
		
	    public void setActivity(Deuda activity) 
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
                pleaseWaitDialog= ProgressDialog.show(activity, 
                                                       "Espere un segundo", 
                                                       "Recopilando pueblos y categorías", 
                                                       false);

    } 


	    private void notifyActivityTaskCompleted() 
	    { 
	        if ( null != activity ) { 
	        	fromdatos = true;
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	
	}
	
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		String selected = parent.getItemAtPosition(pos).toString();
        	posicion=pos;
        
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
	public class Asinadd extends AsyncTask<Void, Void, Object> {
		String url;
	    private Deuda activity;
	    private boolean completed;
	    private Object _response;

		public Asinadd(String url,Deuda activity){
			this.url=url;
			this.activity = activity;
		}
		@Override
		protected Void doInBackground(Void... params) {
			try {
				actualizar();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		private void actualizar() throws MalformedURLException, IOException {
		    InputStream is = new URL(url).openStream();
		    is.close();
		}
		
	    @Override 
	    protected void onPreExecute() {
	            //Start the splash screen dialog
	                pleaseWaitDialog= ProgressDialog.show(activity, 
	                                                       "Espere un segundo", 
	                                                       "Agregando pueblo", 
	                                                       false);

	    } 

	    public void onPostExecute(Object response){
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
	    public void setActivity(Deuda activity) 
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
	        	addpueblo=true;
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	}
}
