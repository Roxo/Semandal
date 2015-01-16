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
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class Lnoticias extends Activity {
	LinkedList<Integer> auxlist = new LinkedList<Integer>();
	ArrayList<String> lista1= new ArrayList<String>();
	LinkedList<Integer> aux1list = new LinkedList<Integer>();
	String datos,pueblonuevo;
	
	int iduser,pid,indice;
	boolean fbusqueda=false;
	private static AsincLN backgroundTask;
	private static ProgressDialog pleaseWaitDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lnoticias);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		Button b5 = (Button)this.findViewById(R.id.busc);
		pid = getIntent().getIntExtra("p_id",0);
		iduser = getIntent().getIntExtra("user_id",0);
		datos = getIntent().getStringExtra("datos");
		pueblonuevo = getIntent().getStringExtra("pueblito");
		if(pueblonuevo==null)
			pueblonuevo = "";
		TextView fl = (TextView)this.findViewById(R.id.fl);
		TextView fr = (TextView)this.findViewById(R.id.fr);
		TextView resultados = (TextView)this.findViewById(R.id.resultados);
		try{
			indice = getIntent().getIntExtra("indice",0);
			fbusqueda = getIntent().getBooleanExtra("busqueda",false);
		}catch(Exception e){
			
		}
		
		final ListView lista = (ListView)this.findViewById(R.id.listView1);
		AsincLN tarea = null;
		tarea = new AsincLN(this,resultados,
				Singleton.url+":8000/api/busqueda/"+datos,lista, this
				);
		tarea.execute();

		fr.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(indice == lista1.size()-1)
					indice = 0;
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
				if(indice == 0)
					indice = lista1.size()-1;
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
				Intent i = new Intent(Lnoticias.this, Amigos.class);
				i.putExtra("user_id", iduser);
				startActivity(i);
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
				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        Intent i= new Intent(Lnoticias.this,Display_not_log.class);
		        int k =  (Integer) lista.getAdapter().getItem(pos);
		        i.putExtra("id",auxlist.get(k));
				i.putExtra("user_id", iduser);
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
		
		public AsincLN(Context contexto,TextView resultados,
				String urlcomment,ListView lista,Lnoticias activity){
			this.contexto = contexto;
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
			if(indice == 0 && !fbusqueda)
				url = Singleton.url+":8000/api/"+iduser+"/noticias";
			else if(!fbusqueda)
				url = Singleton.url+":8000/api/busqueda/"+"(id_p:"+aux1list.get(indice)+")";
			
			try {
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
			if(indice == 0 && !fbusqueda)
				resultados.setText("Noticias de Mis Pueblos");
			else if(!fbusqueda)
				resultados.setText(lista1.get(indice));
			if(!pueblonuevo.equalsIgnoreCase(""))
				resultados.setText(pueblonuevo);

			List<Noticia> mandar = new ArrayList<Noticia>();
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
							String categoria = coment.getString("categoria");
							String dspueblo = coment.getString("dspueblo");
							auxlist.add(autor);
							k = new Noticia(autor,puntuacion,comentario,nlikes,comentarios,categoria,dspueblo);
							mandar.add(k);
					}
				}
				else{
					k = new Noticia(0,"","Su pueblo no dispone de noticias",0,0,"","");
					mandar.add(k);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.setAdapter(new Plantilla_dispnot(activity,mandar));

			
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
	            activity.onTaskCompleted(_response); 
	        } 
	    } 

	//for maintain attached the async task to the activity in phone states changes
	   //Sets the current activity to the async task

		}



	
}
