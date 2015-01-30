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

import com.example.semandal.aux.AlmacenUsuario;
import com.example.semandal.aux.Comentario;
import com.example.semandal.aux.Inicio;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.format.Time;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Nolog extends Activity {
	String answer = "";
	boolean noact = false;
	private static AsincronNolog backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	LinkedList<Integer> not = new LinkedList<Integer>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_nolog);
		AlmacenUsuario j = new AlmacenUsuario(this);
		j.GuardaridUsuario(0);
		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
	//	Button b4 = (Button)this.findViewById(R.id.auxiliar);
		final ListView lvTest = (ListView) findViewById(R.id.listView1);
		AsincronNolog tarea = null;
		tarea = new AsincronNolog(this,lvTest,
				Singleton.url+":8000/api/noticias/ultima/",this
			);
		tarea.execute();
		
		ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if (null != activeNetwork) {
			if(activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
				answer="You are connected to a WiFi Network";
			if(activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
				answer="You are connected to a Mobile Network";
		}
		 else{
			 answer = "Se necesita conexión a internet";
			 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
		 }

		
		
		lvTest.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        if (!noact) {
		    	Intent i= new Intent(Nolog.this,Display_not_nolog.class);
		        i.putExtra("id",not.get(pos));
				startActivity(i);
				noact = true;

				}
		        else{
		        	String string = "No existen noticias, no puede clicar";
		        	Toast.makeText(getApplicationContext(), string, Time.SECOND).show();
		        }
		    }
		});


		
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Log.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Nolog.this, Bnolog.class);
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
}	List<Integer> lista = new LinkedList<Integer>();


private void onTaskCompleted(Object _response) 
{ 

}
	public class AsincronNolog extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		JSONObject html;
		ListView lvTest;
	    private Nolog activity;
	    private boolean completed;
	    private Object _response;
	   // private TwoWayView lvTest;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincronNolog(Context contexto,ListView lvTest,
				String url,Nolog activity){
			this.contexto = contexto;
			this.url = url;
			this.activity = activity;
			this.lvTest = lvTest;
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
			  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					if (!answer.equals("Se necesita conexión a internet")){
					leernoticia();
					}
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
			List<Inicio> mandar = new ArrayList<Inicio>();
				if(html != null){
				try{
					if(html.getBoolean("existe")){
						JSONArray noticias = html.getJSONArray("noticias");
						for(int i = 0; i<noticias.length(); i++){
							LinkedList<String> fechas = new LinkedList<String>();
							LinkedList<String> autores = new LinkedList<String>();
							LinkedList<String> coments = new LinkedList<String>();
							JSONObject k = noticias.getJSONObject(i);
							String titular = k.getString("titular").replace("-","\n");
							if(titular.equalsIgnoreCase("")){
								titular = "Esta noticia no tiene titular";
							}
							String fecha = k.getString("fecha");
							int idnoticia = k.getInt("id_noticia");
							not.add(idnoticia);
							String pob = k.getString("dspueblo");
							JSONArray comentarios = k.getJSONArray("comentarios");
							for(int j = 0; j<comentarios.length(); j++ ){
								JSONObject aC = comentarios.getJSONObject(j);
								fechas.add(aC.getString("fecha"));
								coments.add(aC.getString("cuerpo"));
								autores.add(aC.getString("autor"));
							}
							if(comentarios.length()==1){
								fechas.add("");
								coments.add("");
								autores.add("");
							}
							else if(comentarios.length()==0){
								fechas.add("");
								coments.add("Esta noticia no tiene comentarios");
								autores.add("");
								fechas.add("");
								coments.add("");
								autores.add("");
							}
							Inicio nuevo = new Inicio(idnoticia,fecha,titular,pob,autores.get(0),fechas.get(0),coments.get(0),autores.get(1),fechas.get(1),coments.get(1));
							mandar.add(nuevo);
						}
					
					}
				   
				  //  lvTest.setAdapter(new Plantilla_Comment(activity,mandar));


				} catch (JSONException e) {
					
				}
			}
			if(html==null){	
					noact = true;
					String titular = "No existen noticias";
					Inicio nuevo = new Inicio(0,"",titular,"","","","","","","");
					mandar.add(nuevo);
				}
			
			lvTest.setAdapter(new Plantilla_inicio(activity,mandar));


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
		    public void setActivity(Nolog activity) 
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
	            activity.onTaskCompleted(_response); 
	        } 
	    } 

	//for maintain attached the async task to the activity in phone states changes
	   //Sets the current activity to the async task

		}

}

	


