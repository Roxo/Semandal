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

import com.example.semandal.Comentarios_nolog.AsincCNL;
import com.example.semandal.Lnoticias.AsincLN;
import com.example.semandal.aux.Comentario;
import com.example.semandal.aux.Noticia;
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
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Bnologres extends Activity{
	private static String PAGINA = "PRIMERO";
	private static String FROM = "FROM";
	private static String AEMPEZAR = "AEMPEZAR";

	LinkedList<Integer> auxlist = new LinkedList<Integer>();
	ArrayList<String> lista1= new ArrayList<String>();
	LinkedList<Integer> aux1list = new LinkedList<Integer>();
	String datos,pueblonuevo;
	ListView lista;
	int iduser,pid,indice;
	boolean fbusqueda=false,noeffect=false,completado = false,roto = false,first = true,from = false;
	private static AsincLN backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	int pagina,aempezar=0;
	Bnologres a = this;
	List<Noticia> mandar;
	Bundle bundle;	
	Noticia k;
	
	
	public void onSaveInstanceState(Bundle savedInstanceState) {
		bundle = savedInstanceState;
	    // Save the user's current game state
	    bundle.putInt(PAGINA, pagina);
	    bundle.putBoolean(FROM, true);
	    bundle.putInt(AEMPEZAR, aempezar);

	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bnologres);
		mandar = new ArrayList<Noticia>();
		final String datos = getIntent().getStringExtra("datos");
		ImageView b1 = (ImageView)this.findViewById(R.id.Entrar);
		ImageView b2 = (ImageView)this.findViewById(R.id.Info);
		ImageView b3 = (ImageView)this.findViewById(R.id.Buscar);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		pagina = 0;
		mandar = new ArrayList<Noticia>();
		fbusqueda = getIntent().getBooleanExtra("busqueda",false);
		lista = (ListView)this.findViewById(R.id.listView1);

		AsincBNL tarea = null;
		tarea = new AsincBNL(
				Singleton.url+":8000/api/busqueda/"+datos+"/"+pagina+"/0",lista, this
				);
		tarea.execute();

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Log.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Bnolog.class);
				startActivity(i);
			}
			
		});
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnologres.this, Nolog.class);
				startActivity(i);
			}
			
		});		
		

		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        try{
			        int k =  (Integer) lista.getAdapter().getItem(pos);
		        	aempezar = k;
		        	auxlist.get(k);
			    	Intent i= new Intent(Bnologres.this,Display_not_nolog.class);
			        int s =  (Integer) lista.getAdapter().getItem(pos);
			        i.putExtra("id",auxlist.get(s));
					i.putExtra("user_id", iduser);
					startActivity(i);	   
		        }catch(Exception E){		        	
		        }				
		    }
		    
		});
		
		 lista.setOnScrollListener(new OnScrollListener(){
			 private int currentFirstVisibleItem;
			private int currentVisibleItemCount;
			private int currentScrollState;

			@Override
			 public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
	           if(completado){
	        	   if ((firstVisibleItem + visibleItemCount) >= totalItemCount) {
	        			   pagina += 1;
	        			   aempezar = firstVisibleItem+1;
	        			   AsincBNL tarea = new AsincBNL(
	        					   (Singleton.url+":8000/api/busqueda/"+datos+"/"+pagina+"/"+iduser).replace(" ","%20"),lista, a
	        					   );
	        			   tarea.execute();	
	        			   completado = false;
	        			
	        		   
	            }
	           }

			}

				public void onScrollStateChanged(AbsListView view, int scrollState) {
				    this.currentScrollState = scrollState;
				    this.isScrollCompleted();
				 }

				private void isScrollCompleted() {
				    if (this.currentVisibleItemCount > 0 && this.currentScrollState == SCROLL_STATE_IDLE) {
				    }
				}
			 
		 });
	}
	
	public class AsincBNL extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		ListView lista;
		JSONObject Noticias;
	    private Bnologres activity;
	    private boolean completed;
	    private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincBNL(
				String urlcomment,ListView lista,Bnologres activity){
			this.contexto = activity;
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
				      Noticias = new JSONObject(jsonText);
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
		public void onPostExecute(Object response){
			try {
				
				if(Noticias.getBoolean("ret")){
					JSONArray lcoment = Noticias.getJSONArray("resultado");
					for(int i = 0; i<lcoment.length();i++){
							JSONObject coment = (JSONObject) lcoment.get(i);
							int autor = coment.getInt("id_noticia");
							String comentario = coment.getString("titular");
							String puntuacion = coment.getString("fecha");
							int nlikes = coment.getInt("liked");
							int comentarios = coment.getInt("ncomentarios");
							//String categoria = coment.getString("categoria");
							String categoria = "";
							String dspueblo = coment.getString("dspueblo");
							boolean vista = coment.getBoolean("vista");
							auxlist.add(autor);
							k = new Noticia(autor,puntuacion,comentario,nlikes,comentarios,categoria,dspueblo,vista);
							mandar.add(k);
					}
					lista.setAdapter(new Plantilla_dispnot(activity,mandar));
					lista.setSelection(aempezar);
				}
				else{
					noeffect = true;
					k = new Noticia(0,"","Esta consulta no tiene más noticias",0,0,"","",false);
					mandar.add(k);
					lista.setAdapter(new Plantilla_dispnotnula(activity,mandar));
					lista.setSelection(aempezar);
					roto = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
					roto = true;
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
		    public void setActivity(Bnologres activity) 
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
	                                                       "Recopilando las noticias", 
	                                                       false);

	    } 

	    
	   //Notify activity of async task completion
	    private void notifyActivityTaskCompleted() 
	    { 
	        if ( null != activity ) { 	 
	        	if(!roto)
	        	completado = true;

	            activity.onTaskCompleted(_response); 
	        } 
	    } 

	//for maintain attached the async task to the activity in phone states changes
	   //Sets the current activity to the async task

		}


	public void onPause(){
		super.onPause();
		if (pleaseWaitDialog != null)
			pleaseWaitDialog.dismiss();
	}

	public void onResume(){
		super. onResume();
		if(bundle != null){
			pagina = bundle.getInt(PAGINA);
			aempezar = bundle.getInt(AEMPEZAR);
			bundle = null;
			mandar.get(aempezar).setVista(true);
			lista.setAdapter(new Plantilla_dispnot(this,mandar));
			lista.setSelection(aempezar);

		}else{

			if((backgroundTask!=null)&&(backgroundTask.getStatus()==Status.RUNNING)){
				if(pleaseWaitDialog != null)
					pleaseWaitDialog.show();
			}
		}
	}
	
	private void onTaskCompleted(Object _response) 
	{ 
	}
}

