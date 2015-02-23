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
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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
import android.widget.ListView;
import android.widget.Toast;

public class Bnologres extends Activity{
	LinkedList<Integer> auxlist = new LinkedList<Integer>();
	private static AsincBNL backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	boolean nonotice = false,completado=false,roto=false;
	ListView lista;
	int start, last;
	Bnologres a = this;
	List<Noticia> mandar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bnologres);
		mandar = new ArrayList<Noticia>();
		final String datos = getIntent().getStringExtra("datos");
		Button b4 = (Button)this.findViewById(R.id.button1);
		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
		lista = (ListView)this.findViewById(R.id.listView1);
		start = 0;
		last = 9;

		AsincBNL tarea = null;
		tarea = new AsincBNL(this,
				Singleton.url+":8000/api/busqueda/"+datos+"/"+start+"/"+last,lista, this
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
				Intent i = new Intent(Bnologres.this, Bnolog.class);
				startActivity(i);
			}
			
		});		
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        try{
			        int k =  (Integer) lista.getAdapter().getItem(pos);
			        auxlist.get(k);
		        }catch(Exception E){
		        	String string = "No existen noticias con estas características" +
		        			"realice una búsqueda con otras especificaciones.";
		        	Toast.makeText(getApplicationContext(), string, Time.SECOND).show();

		        }
		    	Intent i= new Intent(Bnologres.this,Display_not_nolog.class);
		        int k =  (Integer) lista.getAdapter().getItem(pos);
		        i.putExtra("id",auxlist.get(k));
				startActivity(i);

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
	        			   start += 10;
	        			   last +=10;
	        			   AsincBNL tarea = new AsincBNL(a,
	        					   (Singleton.url+":8000/api/busqueda/"+datos+"/"+start+"/"+last).replace(" ","%20"),lista, a
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
	
	private void onTaskCompleted(Object _response) 
	{ 

	}


	


	public class AsincBNL extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		ListView lista;
		JSONObject Noticias;
		Bnologres activity;
	    private boolean completed;
	    private Object _response;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincBNL(Context contexto,
				String urlcomment,ListView lista,Bnologres activity){
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
			Noticia k;
			try {
				JSONArray lcoment = Noticias.getJSONArray("resultado");
				for(int i = 0; i<lcoment.length();i++){
						JSONObject coment = (JSONObject) lcoment.get(i);
						int autor = coment.getInt("id_noticia");
						String comentario = coment.getString("titular");
						String puntuacion = coment.getString("fecha");
						int nlikes = coment.getInt("liked");
						int comentarios =coment.getInt("ncomentarios");
						String dspueblo = coment.getString("dspueblo");
						auxlist.add(autor);
						k = new Noticia(autor,puntuacion,comentario,nlikes,comentarios,"",dspueblo);
						mandar.add(k);
				}
				if(lcoment.length()==0){
					nonotice = true;
					k = new Noticia(0,"","Esa busqueda no tiene más resultados",0,0,"","");
					mandar.add(k);
					lista.setAdapter(new Plantilla_dispnotnula(activity,mandar));
					roto = true;
				}else{
					lista.setAdapter(new Plantilla_dispnot(activity,mandar));
				}

			} catch (JSONException e) {
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

}

