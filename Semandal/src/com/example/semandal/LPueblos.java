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

import com.example.semandal.Deuda.AsinDeuda;
import com.example.semandal.aux.Singleton;

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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class LPueblos extends Activity {
	private int iduser,indice;
	private static AsinLpueblo backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private List<String> lista1,lista2;
	private List<Integer> lista1aux,lista2aux;
	ListView lv;
	AutoCompleteTextView pob;
	LPueblos a = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lpueblos);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		ImageView busqueda = (ImageView)this.findViewById(R.id.button1);
		iduser = getIntent().getIntExtra("user_id",0);
		lv = (ListView)this.findViewById(R.id.listView1);
		indice = getIntent().getIntExtra("indice",0);
		pob = (AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView1);
		AsinLpueblo tarea = new AsinLpueblo(this,Singleton.url+":8000/api/usuario/seguimiento/"+iduser,lv,pob,this);
		tarea.execute();
		
		
		busqueda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				String pueblo = pob.getText().toString();
				int p = 0;
				if(!pueblo.equalsIgnoreCase("")){
					p = buscapuebloid(pueblo);
				}
				int idpueblo = 0;
				if(p != 0){
					idpueblo = lista1aux.get(p);
				}
				if(idpueblo!= 0){
					Intent i = new Intent(LPueblos.this, Deuda.class);
					i.putExtra("user_id", iduser);
					i.putExtra("indice",indice);
					i.putExtra("pb",idpueblo );
					startActivity(i);
				}
				else{
					 String answer = "Necesita elegir al menos un pueblo";
					 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
				}
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

		});		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		/*		Intent i = new Intent(LPueblos.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);*/
				showDialogSalir(a,"Confirmación","Desea desloguearse?");

			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LPueblos.this, Lnoticias.class);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LPueblos.this, LPueblos.class);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(LPueblos.this, Logueado.class);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		
		lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        Intent i= new Intent(LPueblos.this,Deuda.class);
		        int k =  lista2aux.get(pos);
		        i.putExtra("pb",k);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
		                                
		    }
		});


	}
	
	public void showDialogSalir(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(LPueblos.this);
		final AlertDialog builder = b.create();
		b.setTitle(title);
		b.setMessage(message);
		b.setNegativeButton("No", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int id) {
		    	builder.cancel();
		    }
		});
		b.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int id) {
				Intent i = new Intent(LPueblos.this, Nolog.class);
				startActivity(i);
		    }
		});
		b.show();
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
	public class AsinLpueblo extends AsyncTask<Void, Void, Object> {
		Context contexto;
		JSONObject d;
		ListView lv;
		String url;
	    private boolean completed;
		AutoCompleteTextView pob;
	    private LPueblos activity;
	    private Object _response;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsinLpueblo(Context contexto,String url,ListView lv,AutoCompleteTextView t,LPueblos activity){
			this.contexto = contexto;
			this.pob = t;
			this.url=url;
			this.lv = lv;
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
			       d = new JSONObject(jsonText);
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
			lista2= new ArrayList<String>();
			lista2aux= new ArrayList<Integer>();	
	        BDClassSeguimiento admin = new BDClassSeguimiento(contexto,"following", null, 1);
		    SQLiteDatabase db = admin.getReadableDatabase();
			String sql = "SELECT * FROM siguiendo" ;
			Cursor c = db.rawQuery(sql, null);
			int a = c.getCount();
			if (c.moveToFirst()){
				c.moveToNext();
				c.moveToNext();
				do{
					lista2.add(c.getString(1));
					lista2aux.add(c.getInt(0));
				}while(c.moveToNext());
			}
	        BDClass pueblos = new BDClass(contexto,"administracion", null, 1);
	        db = pueblos.getReadableDatabase();
			sql = "SELECT * FROM pueblos" ;
			c = db.rawQuery(sql, null);
			a = c.getCount();
			lista1= new ArrayList<String>();
			lista1aux= new ArrayList<Integer>();
			if (c.moveToFirst()){
				do{
					lista1.add(c.getString(1));
					lista1aux.add(c.getInt(0));
				}while(c.moveToNext());
			}
			db.close();
			ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item, lista1);
			pob.setAdapter(adaptador1);
			ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(contexto,android.R.layout.simple_list_item_1,lista2);
			lv.setAdapter(adaptador2);

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
		
	    public void setActivity(LPueblos activity) 
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
                                                       "Recopilando pueblos", 
                                                       false);

    } 


	    private void notifyActivityTaskCompleted() 
	    { 
	        if ( null != activity ) { 
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	
	}

}
