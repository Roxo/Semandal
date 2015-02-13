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
import com.example.semandal.Display_not_log.Asinadd;
import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Deuda extends Activity{
	int iduser,pid,puebloant,puebloact;
	private String urlgmaps;
	private static AsinDeuda backgroundTask;
	private static Asinadd backgroundTask1;

	private static ProgressDialog pleaseWaitDialog;
	private List<String> lista1;
	private List<Integer> lista1aux;
	private Deuda a = this;
	private int indice;
	boolean fromdatos=false,addpueblo=false,enabled = false;
	TextView deuda;
	TextView municipio;
	TextView provincia;
	TextView latitud;
	TextView longitud;
	TextView cp;
	TextView urlweb;
	TextView habitantes;
	TextView superficie;		
	TextView urlwiki,nnots;
	AutoCompleteTextView autotext;
	ImageView b6,ulg,b7;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deuda);
		// DEFINICIÓN DE LOS BOTONES
		ImageView b1 = (ImageView)this.findViewById(R.id.Amigos);
		ImageView b2 = (ImageView)this.findViewById(R.id.Noticias);
		ImageView b3 = (ImageView)this.findViewById(R.id.deuda);
		ImageView b5 = (ImageView)this.findViewById(R.id.button1);
		b6 = (ImageView)this.findViewById(R.id.button2);
		b7 = (ImageView)this.findViewById(R.id.snots);
		// DEFINICIÓN DE LOS TEXTVIEW
		deuda = (TextView)this.findViewById(R.id.textodeuda);
		municipio = (TextView)this.findViewById(R.id.textomunicipio);
		provincia = (TextView)this.findViewById(R.id.Provincia);
		latitud = (TextView)this.findViewById(R.id.latitud);
		longitud = (TextView)this.findViewById(R.id.longitud);
		cp = (TextView)this.findViewById(R.id.cp);
		urlweb = (TextView)this.findViewById(R.id.urlweb);
		habitantes = (TextView)this.findViewById(R.id.habitantes);
		superficie = (TextView)this.findViewById(R.id.superficie);		
		urlwiki = (TextView)this.findViewById(R.id.wikiurl);
		ulg = (ImageView)a.findViewById(R.id.gmaps1);
		nnots = (TextView)this.findViewById(R.id.nnots);
		autotext = (AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView1);
		urlwiki.setTextColor(Color.parseColor("#008000"));
		urlweb.setTextColor(Color.parseColor("#008000"));
		//////////////////////////////////////////////
		indice = getIntent().getIntExtra("indice",0);
		iduser = getIntent().getIntExtra("user_id",0);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		AsinDeuda tarea = null;
		puebloant= pid;
		try{
			puebloact = getIntent().getIntExtra("pb",0);
			if(puebloact != 0){
				puebloant = puebloact;
			}
		}catch(Exception e){
			
		}
		
		b7.setOnClickListener(new OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                // TODO Auto-generated method stub  
				Intent i = new Intent(Deuda.this, Lnoticias.class);
				String stringfinal = "id_p:"+puebloant;
				stringfinal = "("+stringfinal+")";
				i.putExtra("datos", stringfinal);
				i.putExtra("busqueda",true);
				i.putExtra("pueblito", municipio.getText().toString());
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
            }  
        });  


		tarea = new AsinDeuda(this,deuda,municipio,provincia,latitud,longitud,cp,urlweb,habitantes,
				superficie,urlwiki,
				Singleton.url+":8000/api/pueblos/"+puebloant,this,
				Singleton.url+":8000/api/usuario/seguimiento/"+puebloant+"/"+iduser,b6,
				autotext,nnots
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

      ulg.setOnClickListener(new OnClickListener() {  
          @Override  
          public void onClick(View v) {  
              // TODO Auto-generated method stub  
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlgmaps));
				startActivity(browserIntent);

          }  
      });  

		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!enabled)
					showDialogSigue(a,"Confirmación","¿Está seguro que quiere seguir este pueblo?");
				if(enabled)
					showDialogNoSigue(a,"Confirmación","¿Está seguro que quiere dejar de seguir este pueblo?");
			}
			
		});		

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String pueblo = autotext.getText().toString();
				int p = 0;
				if(!pueblo.equalsIgnoreCase("")){
					p = buscapuebloid(pueblo);
				}
				int idpueblo = 0;
				if(p != 0){
					idpueblo = lista1aux.get(p);
				}
				if(idpueblo!= 0){
					puebloant=idpueblo;
					AsinDeuda tarea = new AsinDeuda(a,deuda,municipio,provincia,latitud,longitud,cp,urlweb,habitantes,
							superficie,urlwiki,
							Singleton.url+":8000/api/pueblos/"+puebloant,a,
							Singleton.url+":8000/api/usuario/seguimiento/"+puebloant+"/"+iduser,b6,
							autotext,nnots
							);
					tarea.execute();
				}
				else{
					 Toast.makeText(getApplicationContext(), "Necesita seleccionar un pueblo", Toast.LENGTH_LONG).show();
				}
			}
			private int buscapuebloid(String pueblo) {
				boolean encontrado = false;
				int i = 0;
				while(!encontrado && i<lista1.size()){
					if(lista1.get(i).equalsIgnoreCase(pueblo)){
						encontrado = true;
						return i;
					}
					i++;
				}
				return 0;				
			}

		});		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			/*	Intent i = new Intent(Deuda.this, Amigos.class);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);*/
				showDialogSalir(a,"Confirmación","Desea desloguearse?");
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Deuda.this, Lnoticias.class);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Deuda.this, LPueblos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Deuda.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
	}
	
	public void showDialogSigue(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Deuda.this);
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
				Asinadd tarea = new Asinadd(
						Singleton.url+":8000/api/addsigue/"+iduser+"/"+puebloant,a
						);
					tarea.execute();
		    }
		});
		b.show();
	}	

	public void showDialogSalir(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Deuda.this);
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
				Intent i = new Intent(Deuda.this, Nolog.class);
				startActivity(i);
		    }
		});
		b.show();
	}	

	public void showDialogNoSigue(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Deuda.this);
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
				Asinadd tarea = new Asinadd(
						Singleton.url+":8000/api/usuario/borraseguimiento/"+puebloant+"/"+iduser,a
						);
					tarea.execute();
		    }
		});
		b.show();
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

		if(addpueblo){
			addpueblo=false;
			AsinDeuda tarea = new AsinDeuda(a,deuda,municipio,provincia,latitud,longitud,cp,urlweb,habitantes,
					superficie,urlwiki,
					Singleton.url+":8000/api/pueblos/"+puebloant,a,
					Singleton.url+":8000/api/usuario/seguimiento/"+puebloant+"/"+iduser,b6,
					autotext,nnots
					);
			tarea.execute();
		}
	}

	public class AsinDeuda extends AsyncTask<Void, Void, Object> {
		Context contexto;
		TextView deuda,municipio,provincia,latitud,longitud,cp,urlweb,habitantes,
		superficie,urlwiki,ulg;
		String url,usuario;
		JSONObject pueblos,d,usig;
	    private boolean completed;
	    private Deuda activity;
	    private Object _response;
	    ImageView  b6;
		AutoCompleteTextView pob;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsinDeuda(Context contexto,TextView deuda,TextView municipio,TextView provincia,
				TextView latitud,TextView longitud,TextView cp,TextView urlweb,TextView habitantes,
				TextView superficie,TextView urlwiki,
				String url,Deuda activity,String usersigue,ImageView b6,AutoCompleteTextView t,TextView ulg){
			this.usuario = usersigue;
			this.contexto = contexto;
			this.deuda = deuda;
			this.municipio = municipio;
			this.provincia = provincia;
			this.cp = cp;
			this.urlweb = urlweb;
			this.habitantes = habitantes;
			this.superficie = superficie;
			this.urlwiki = urlwiki;
			this.url = url;
			this.activity=activity;
			this.b6 = b6;
			this.pob = t;
			this.latitud=latitud;
			this.longitud = longitud;
			this.ulg = ulg;
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
			  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leerdatos();
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
			int numnot=0;
			try {
			JSONArray p1 = d.getJSONArray("pueblos");
			JSONObject pueblo = (JSONObject) p1.get(0);
			deuda.setText(""+pueblo.getDouble("deuda"));
			municipio.setText(pueblo.getString("dspueblo")+"  ");
			cp.setText(""+pueblo.getInt("cp"));
			urlweb.setText(pueblo.getString("url"));
			habitantes.setText(""+pueblo.getInt("habitantes"));
			provincia.setText(d.getString("dsprovincia"));
			superficie.setText(""+pueblo.getDouble("superficie"));
			urlwiki.setText(pueblo.getString("wiki"));
			JSONObject c=  pueblo.getJSONObject("coordenadas");
			latitud.setText(""+c.getDouble("latitud"));
			longitud.setText(""+c.getDouble("longitud"));
			urlgmaps =("http://maps.google.es/?q="+c.getDouble("latitud")+"%20"+c.getDouble("longitud"));
			///////////////////////////////////////////////////////////////////////
			ulg.setText(""+pueblo.getInt("n_noticias"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
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
			
	        BDClass admin1 = new BDClass(contexto,"following", null, 1);
		    SQLiteDatabase db1 = admin1.getReadableDatabase();
			sql = "SELECT * FROM siguiendo WHERE id="+puebloant ;
			c = db1.rawQuery(sql, null);
			if(c.getCount()==0){
				enabled = false;
				b6.setEnabled(true);
				b6.setImageResource(R.drawable.soff);
				b6.getLayoutParams().height = 40;
				b6.getLayoutParams().width = 40;
			}
			else{
				enabled = true;
				b6.setEnabled(true);
				b6.setImageResource(R.drawable.son);
				b6.getLayoutParams().height = 40;
				b6.getLayoutParams().width = 40;
}
			db1.close();
			
			ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item, lista1);
			pob.setAdapter(adaptador1);
		}catch(Exception e){
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
	
  

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
	public class Asinadd extends AsyncTask<Void, Void, Object> {
		String url;
		Context contexto;
	    private Deuda activity;
	    private boolean completed;
	    private Object _response;
	    JSONObject datosuser,html;
	    private String urlsigue = Singleton.url+":8000/api/logginuser/"+iduser;

		public Asinadd(String url,Deuda activity){
			this.url=url;
			this.activity = activity;
			this.contexto = activity;
		}
		@Override
		protected Void doInBackground(Void... params) {
			try {
				actualizar();
				leerdatos();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
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
	                                                       "Actualizando información", 
	                                                       false);

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
				    InputStream is = new URL(urlsigue).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				       datosuser = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		  


	    public void onPostExecute(Object response){
	        BDClassSeguimiento admin = new BDClassSeguimiento(contexto,"following", null, 1);
	        SQLiteDatabase bd = admin.getWritableDatabase();
			bd.execSQL("DELETE FROM siguiendo");
	        bd.execSQL("INSERT INTO siguiendo VALUES ("+(-1)+", '"+"Todos"+"',' ')");
	        bd.execSQL("INSERT INTO siguiendo VALUES ("+0+", '"+"Sigo"+"',' ')");
			try {
				JSONArray psig = datosuser.getJSONArray("siguiendo");
				for (int i = 0;i<psig.length(); i++){
					JSONObject f = psig.getJSONObject(i);
					bd.execSQL("INSERT INTO siguiendo VALUES ("+f.getInt("id_pueblo")+", '"+f.getString("dspueblo")+"', '"+f.getString("busquedaimagenes")+"')");
				}
			bd.close();
			
			String cadena = html.getString("message");
			if(html.getBoolean("ret")){
				enabled = !enabled;
	    		if(enabled){
					b6.setImageResource(R.drawable.son);
					b6.getLayoutParams().height = 40;
					b6.getLayoutParams().width = 40;
	    		}
	    		else{
					b6.setImageResource(R.drawable.soff);
					b6.getLayoutParams().height = 40;
					b6.getLayoutParams().width = 40;
	    		}

			}
			Toast.makeText(getApplicationContext(), cadena, Toast.LENGTH_LONG).show();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
