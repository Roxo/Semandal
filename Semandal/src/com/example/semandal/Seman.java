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

import com.example.semandal.Blog.AsincBlog;
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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Seman extends Activity {
	private int idnot,indice,iduser;
	Asincseman backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private Seman a = this;
	private List<String> lista2;
	boolean fromsend = false;
	private LinkedList<Integer> auxiliar=new LinkedList<Integer>(),categorias;
	ListView lista ;
	boolean votado = false,from=false;
	private AutoCompleteTextView categoria;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seman);
		ImageView b1 = (ImageView)this.findViewById(R.id.Amigos);
		ImageView b2 = (ImageView)this.findViewById(R.id.Noticias);
		ImageView b3 = (ImageView)this.findViewById(R.id.deuda);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		ImageView b5 = (ImageView)this.findViewById(R.id.corregir);
		idnot = getIntent().getIntExtra("id",0);
		iduser = getIntent().getIntExtra("user_id",0);
		indice = getIntent().getIntExtra("indice",0);
		lista = (ListView) this.findViewById(R.id.listView1);
		categoria = (AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView1);
		Asincseman tarea = new Asincseman(this,Singleton.url+":8000/api/noticias/"+idnot+"/categorias",lista,categoria,"");
		tarea.execute();

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!categoria.getText().toString().equalsIgnoreCase("")){
					String cnew = categoria.getText().toString();
					String url = (Singleton.url+":8000/api/noticias/"+idnot+"/addcat/"+iduser+"/"+cnew).replace(" ","%20");
					Asincseman tarea = new Asincseman(a,Singleton.url+":8000/api/noticias/"+idnot+"/categorias",lista,categoria,url);
					tarea.execute();
				}
				else{
					 String answer = "Debe seleccionar o crear una categoría";
					 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();

				}
			}
			
		});		

		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		/*		Intent i = new Intent(Seman.this, Amigos.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}*/
				showDialogSalir(a,"Confirmación","Desea desloguearse?");
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Seman.this, Lnoticias.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Seman.this, LPueblos.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Seman.this, Logueado.class);
				i.putExtra("indice",indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});

		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		    	showDialog(a,"Confimarcion","¿Confirma que la categoría es erronea?",categorias.get(pos));
		    }
		});
	}

	
	public void showDialogSalir(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Seman.this);
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
				Intent i = new Intent(Seman.this, Nolog.class);
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

		if(fromsend||from){
			fromsend=false;
			from =false;
			Asincseman tarea = new Asincseman(a,Singleton.url+":8000/api/noticias/"+idnot+"/categorias",lista,(AutoCompleteTextView)this.findViewById(R.id.autoCompleteTextView1),"");
			tarea.execute();
		}
	}

	
	public class Asincseman extends AsyncTask<Void, Void, Object> {
		Context contexto;
		private String url, urlcorregir;
		JSONObject html,corregir;
	    private Seman activity;
	    private boolean completed;
	    private Object _response;
		private ListView lv;
		private String[] listacategorias;
		private AutoCompleteTextView cat;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asincseman(Seman activity,String url,ListView lv,AutoCompleteTextView cat,String urlcorregir){
			this.contexto = activity;
            this.activity = activity;
            this.url = url;
            this.lv = lv;
            this.cat = cat;
            this.urlcorregir = urlcorregir;

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
			  
			  public void corr() throws IOException, JSONException {
				    InputStream is = new URL(urlcorregir).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				      corregir  = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }

		@Override
		protected Void doInBackground(Void... params) {
				try {
					categorias = new LinkedList<Integer>();
					if(!urlcorregir.equalsIgnoreCase("")){
						corr();
						votado = corregir.getBoolean("agregado");
					}
					leernoticia();
					JSONArray f = html.getJSONArray("categorias");
					listacategorias=new String[f.length()];
					if (f.length() != 0){
						for(int i = 0;i<f.length();i++){
							JSONObject b = f.getJSONObject(i);
							categorias.add(b.getInt("id_categoria"));
							listacategorias[i]= b.getString("dscategoria");
						}
					}
					else{
						 String ans = "Ha ocurrido un problema en la lectura de categorias";
						 Toast.makeText(contexto.getApplicationContext(), ans, Toast.LENGTH_LONG).show();

					}						
			        BDClass admin = new BDClass(contexto,"administracion", null, 1);
				    SQLiteDatabase db = admin.getReadableDatabase();
					String sql = "SELECT * FROM categorias" ;
					Cursor c = db.rawQuery(sql, null);
					int a = c.getCount();
					lista2= new ArrayList<String>();
					if (c.moveToFirst()){
						do{
							if(!busca(categorias,c.getInt(0))){
								lista2.add(c.getString(1));
								auxiliar.add(c.getInt(0));
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


    private boolean busca(List<Integer> lista2, int entero) {
    	boolean devolver = false;
    	int i = 0;
    	while (!devolver && i<lista2.size()){
    		if(lista2.get(i) == entero){
    			devolver = true;
    		}
    		else i++;
    	}
    	return devolver;
    }


		@Override
		public void onPostExecute(Object response){
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto,
					android.R.layout.simple_list_item_1, listacategorias);
			lv.setAdapter(adapter);
			
			ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(contexto, android.R.layout.simple_spinner_item, lista2);
			cat.setAdapter(adaptador1);
			if(!urlcorregir.equalsIgnoreCase("")){
				String answer =  votado ?   "Se ha agregado la categoría" :  "Usted ya ha agregado esta categoria para esta noticia";
				Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
				votado = false;
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
            activity.onTaskCompleted(_response); 
        } 
    } 

//for maintain attached the async task to the activity in phone states changes
   //Sets the current activity to the async task

	}


	
	


	public void showDialog(Activity activity, String title, CharSequence message,final int c) {
		AlertDialog.Builder b = new AlertDialog.Builder(Seman.this);
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
				Asincseman tarea = new Asincseman(a,Singleton.url+":8000/api/noticias/"+idnot+"/categorias",lista,categoria,(Singleton.url+":8000/api/votacion/"+idnot+"/"+iduser+"/"+c+"/").replace(" ","%20"));
				tarea.execute();
		    }
		});
		b.show();
	}	
	


}
