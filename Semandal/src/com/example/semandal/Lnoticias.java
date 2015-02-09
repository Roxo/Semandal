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

import com.example.semandal.Blog.AsincBlog;
import com.example.semandal.aux.Noticia;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.format.Time;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class Lnoticias extends Activity {
	private static String PRIMERO = "PRIMERO";
	private static String ULTIMO = "ULTIMO";
	private static String FROM = "FROM";
	private static String AEMPEZAR = "AEMPEZAR";

	LinkedList<Integer> auxlist = new LinkedList<Integer>();
	ArrayList<String> lista1= new ArrayList<String>();
	LinkedList<Integer> aux1list = new LinkedList<Integer>();
	String datos,pueblonuevo;
	ListView lista;
	int iduser,pid,indice;
	boolean fbusqueda=false,noeffect=false,completado = false,roto = false,first = true,from = false;
	private static AsincLN backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	TextView resultados;
	int start, last,aempezar=0;
	Lnoticias a = this;
	List<Noticia> mandar;
	Bundle bundle;

	public void onSaveInstanceState(Bundle savedInstanceState) {
		bundle = savedInstanceState;
	    // Save the user's current game state
	    bundle.putInt(ULTIMO, last);
	    bundle.putInt(PRIMERO, start);
	    bundle.putBoolean(FROM, roto);
	    bundle.putInt(AEMPEZAR, aempezar);

	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lnoticias);
		ImageView b1 = (ImageView)this.findViewById(R.id.Amigos);
		ImageView b2 = (ImageView)this.findViewById(R.id.Noticias);
		ImageView b3 = (ImageView)this.findViewById(R.id.deuda);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		ImageView b5 = (ImageView)this.findViewById(R.id.busc);
		pid = getIntent().getIntExtra("p_id",0);
		iduser = getIntent().getIntExtra("user_id",0);
		datos = getIntent().getStringExtra("datos");
		pueblonuevo = getIntent().getStringExtra("pueblito");
		if(pueblonuevo==null)
			pueblonuevo = "";
		start = 0;
		last = 9;
		mandar = new ArrayList<Noticia>();
		ImageView fl = (ImageView)this.findViewById(R.id.fl);
		ImageView fr = (ImageView)this.findViewById(R.id.fr);
		resultados = (TextView)this.findViewById(R.id.resultados);
		indice = getIntent().getIntExtra("indice",0);
		fbusqueda = getIntent().getBooleanExtra("busqueda",false);
		lista = (ListView)this.findViewById(R.id.listView1);

		AsincLN tarea = new AsincLN(resultados,
				(Singleton.url+":8000/api/busqueda/"+datos+"/"+start+"/"+last+"/"+iduser).replace(" ","%20"),lista, this
				);
		tarea.execute();

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(indice == lista1.size()-2)
					indice = -1;
				else
					indice += 1;
				Intent i = new Intent(Lnoticias.this, Lnoticias.class);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});	
		
		fl.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(indice == -1)
					indice = lista1.size()-2;
				else
					indice -= 1;
				Intent i = new Intent(Lnoticias.this, Lnoticias.class);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
			}
			
		});			
		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				/*Intent i = new Intent(Lnoticias.this, Amigos.class);
				i.putExtra("user_id", iduser);
				startActivity(i);*/
				showDialogSalir(a,"Confirmación","Desea desloguearse?");
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Lnoticias.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Lnoticias.this, LPueblos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Lnoticias.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});
		
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Lnoticias.this, Blog.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		    	try{
			        int k =  (Integer) lista.getAdapter().getItem(pos);
		        	aempezar = k;
		        	auxlist.get(k);			
		        	Intent i= new Intent(Lnoticias.this,Display_not_log.class);
		        	int s =  (Integer) lista.getAdapter().getItem(pos);
		        	i.putExtra("id",auxlist.get(s));
		        	i.putExtra("user_id", iduser);
		        	startActivity(i);	   
		        }catch(Exception E){		        	
		        }
		    }
		    
		});
		
		 lista.setOnScrollListener(new OnScrollListener(){
			 private int currentFirstVisibleItem;
			private int currentVisibleItemCount;
			private int currentScrollState;

			@Override
			 public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
	           if(completado){
	        	   if ((firstVisibleItem + visibleItemCount) >= totalItemCount) {
	        			   start += 10;
	        			   last +=10;
	        			   aempezar = firstVisibleItem+1;
	        			   AsincLN tarea = new AsincLN(resultados,
	        					   (Singleton.url+":8000/api/busqueda/"+datos+"/"+start+"/"+last+"/"+iduser).replace(" ","%20"),lista, a
	        					   );
	        			   tarea.execute();	
	        			   completado = false;
	        			
	        		   
	            }
	           }

			}

				public void onScrollStateChanged(AbsListView view, int scrollState) {
				    this.currentScrollState = scrollState;
				    this.isScrollCompleted();
				 }

				private void isScrollCompleted() {
				    if (this.currentVisibleItemCount > 0 && this.currentScrollState == SCROLL_STATE_IDLE) {
				    }
				}
			 
		 });
	}
	
	public void showDialogSalir(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Lnoticias.this);
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
				Intent i = new Intent(Lnoticias.this, Nolog.class);
				startActivity(i);
		    }
		});
		b.show();
	}	

	public class AsincLN extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		ListView lista;
		JSONObject Noticias;
		TextView resultados;
	    private Lnoticias activity;
	    private boolean completed;
	    private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincLN(TextView resultados,
				String urlcomment,ListView lista,Lnoticias activity){
			this.contexto = activity;
			this.url = urlcomment;
			this.lista = lista;			
			this.activity = activity;
			this.resultados = resultados;
		}
		
		  private String readAll(Reader rd) throws IOException {
			    StringBuilder sb = new StringBuilder();
			    int cp;
			    while ((cp = rd.read()) != -1) {
			      sb.append((char) cp);
			    }
			    return sb.toString();
			  }



			  
			  
			  public void leercomentario() throws IOException, JSONException {
				    InputStream is = new URL(url).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				      Noticias = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		
	


		@Override
		protected Void doInBackground(Void... params) {
			try {
			BDClassSeguimiento admin = new BDClassSeguimiento(contexto,"following", null, 1);
		    SQLiteDatabase db = admin.getReadableDatabase();
			String sql = "SELECT * FROM siguiendo " ;
			Cursor c = db.rawQuery(sql, null);
			int a = c.getCount();
			lista1= new ArrayList<String>();
			if (c.moveToFirst()){
				do{
					lista1.add(c.getString(1));
					aux1list.add(c.getInt(0));
				}while(c.moveToNext());
			}
			db.close();
			if(indice == -1 && !fbusqueda)
				url = Singleton.url+":8000/api/noticias/"+start+"/"+last+"/"+iduser;
			else if(indice == 0 && !fbusqueda)
				url = Singleton.url+":8000/api/"+iduser+"/noticias/"+start+"/"+last;
			else if(!fbusqueda)
				url = Singleton.url+":8000/api/busqueda/"+"(id_p:"+aux1list.get(indice+1)+")/"+start+"/"+last+"/"+iduser;
				leercomentario();
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
			if(indice == -1 && !fbusqueda)
				resultados.setText("Todas las noticias");
			else if(indice == 0 && !fbusqueda)
				resultados.setText("Noticias de Mis Pueblos");
			else if(!fbusqueda)
				resultados.setText(lista1.get(indice+1));
			else if(!pueblonuevo.equalsIgnoreCase(""))
				resultados.setText(pueblonuevo);
			else
				resultados.setText("Noticias");
			Noticia k;
			try {
				
				if(Noticias.getBoolean("ret")){
					JSONArray lcoment = Noticias.getJSONArray("resultado");
					for(int i = 0; i<lcoment.length();i++){
							JSONObject coment = (JSONObject) lcoment.get(i);
							int autor = coment.getInt("id_noticia");
							String comentario = coment.getString("titular");
							String puntuacion = coment.getString("fecha");
							int nlikes = coment.getInt("liked");
							int comentarios = coment.getInt("ncomentarios");
							//String categoria = coment.getString("categoria");
							String categoria = "";
							String dspueblo = coment.getString("dspueblo");
							boolean vista = coment.getBoolean("vista");
							auxlist.add(autor);
							k = new Noticia(autor,puntuacion,comentario,nlikes,comentarios,categoria,dspueblo,vista);
							mandar.add(k);
					}
					lista.setAdapter(new Plantilla_dispnot(activity,mandar));
					lista.setSelection(aempezar);
				}
				else{
					noeffect = true;
					k = new Noticia(0,"","Esta consulta no tiene más noticias",0,0,"","",false);
					mandar.add(k);
					lista.setAdapter(new Plantilla_dispnot(activity,mandar));
					aempezar = start;			
					lista.setSelection(aempezar);
					roto = true;
				}
			} catch (Exception e) {
				roto = true;
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
		    public void setActivity(Lnoticias activity) 
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
	                                                       "Recopilando las noticias", 
	                                                       false);

	    } 

	    
	   //Notify activity of async task completion
	    private void notifyActivityTaskCompleted() 
	    { 
	        if ( null != activity ) { 	 
	        	if(!roto)
	        	completado = true;

	            activity.onTaskCompleted(_response); 
	        } 
	    } 

	//for maintain attached the async task to the activity in phone states changes
	   //Sets the current activity to the async task

		}


	public void onPause(){
		super.onPause();
		if (pleaseWaitDialog != null)
			pleaseWaitDialog.dismiss();
	}

	public void onResume(){
		super. onResume();
		if(bundle != null){
			last = bundle.getInt(ULTIMO);
			start = bundle.getInt(PRIMERO);
			aempezar = bundle.getInt(AEMPEZAR);
			roto = bundle.getBoolean(FROM);
			bundle = null;
			mandar.get(aempezar).setVista(true);
			lista.setAdapter(new Plantilla_dispnot(this,mandar));
			lista.setSelection(aempezar);

		}else{

			if((backgroundTask!=null)&&(backgroundTask.getStatus()==Status.RUNNING)){
				if(pleaseWaitDialog != null)
					pleaseWaitDialog.show();
			}
		}
	}
	
	private void onTaskCompleted(Object _response) 
	{ 
	}

	
}
