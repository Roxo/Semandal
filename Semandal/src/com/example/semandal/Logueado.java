package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Log.loguear;
import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Logueado extends Activity {
	int pid=0,notid=0,iduser=0;
	private static Asinlog backgroundTask;
	private static ProgressDialog pleaseWaitDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logueado);
		
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		Button b5 = (Button)this.findViewById(R.id.button1);
		iduser = getIntent().getIntExtra("user_id",0);
		TextView bienvenida=(TextView) this.findViewById(R.id.bienvenida);
		TextView noticia=(TextView) this.findViewById(R.id.noticias);
		TextView pueblo=(TextView) this.findViewById(R.id.pueblo);
		Asinlog tarea = null;
		tarea = new Asinlog(b5,this,bienvenida,noticia,pueblo,
				Singleton.url+":8000/api/logginuser/"+iduser,this
				);
		tarea.execute();
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Display_not_log.class);
				i.putExtra("user_id", iduser);
				i.putExtra("datos", "(id_p:"+pid+")");
				i.putExtra("p_id", pid);
				i.putExtra("id",notid);
				startActivity(i);
			}
			
		});		
	
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("datos", "(id_p:"+pid+")");
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Lnoticias.class);
				i.putExtra("datos", "(id_p:"+pid+")");
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, LPueblos.class);
				i.putExtra("p_id", pid);
				i.putExtra("user_id", iduser);
				i.putExtra("datos", "(id_p:"+pid+")");
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				i.putExtra("datos", "(id_p:"+pid+")");
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

		}

	public class Asinlog extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		TextView bienvenida,noticia,pueblo;
		JSONObject datosuser;
		Button b5;
	    private Logueado activity;
	    private boolean completed;
	     private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asinlog(Button b5, Context contexto,TextView bienvenida,TextView noticia,TextView pueblo,String url,Logueado activity){
			this.b5 = b5;
			this.contexto = contexto;
			this.noticia = noticia;
			this.url = url;
			this.bienvenida = bienvenida;
			this.pueblo = pueblo;
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


			  
			  public void leerdatos() throws IOException, JSONException {
				    InputStream is = new URL(url).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				       datosuser = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leerdatos();
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
				notid=datosuser.getInt("notid");
				pid=datosuser.getInt("pid");
				bienvenida.setText("Bienvenido "+datosuser.getString("dsusuario"));
			    noticia.setText(datosuser.getString("dstitular"));
			    pueblo.setText("Municipio:\t\t"+datosuser.getString("dspueblo"));
			    iduser=datosuser.getInt("id");
			    if(notid==0){
			    	b5.setEnabled(false);
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
		    public void setActivity(Logueado activity) 
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
	                                                       "Verificando credenciales", 
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
