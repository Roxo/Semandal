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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Seman extends Activity implements OnItemSelectedListener {
	private int idnot,indice,iduser;
	Asincseman backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	private Spinner spinner1;
	private int cposicion;
	private Seman t = this;
	private List<String> lista2;
	boolean fromcat = false, fromsend = false;
	private LinkedList<Integer> auxiliar=new LinkedList<Integer>(),categorias;
	ListView lista ;
	boolean votado = false,from=false;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seman);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		Button b5 = (Button)this.findViewById(R.id.corregir);
		idnot = getIntent().getIntExtra("id",0);
		iduser = getIntent().getIntExtra("user_id",0);
		indice = getIntent().getIntExtra("indice",0);
		lista = (ListView) this.findViewById(R.id.listView1);
		final EditText categoriacreada = (EditText)this.findViewById(R.id.editText1);
		Asincseman tarea = new Asincseman(this,Singleton.url+":8000/api/noticias/"+idnot+"/categorias",lista);
		tarea.execute();

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(cposicion != 0 && !categoriacreada.getText().toString().equalsIgnoreCase("")){
					 String answer = "Puede seleccionar o crear una categoría no a la vez";
					 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
				}
				else if(cposicion != 0){
					int cnew=auxiliar.get(cposicion);
					String url = Singleton.url+":8000/api/categoriza/"+idnot+"/"+cnew+"/"+iduser;
					Mandar tarea = new Mandar(url,t);
					tarea.execute();
				}
				else if(!categoriacreada.getText().toString().equalsIgnoreCase("")){
					String cnew = categoriacreada.getText().toString();
					cnew = cnew.replace(" ","_");
					String url = Singleton.url+":8000/api/noticias/"+idnot+"/addcat/"+cnew+"/";
					Mandar tarea = new Mandar(url,t);
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
				Intent i = new Intent(Seman.this, Nolog.class);
				startActivity(i);
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
		    	showDialog(t,"Confimarcion","¿Confirma que la categoría es erronea?",categorias.get(pos));
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
			Asincseman tarea = new Asincseman(t,Singleton.url+":8000/api/noticias/"+idnot+"/categorias",lista);
			tarea.execute();
			fromsend=false;
		}
		if(from){
			String answer =  votado ?   "Su votación se ha realizado" :  "Usted ya ha votado esta categoria para esta noticia";
			Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
			votado = false;
			from = false;
		}
	}

	
	public class Asincseman extends AsyncTask<Void, Void, Object> {
		Context contexto;
		private String url;
		JSONObject html;
	    private Seman activity;
	    private boolean completed;
	    private Object _response;
		private ListView lv;
		private String[] listacategorias;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asincseman(Seman activity,String url,ListView lv){
			this.contexto = activity;
            this.activity = activity;
            this.url = url;
            this.lv = lv;

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


		@Override
		protected Void doInBackground(Void... params) {
				try {
					categorias = new LinkedList<Integer>();
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
						 String answer = "Ha ocurrido un problema en la lectura de categorias";
						 Toast.makeText(contexto.getApplicationContext(), answer, Toast.LENGTH_LONG).show();

					}						
			        BDClass admin = new BDClass(contexto,"administracion", null, 1);
				    SQLiteDatabase db = admin.getReadableDatabase();
					String sql = "SELECT * FROM categorias" ;
					Cursor c = db.rawQuery(sql, null);
					int a = c.getCount();
					lista2= new ArrayList<String>();
					lista2.add("Categorias");
					auxiliar.add(0);
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
	                                                       "Agregando categoria", 
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
	
	
	
	
	public class wrong_cat extends AsyncTask<Void, Void, Object> {
		String url;
	    private Seman activity;
	    private boolean completed;
	    private Object _response;
	    private JSONObject html;

		public wrong_cat(String url,Seman t){
			this.url=url;
			this.activity = t;
		}
		@Override
		protected Void doInBackground(Void... params) {
			try {
				try {
					actualizar();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }

			  public void actualizar() throws IOException, JSONException {
			    InputStream is = new URL(url).openStream();
			    try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			      String jsonText = readAll(rd);
			       html = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
			  }
		
	    @Override 
	    protected void onPreExecute() {
	            //Start the splash screen dialog
	                pleaseWaitDialog= ProgressDialog.show(activity, 
	                                                       "Espere un segundo", 
	                                                       "Enviando corrección", 
	                                                       false);

	    } 

	    public void onPostExecute(Object response){
	    	try {
				votado = html.getBoolean("agregado");
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
	    public void setActivity(Seman activity) 
	    { 
	        this.activity = activity; 
	        if ( completed ) { 
	            from = true;
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
		    	wrong_cat k = new wrong_cat(Singleton.url+":8000/api/votacion/"+idnot+"/"+iduser+"/"+c+"/",t);
		    	k.execute();
		    }
		});
		b.show();
	}	
	


}
