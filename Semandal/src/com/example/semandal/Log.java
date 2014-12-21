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

import com.example.semandal.Bnolog.AsincBnolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Log extends Activity {
	private static loguear backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private Log log=this;
	private List<String> lista1, lista1aux;
	boolean logueado = false;
	String uid = "",message="",mn="";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_log);
		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
		Button loguear = (Button)this.findViewById(R.id.entrar);
		Button registrarse = (Button)this.findViewById(R.id.registro);
		TextView notificacion = (TextView)this.findViewById(R.id.notificacion);
		final EditText user = (EditText)this.findViewById(R.id.idnombre);
		final EditText pass = (EditText)this.findViewById(R.id.password);
		try{
			message =getIntent().getStringExtra("mn");
		}catch(Exception e){
			
		}
		if (message != null){
			notificacion.setText(message);
		}
		registrarse.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Log.this, Registro.class);
				startActivity(i);
			}
			
		});	
		
		loguear.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				loguear tarea;
				String usuario = user.getText().toString();
				String psw = pass.getText().toString();
				tarea = new  loguear(log,
						Singleton.url+":8000/api/log/"+usuario+"/"+psw, log
						);
				tarea.execute();			
			}
			
		});		
		
		b1.setOnClickListener(new View.OnClickListener() {
			
		
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Log.this, LoginActivity.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Log.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Log.this, Bnolog.class);
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
				if(logueado){
					Intent i = new Intent(Log.this, Logueado.class);
					i.putExtra("user_id", uid);
					startActivity(i);
				}
				else{
					Intent i = new Intent(Log.this, Log.class);
					i.putExtra("mn", mn);
					startActivity(i);
				}
		}

	public class loguear extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String urllog;
		JSONObject loginfo;
	    private Log activity;
	    private boolean completed;
	     private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public loguear(Context contexto,String urllog,Log activity){
			this.contexto = contexto;
			this.urllog=urllog;
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

			  public void leeruser() throws IOException, JSONException {
			    InputStream is = new URL(urllog).openStream();
			    try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			      String jsonText = readAll(rd);
			       loginfo = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
			  }
			  
		@Override
		protected Void doInBackground(Void... params) {

				try {
					leeruser();
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
				mn = loginfo.getString("Message");
				logueado = loginfo.getBoolean("Resultado");
				if(logueado){
					uid = loginfo.getString("userid");
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
	    public void setActivity(Log activity) 
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
