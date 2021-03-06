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

import com.example.semandal.Nolog.AsincronNolog;
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
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Bnolog extends Activity implements OnItemSelectedListener {
	private static AsincBnolog backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private Spinner spinner1, spinner2;
	private int pposicion,cposicion;
	private EditText Titular, fecha;
	private List<String> lista1, lista1aux,lista2;
	private LinkedList<LinkedList<String>> auxiliar = new LinkedList<LinkedList<String>>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
	   setContentView(R.layout.activity_bnolog);
		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
		Button resultado = (Button)this.findViewById(R.id.button1);
		Titular = (EditText)this.findViewById(R.id.Tit_nolog);
		fecha = (EditText)this.findViewById(R.id.Fecha_nolog);
		AsincBnolog tarea = null;
		tarea = new AsincBnolog(this,
				Singleton.url+":8000/api/pueblos",
				Singleton.url+":8000/api/noticias/categorias/",this
				);
		tarea.execute();

		resultado.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String titular = "", Fecha = "", idpueblo ="", idcat="";
				titular = Titular.getText().toString();
				Fecha = fecha.getText().toString();
				if(pposicion != 0){
					idpueblo = lista1aux.get(pposicion);
				}
				if(cposicion != 0){
					for (int i = 0; i<auxiliar.get(cposicion).size();i++){
						idcat=idcat.concat(auxiliar.get(cposicion).get(i));
						if(i!=auxiliar.get(cposicion).size()-1){
							idcat=idcat.concat("-");
						}
					}
				}
				String stringfinal ="";
				if(!titular.equals(""))
					stringfinal = stringfinal+"_t:"+titular+",";
				if(!Fecha.equals(""))
					stringfinal = stringfinal+"_d:"+Fecha+",";
				if(!idpueblo.equals(""))
					stringfinal = stringfinal+"id_p:"+idpueblo+",";
				if(!idcat.equals(""))
					stringfinal = stringfinal+"id_c:"+idcat+",";
				stringfinal = stringfinal.substring(0,stringfinal.length()-1);
				stringfinal = "("+stringfinal+")";
				Intent i = new Intent(Bnolog.this, Bnologres.class);
				i.putExtra("datos",stringfinal);
				startActivity(i);
			}
		});
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnolog.this, Log.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnolog.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Bnolog.this, Bnolog.class);
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
		   spinner1 = (Spinner) findViewById(R.id.Pob);
		   ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1);
		   adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner1.setAdapter(adaptador1);

		   spinner2 = (Spinner) findViewById(R.id.cat);
		   ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista2);
		   adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner2.setAdapter(adaptador2);
		   spinner1.setOnItemSelectedListener(this);
		   spinner2.setOnItemSelectedListener(this);

	}




		/*private void DatosPorDefecto2() throws IOException, JSONException {
			   spinner1 = (Spinner) findViewById(R.id.Pob);
			   lista = new ArrayList<String>();
			   spinner1 = (Spinner) this.findViewById(R.id.Pob);
			   JSONObject leer = new JSONObject(LectorJSON.fetchJSON("http://127.0.0.1:8000/api/pueblos/"));
			   int npueblos = leer.getInt("npueblos");
			   JSONArray pueblos = leer.getJSONArray("pueblos");
			   for(int i = 0; i<npueblos; i++){
				   JSONObject p = (JSONObject)pueblos.get(i);
				   lista.add(p.getString("nombre"));
	   			}
  			   ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
			   adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			   spinner1.setAdapter(adaptador);
			}*/
	public class AsincBnolog extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String urlpueblos,urlcategorias;
		JSONObject pueblos, categorias;
	    private Bnolog activity;
	    private boolean completed;
	     private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincBnolog(Context contexto,String urlpueblos, String urlcategorias,Bnolog activity){
			this.contexto = contexto;
			this.urlpueblos=urlpueblos;
			this.urlcategorias=urlcategorias;
            this.activity = activity;

		}
		
		@Override
		protected Void doInBackground(Void... params) {
			try {
		        BDClass admin = new BDClass(contexto,"administracion", null, 1);
			    SQLiteDatabase db = admin.getReadableDatabase();
				String sql = "SELECT * FROM pueblos" ;
				Cursor c = db.rawQuery(sql, null);
				int a = c.getCount();
				lista1= new ArrayList<String>();
				lista1aux= new ArrayList<String>();
		    	lista1.add("Pueblos");
		    	lista1aux.add("");
				if (c.moveToFirst()){
					do{
						lista1.add(c.getString(1));
						lista1aux.add(c.getString(0));
					}while(c.moveToNext());
				}
				sql = "SELECT * FROM categorias" ;
				c = db.rawQuery(sql, null);
				a = c.getCount();
				lista2= new ArrayList<String>();
				lista2.add("Categorias");
			   	LinkedList<String> aux = new LinkedList<String>();
			   	aux = new LinkedList<String>();
				if (c.moveToFirst()){
					do{
						if(busca(lista2,c.getString(1))){
							aux.add(c.getString(0));
						}
						else{
							auxiliar.add(aux);
							aux = new LinkedList<String>();
							lista2.add(c.getString(1));
							aux.add(c.getString(0));
						}
					}while(c.moveToNext());
				}
			    db.close();
			    c.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}



		@Override
		public void onPostExecute(Object response){
            completed = true;
            _response = response;
            notifyActivityTaskCompleted();
        if (pleaseWaitDialog != null)
        {
            pleaseWaitDialog.dismiss();
            pleaseWaitDialog = null;
        }

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

		public void setActivity(Bnolog activity) 
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
        if(parent == this.findViewById(R.id.cat))
        	cposicion=pos;
        
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }

}
