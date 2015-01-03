package com.example.semandal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import com.example.semandal.Comentarios.AsincCL;
import com.example.semandal.Comentarios.Setc;

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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Categoriza extends Activity implements OnItemSelectedListener{
	String datos,notid,pid,iduser,cact,cactid="";
	private static Asinccategoriza backgroundTask;
	private static Setc backgroundTask1;
	boolean enviar = false;
	private Spinner spinner2;
	private int cposicion;
	private static ProgressDialog pleaseWaitDialog;
	private List<String> lista2;
	private LinkedList<LinkedList<String>> auxiliar = new LinkedList<LinkedList<String>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categoriza);
		
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		notid=getIntent().getStringExtra("id");
		pid = getIntent().getStringExtra("p_id");
		iduser = getIntent().getStringExtra("user_id");
		datos = getIntent().getStringExtra("datos");
		cact = getIntent().getStringExtra("cat");
		Asinccategoriza tarea = new Asinccategoriza(this,(TextView) findViewById(R.id.categoria),(TextView) findViewById(R.id.categorizador),this);
		tarea.execute();

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Categoriza.this, Amigos.class);
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
				Intent i = new Intent(Categoriza.this, Lnoticias.class);
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
				Intent i = new Intent(Categoriza.this, Deuda.class);
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
				Intent i = new Intent(Categoriza.this, Logueado.class);
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
		if((backgroundTask1!=null)&&(backgroundTask1.getStatus()==Status.RUNNING)){
			if(pleaseWaitDialog != null)
				pleaseWaitDialog.show();
		}

	}



	private void onTaskCompleted(Object _response){
		if(enviar){
			Intent i = new Intent(Categoriza.this, Display_not_log.class);
			i.putExtra("id", notid);
			i.putExtra("datos", datos);
			i.putExtra("user_id", iduser);
			i.putExtra("p_id", pid);
			startActivity(i);	
		}
		else{
			   spinner2 = (Spinner) findViewById(R.id.spinner1);
			   ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista2);
			   adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			   spinner2.setAdapter(adaptador2);
			   spinner2.setOnItemSelectedListener(this);

		}
	}


    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
		String selected = parent.getItemAtPosition(pos).toString();
        if(parent == this.findViewById(R.id.spinner1))
        	cposicion=pos;
        
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }

    
	public class Asinccategoriza extends AsyncTask<Void, Void, Object> {
		Context contexto;
	    private Categoriza activity;
	    TextView cactual,categorizador;
	    private boolean completed;
	     private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asinccategoriza(Context contexto,TextView cactual, TextView categorizador,Categoriza activity){
			this.contexto = contexto;
            this.activity = activity;
            this.cactual = cactual;
            this.categorizador = categorizador;
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
						if(!c.getString(1).equalsIgnoreCase(cact)&&!c.getString(0).equalsIgnoreCase("331")){
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
						else if(c.getString(1).equalsIgnoreCase(cact)){
							cactid = c.getString(0);
						}
					}while(c.moveToNext());
				}

			    db.close();
			    c.close();
			    cactual.setText(cact);
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

		public void setActivity(Categoriza activity) 
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


	}



}
