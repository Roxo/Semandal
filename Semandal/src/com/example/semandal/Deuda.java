package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
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
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;

public class Deuda extends Activity implements OnItemSelectedListener{
	String datos,iduser,pid,puebloant,puebloact;
	private Spinner spinner1;
	private static AsincBnolog backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private List<String> lista1,lista1aux;
	private int posicion;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_deuda);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		Button b5 = (Button)this.findViewById(R.id.button1);
		TextView deuda = (TextView)this.findViewById(R.id.textodeuda);
		TextView municipio = (TextView)this.findViewById(R.id.textomunicipio);
		pid = getIntent().getStringExtra("p_id");
		iduser = getIntent().getStringExtra("user_id");
		datos = getIntent().getStringExtra("datos");
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		AsinDeuda tarea = null;
		puebloant= pid;
		try{
			puebloact = getIntent().getStringExtra("pb");
			if(puebloact != null){
				puebloant = puebloact;
			}
		}catch(Exception e){
			
		}

		tarea = new AsinDeuda(this,deuda,municipio,
				Singleton.url+":8000/api/pueblos",
				Singleton.url+":8000/api/deuda/"+puebloant,this
				);
		tarea.execute();

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Deuda.this, Deuda.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("pb",lista1aux.get(posicion));
				i.putExtra("p_id", pid);
				startActivity(i);
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
	}
	
	private void onTaskCompleted(Object _response) 
	{ 
		   spinner1 = (Spinner) findViewById(R.id.cat);
		   spinner1 = (Spinner) this.findViewById(R.id.cat);
		   ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1);
		   adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner1.setAdapter(adaptador1);
		   spinner1.setOnItemSelectedListener(this);

	}
	
	public class AsinDeuda extends AsyncTask<Void, Void, Object> {
		Context contexto;
		TextView deuda,municipio;
		String urlpueblos,url;
		JSONObject pueblos,d;
	    private boolean completed;
	    private Deuda activity;
	    private Object _response;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsinDeuda(Context contexto,TextView deuda,TextView municipio,String urlpueblos,
				String url,Deuda activity){
			this.contexto = contexto;
			this.deuda = deuda;
			this.municipio = municipio;
			this.urlpueblos = urlpueblos;
			this.url = url;
			this.activity=activity;
			
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
			deuda.setText("deuda obtenida a día 1/1/2014 \n\n\n\t"+d.getString("deuda"));
			municipio.setText("Municipio: "+d.getString("dspueblo"));
			int npueblos = pueblos.getInt("npueblos");
			lista1= new ArrayList<String>();
			lista1aux= new ArrayList<String>();
			lista1.add("Pueblos");
			lista1aux.add("");
			JSONArray p = pueblos.getJSONArray("pueblos");

			for(int i = 0;i<npueblos;i++){
				JSONObject f = (JSONObject)p.get(i);
			   	lista1.add(f.getString("nombre"));
			   	lista1aux.add(f.getString("idpueblo"));
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

}
