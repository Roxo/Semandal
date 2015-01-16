package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Comentarios.AsincCL;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Display_not_log extends Activity {
	int notid;
	String datos,url1;
	int iduser,indice;
	private static AsincronDNN backgroundTask;
	private static Set backgroundTask1;
	private static ProgressDialog pleaseWaitDialog;
	private boolean set=false;
	private Display_not_log a = this;
	Button b7;
	ListView lista ;
	LinkedList<Integer> idcats;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_not_log);
		//yourTextView.setMovementMethod(new ScrollingMovementMethod())
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		Button b5 = (Button)this.findViewById(R.id.comment);
		Button b6 = (Button)this.findViewById(R.id.button1);
		b7 = (Button)this.findViewById(R.id.button2);
		Button categoriza = (Button)this.findViewById(R.id.b1);
		lista = (ListView) this.findViewById(R.id.listView1);
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		notid=getIntent().getIntExtra("id",0);
		indice = getIntent().getIntExtra("indice",0);
		iduser = getIntent().getIntExtra("user_id",0);
		datos = getIntent().getStringExtra("datos");
		AsincronDNN tarea = null;
		tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
				(TextView) findViewById(R.id.Noticia),
				(TextView) findViewById(R.id.fecha),(TextView) findViewById(R.id.textView1),b7,
				Singleton.url+":8000/api/noticias/"+notid,Singleton.url+":8000/api/nliked/"+iduser+"/"+notid,this
				,(ListView) findViewById(R.id.listView1),(Button)findViewById(R.id.comment));
		tarea.execute();
		
		categoriza.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Seman.class);
				i.putExtra("id", notid);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});				

		b7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Set tarea = null;
				tarea = new Set(Singleton.url+":8000/api/addliked/"+iduser+"/"+notid,a);
				tarea.execute();
			}
			
		});				

		
		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
				startActivity(browserIntent);
			}
			
		});				

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Comentarios.class);
				i.putExtra("id", notid);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});				
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, LPueblos.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
				Intent i = new Intent(Display_not_log.this, Lnoticias.class);
				String stringfinal = "id_c:"+idcats.get(pos);
				stringfinal = "("+stringfinal+")";
				i.putExtra("datos", stringfinal);
				i.putExtra("busqueda", true);
				i.putExtra("noticia", datos);
				i.putExtra("indice", indice);
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



	private void onTaskCompleted(Object _response){
		if(set){
			finish();
			startActivity(getIntent());
			AsincronDNN tarea = null;
			tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
					(TextView) findViewById(R.id.Noticia),
					(TextView) findViewById(R.id.fecha),(TextView) findViewById(R.id.textView1),b7,
					Singleton.url+":8000/api/noticias/"+notid,Singleton.url+":8000/api/nliked/"+iduser+"/"+notid,this
					,(ListView) findViewById(R.id.listView1),(Button) findViewById(R.id.comment));
			tarea.execute();

			set=false;
		}

	}

	public class AsincronDNN extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url,urlsig;
		TextView titview,cuerpview,dateview,puntuacion,cat;
		Button b7,comentarios;
		JSONObject html,sig;
	    private Display_not_log activity;
	    private boolean completed;
	    private Object _response;
	    ListView lv;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincronDNN(Context contexto,TextView titview,TextView cuerpview,
			TextView dateview,TextView puntuacion, Button b7,
			String url,String urlsig,Display_not_log activity,ListView lv,
			Button comentarios){
			this.contexto = contexto;
			this.titview = titview;
			this.cuerpview = cuerpview;
			this.dateview = dateview;
			this.url = url;
			this.activity = activity;
			this.puntuacion = puntuacion;
			this.b7 = b7;
			this.urlsig = urlsig;
			this.lv = lv;
			this.comentarios = comentarios;
			
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
			  
			  public void sigo() throws IOException, JSONException {
				    InputStream is = new URL(urlsig).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				      sig = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }

		@Override
		protected Void doInBackground(Void... params) {

				try {
					if(!url.equalsIgnoreCase(""))
						leernoticia();
					if(!urlsig.equalsIgnoreCase(""))
						sigo();
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
			String titular = "ROTO",cuerpo="ROTO", fecha = "Roto",likes="roto",ca="roto";
			int ncomentarios=0;
			try {
				idcats = new LinkedList<Integer>();
				titular = html.getString("titular").replace("-","\n");
				cuerpo = html.getString("cuerpo").replace("-","\n");
				fecha = html.getString("fecha");
				notid = html.getInt("id_noticia");
				url1 = html.getString("url");
				likes = html.getString("liked");
				ncomentarios = html.getInt("ncomentarios");
				comentarios.setText("Ver Comentarios ("+ncomentarios+")");
				JSONArray cat = html.getJSONArray("categoria");
				String[] listacategorias = new String[cat.length()];
			    for(int i=0;i<cat.length();i++){
			    	JSONObject j = cat.getJSONObject(i);
			    	listacategorias[i] = j.getString("dscategoria");
			    	idcats.add(j.getInt("id_categoria"));
			    }
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto,
						android.R.layout.simple_list_item_1, listacategorias);
				lv.setAdapter(adapter);

				if(sig.getBoolean("sigue"))
					b7.setEnabled(false);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			puntuacion.setText(likes);
		    titview.setText(titular);
		    cuerpview.setText(cuerpo);
		    dateview.setText(fecha);
		    cuerpview.setMovementMethod(new ScrollingMovementMethod());
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
		    public void setActivity(Display_not_log activity) 
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
	                                                       "Cargando noticia", 
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

	public class Set extends AsyncTask<Void, Void, Object> {
		String url;
	    private Display_not_log activity;
	    private boolean completed;
	    private Object _response;

		public Set(String url,Display_not_log activity){
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
	                                                       "Guardando su 'me gusta'", 
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
	    public void setActivity(Display_not_log activity) 
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
	            set = true;
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	}
	


}
