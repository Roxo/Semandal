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

import android.annotation.SuppressLint;
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
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Blog extends Activity implements OnItemSelectedListener {
	private static AsincBlog backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private Spinner spinner2;
	private int indice,cposicion,iduser;
	private EditText Titular;
	private Blog a = this;
	private List<String> lista1,lista2;
	private List<Integer> lista1aux;
	private LinkedList<Integer> auxiliar = new LinkedList<Integer>();
	String año = "",mes="",dia="";
	AutoCompleteTextView autotext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_blog);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		Button b5 = (Button)this.findViewById(R.id.blog);
		iduser = getIntent().getIntExtra("user_id",0);
		indice = getIntent().getIntExtra("indice",0);
		Titular = (EditText)this.findViewById(R.id.Tit_nolog);
		autotext = (AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView1);
		AsincBlog tarea = new AsincBlog(this,autotext);
		tarea.execute();
		
		b5.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View v) {
				
				boolean cancel = false;
				EditText fi = (EditText)a.findViewById(R.id.fdesde);
				EditText ff = (EditText)a.findViewById(R.id.fhasta);
				View focusView = null;
				
				if (!confirm(fi.getText().toString())) {
					fi.setError(getString(R.string.error_date_format));
					focusView = fi;
					cancel = true;
				}
				if (!confirm(ff.getText().toString())) {
					ff.setError(getString(R.string.error_date_format));
					focusView = ff;
					cancel = true;
				}

				if (cancel) {
					// There was an error; don't attempt login and focus the first
					// form field with an error.
					focusView.requestFocus();
				} else {
					pasarbusqueda(fi.getText().toString(),ff.getText().toString());
				}
			}

			private boolean confirm(String string) {
				if(string.equalsIgnoreCase(""))
					return true;
				try{
					String[] a = string.split("-");
					if(a.length == 3){
						if(a[0].length() <= 2){
							if(a[1].length() <=2){
								if(a[2].length() == 4)
									return true;
								else
									return false;
							}else
								return false;
						}
						else
							return false;
					}else
						return false;
				}catch(Exception e){
					return false;
				}
			}
		});		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		/*		Intent i = new Intent(Blog.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);*/
				Intent i = new Intent(Blog.this, Nolog.class);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Blog.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Blog.this, LPueblos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Blog.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
	}
	
	private void pasarbusqueda(String finit,String ffin){
		String titular = "";
		Integer idcat=0;
		Integer idpueblo =0;
		try{
		finit = convertdate(finit);
		}
		catch(Exception e){}
		try{
		ffin = convertdate(ffin);
		}
		catch(Exception e){}
		titular = Titular.getText().toString();
		String pueblo = autotext.getText().toString();
		int p = 0;
		if(!pueblo.equalsIgnoreCase("")){
			p = buscapuebloid(pueblo);
		}
		if(p != 0){
			idpueblo = lista1aux.get(p);
		}
		if(cposicion != 0){
			idcat = auxiliar.get(cposicion);
		}
		String stringfinal ="";
		if(!titular.equals(""))
			stringfinal = stringfinal+"_t:"+titular+",";
		
		if (!finit.equals(""))
			if(ffin.equals(""))
				ffin = finit;
		
		if(!ffin.equals(""))
			if (finit.equals(""))
				finit = ffin;
		
		if(!finit.equals("")&&!ffin.equals("")){
			stringfinal = stringfinal+"_d:"+finit+":"+ffin+",";
		}

		if(idpueblo != 0)
			stringfinal = stringfinal+"id_p:"+idpueblo+",";
		if(idcat != 0)
			stringfinal = stringfinal+"id_c:"+idcat+",";
		if(stringfinal.equals("")){
			 String answer = "Necesita seleccionar al menos un campo";
			 Toast.makeText(this.getApplicationContext(), answer, Toast.LENGTH_LONG).show();
		}
		else{
			stringfinal = stringfinal.substring(0,stringfinal.length()-1);
			stringfinal = "("+stringfinal+")";
			Intent i = new Intent(Blog.this, Lnoticias.class);
			i.putExtra("datos",stringfinal);
			i.putExtra("busqueda",true);
			i.putExtra("user_id", iduser);
			i.putExtra("indice", indice);
			startActivity(i);
		}
	}
	private String convertdate(String ffin) {
		String[] fecha = ffin.split("-");
		return (fecha[2]+"-"+fecha[1]+"-"+fecha[0]);
	}

	private int buscapuebloid(String pueblo) {
		boolean encontrado = false;
		int i = 0;
		while(!encontrado && i<lista1.size()){
			if(lista1.get(i).equalsIgnoreCase(pueblo)){
				encontrado = true;
				return i;
			}
			i++;
		}
		return 0;				
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
		   spinner2 = (Spinner) findViewById(R.id.cat);
		   ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista2);
		   adaptador2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner2.setAdapter(adaptador2);
		   spinner2.setOnItemSelectedListener(this);

	}

	public class AsincBlog extends AsyncTask<Void, Void, Object> {
		Context contexto;
		JSONObject pueblos, categorias;
	    private Blog activity;
	    private boolean completed;
	    private Object _response;
		AutoCompleteTextView pob;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincBlog(Blog activity,AutoCompleteTextView pob){
			this.contexto = activity;
            this.activity = activity;
            this.pob = pob;
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
					lista1aux= new ArrayList<Integer>();
					if (c.moveToFirst()){
						do{
							lista1.add(c.getString(1));
							lista1aux.add(c.getInt(0));
						}while(c.moveToNext());
					}
					sql = "SELECT * FROM categorias" ;
					c = db.rawQuery(sql, null);
					a = c.getCount();
					lista2= new ArrayList<String>();
					lista2.add("Categorias");
					auxiliar.add(0);
					if (c.moveToFirst()){
						do{
							lista2.add(c.getString(1));
							auxiliar.add(c.getInt(0));
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
	    public void setActivity(Blog activity) 
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
        if(parent == this.findViewById(R.id.cat))
        	cposicion=pos;
    }

    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }

}
