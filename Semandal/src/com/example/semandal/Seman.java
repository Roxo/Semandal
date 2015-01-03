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

import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Blog.AsincBlog;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Seman extends Activity implements OnItemSelectedListener {
	private String idnot,datos,pid,iduser,cat,catactid;
	private static Asincseman backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private Spinner spinner1;
	private int cposicion;
	private Seman t = this;
	private List<String> lista2;
	boolean fromcat = false, fromsend = false;
	private LinkedList<LinkedList<String>> auxiliar = new LinkedList<LinkedList<String>>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seman);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		Button b5 = (Button)this.findViewById(R.id.corregir);
		idnot = getIntent().getStringExtra("id");
		pid = getIntent().getStringExtra("p_id");
		iduser = getIntent().getStringExtra("user_id");
		datos = getIntent().getStringExtra("datos");
		cat = getIntent().getStringExtra("cat");
		TextView categoria = (TextView) this.findViewById(R.id.categoria);
		Asincseman tarea = new Asincseman(this,categoria);
		tarea.execute();

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(cposicion != 0){
					String cnew=auxiliar.get(cposicion).get(0);
					String url = Singleton.url+":8000/api/categoriza/"+idnot+"/"+catactid+"/"+cnew+"/"+iduser;
					Mandar tarea = new Mandar(url,t);
					tarea.execute();
				}
				else{
					 String answer = "Debe seleccionar al menos una categoría";
					 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();

				}
			}
			
		});		

		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Seman.this, Amigos.class);
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
				Intent i = new Intent(Seman.this, Lnoticias.class);
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
				Intent i = new Intent(Seman.this, Deuda.class);
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
				Intent i = new Intent(Seman.this, Logueado.class);
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

		if(fromcat){
		   spinner1 = (Spinner) findViewById(R.id.cat);
		   ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista2);
		   adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner1.setAdapter(adaptador2);
		   spinner1.setOnItemSelectedListener(this);
		   fromcat = false;
		}
		if(fromsend){
			Intent i = new Intent(Seman.this, Display_not_log.class);
			i.putExtra("datos", datos);
			i.putExtra("user_id", iduser);
			i.putExtra("p_id", pid);
			i.putExtra("id",idnot);
			startActivity(i);

		}
	}

	
	public class Asincseman extends AsyncTask<Void, Void, Object> {
		Context contexto;
		JSONObject pueblos, categorias;
	    private Seman activity;
	    private boolean completed;
	    private Object _response;
		private TextView categoria;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asincseman(Seman activity,TextView categoria){
			this.contexto = activity;
            this.activity = activity;
            this.categoria = categoria;

		}
		
  

		@Override
		protected Void doInBackground(Void... params) {
				try {
			        BDClass admin = new BDClass(contexto,"administracion", null, 1);
				    SQLiteDatabase db = admin.getReadableDatabase();
					String sql = "SELECT * FROM categorias" ;
					Cursor c = db.rawQuery(sql, null);
					int a = c.getCount();
					lista2= new ArrayList<String>();
					lista2.add("Categorias");
				   	LinkedList<String> aux = new LinkedList<String>();
				   	aux = new LinkedList<String>();
					if (c.moveToFirst()){
						do{
							if(!c.getString(1).equalsIgnoreCase(cat)&&!c.getString(0).equalsIgnoreCase("331")){
								if(busca(lista2,c.getString(1))){
									aux.add(c.getString(0));
								}
								else{
									auxiliar.add(aux);
									aux = new LinkedList<String>();
									lista2.add(c.getString(1));
									aux.add(c.getString(0));
								}
							}
							else if(c.getString(1).equalsIgnoreCase(cat)){
								catactid = c.getString(0);
							}
						}while(c.moveToNext());
					}
				    db.close();
				    c.close();
				    categoria.setText("Categoría actual: "+cat);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}


    private boolean busca(List<String> lista2, String string) {
    	boolean devolver = false;
    	int i = 0;
    	while (!devolver && i<lista2.size()){
    		if(lista2.get(i).equalsIgnoreCase(string)){
    			devolver = true;
    		}
    		else i++;
    	}
    	return devolver;
    }


		@Override
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
	    public void setActivity(Seman activity) 
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
                                                       "Recopilando categorías", 
                                                       false);

    } 

    
   //Notify activity of async task completion
    private void notifyActivityTaskCompleted() 
    { 
        if ( null != activity ) { 
        	fromcat = true;
            activity.onTaskCompleted(_response); 
        } 
    } 

//for maintain attached the async task to the activity in phone states changes
   //Sets the current activity to the async task

	}

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		String selected = parent.getItemAtPosition(pos).toString();
        if(parent == this.findViewById(R.id.cat))
        	cposicion=pos;
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }

	public class Mandar extends AsyncTask<Void, Void, Object> {
		String url;
	    private Seman activity;
	    private boolean completed;
	    private Object _response;

		public Mandar(String url,Seman activity){
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
	                                                       "Mandando corrección", 
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
	    public void setActivity(Seman activity) 
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
	            fromsend = true;
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	}

}
