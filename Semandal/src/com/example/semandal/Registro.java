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
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Registro extends Activity  implements OnItemSelectedListener{
	private static AsincReg backgroundTask;
	private static Set backgroundTask1;
	static ProgressDialog pleaseWaitDialog;
	private Spinner spinner1;
	private int pposicion;
	Registro k=this;
	boolean loadp = false;
	private EditText usuario, pass, correo, conpass,name,ap1,ap2;
	private List<String> lista1;
	List<Integer> lista1aux;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
				Button b1 = (Button)this.findViewById(R.id.loggin);
				Button b2 = (Button)this.findViewById(R.id.info);
				Button b3 = (Button)this.findViewById(R.id.busqueda);
				Button b4 = (Button)this.findViewById(R.id.button1);
				usuario = (EditText)this.findViewById(R.id.Usuario);
				pass = (EditText)this.findViewById(R.id.pass);
				conpass = (EditText)this.findViewById(R.id.conpass);
				correo = (EditText)this.findViewById(R.id.Correo);
				name = (EditText)this.findViewById(R.id.name);
				ap1= (EditText)this.findViewById(R.id.ap1);
				ap2 = (EditText)this.findViewById(R.id.ap2);
				final AutoCompleteTextView autotext = (AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView1);
				AsincReg tarea = null;
				tarea = new AsincReg(this,
						Singleton.url+":8000/api/pueblos",this,autotext
						);
				tarea.execute();

				
				b4.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						String u= usuario.getText().toString();
						String p= pass.getText().toString();
						String pob =  autotext.getText().toString();
						String prueba = Singleton.url+":8000/api/register/"+u+"/"+name.getText().toString()+"/"+ap1.getText().toString()+"/"+ap2.getText().toString()+"/"+p+"/"+correo.getText().toString()+"/"+pob;
						Set cm = new Set(prueba,k);
						cm.execute();
						Intent i = new Intent(Registro.this, Log.class);
						startActivity(i);
					}
					
				});		

				b1.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(Registro.this, LoginActivity.class);
						startActivity(i);
					}
					
				});		
				b2.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(Registro.this, Informacion.class);
						startActivity(i);
					}
					
				});
				b3.setOnClickListener(new View.OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Intent i = new Intent(Registro.this, Bnolog.class);
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

	void onTaskCompleted(Object _response) 
	{ 
		if(loadp){
		   spinner1 = (Spinner) findViewById(R.id.Pob);
		   spinner1 = (Spinner) this.findViewById(R.id.Pob);
		   ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1);
		   adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner1.setAdapter(adaptador1);
		   spinner1.setOnItemSelectedListener(this);
		   loadp = false;
		}
	}



	public class AsincReg extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String urlpueblos;
		JSONObject pueblos, categorias;
	    private Registro activity;
	    private boolean completed;
	     private Object _response;
	     AutoCompleteTextView pob;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincReg(Context contexto,String urlpueblos,Registro activity,AutoCompleteTextView pob){
			this.contexto = contexto;
			this.urlpueblos=urlpueblos;
            this.activity = activity;
            this.pob = pob;

		}
		
		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
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
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item, lista1);
	       pob.setAdapter(adaptador1);

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
	    public void setActivity(Registro activity) 
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

    
   //Notify activity of async task completion
    private void notifyActivityTaskCompleted() 
    { 
        if ( null != activity ) { 
        	loadp = true;
            activity.onTaskCompleted(_response); 
        } 
    } 

//for maintain attached the async task to the activity in phone states changes
   //Sets the current activity to the async task

	}




    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		String selected = parent.getItemAtPosition(pos).toString();
        if(parent == this.findViewById(R.id.Pob))
        	pposicion=pos;
        
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
	public class Set extends AsyncTask<Void, Void, Object> {
		String url;
	    private Registro activity;
	    private boolean completed;
	    private Object _response;

		public Set(String url,Registro activity){
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
	            if (pleaseWaitDialog == null)
	                pleaseWaitDialog= ProgressDialog.show(activity, 
	                                                       "Espere un segundo", 
	                                                       "Registrando usuario", 
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
	    public void setActivity(Registro activity) 
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
