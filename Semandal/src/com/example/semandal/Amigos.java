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

import com.example.semandal.Lnoticias.AsincLN;
import com.example.semandal.aux.Amigo;
import com.example.semandal.aux.Noticia;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
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

public class Amigos extends Activity {
	private String url,busqueda ="";
	private int iduser,indice;
	LinkedList<Integer> auxlist=new LinkedList<Integer>(), auxlistpueblo = new LinkedList<Integer>();
	private static AsincA backgroundTask;
	private static ProgressDialog pleaseWaitDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_amigos);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		Button b5 = (Button)this.findViewById(R.id.button1);

		final ListView lista = (ListView)this.findViewById(R.id.listView1);
		iduser = getIntent().getIntExtra("user_id",0);
		indice = getIntent().getIntExtra("indice",0);
		AsincA tarea = null;
		try{
			busqueda = getIntent().getStringExtra("busqueda");
		}catch(Exception e){
			
		}
		if(busqueda==null){
			url = ":8000/api/usuario/"+iduser+"/amigos/";
		}
		else
			url = ":8000/api/usuario/busqueda/"+busqueda;
		tarea = new AsincA(this,
				Singleton.url+url,lista, this
				);
		tarea.execute();

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Amigos.this, Buser.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Amigos.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Amigos.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Amigos.this, LPueblos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Amigos.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		        Intent i= new Intent(Amigos.this,Perfil.class);
		        int k =  (Integer) lista.getAdapter().getItem(pos);
		        int l = auxlist.get(k);
		        i.putExtra("id",l);
				i.putExtra("indice", indice);
				i.putExtra("user_id", iduser);
				startActivity(i);
				 finish();
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

	public class AsincA extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		ListView lista;
		JSONObject Amigos;
	    private Amigos activity;
	    private boolean completed;
	    private Object _response;

		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincA(Context contexto,
				String urlcomment,ListView lista,Amigos activity){
			this.contexto = contexto;
			this.url = urlcomment;
			this.lista = lista;			
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



			  
			  
			  public void leercomentario() throws IOException, JSONException {
				    InputStream is = new URL(url).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				      Amigos = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		
	


		@Override
		protected Void doInBackground(Void... params) {
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
			List<Amigo> mandar = new ArrayList<Amigo>();
			Amigo k;
			try {
				int namigos = Integer.parseInt(Amigos.getString("namigos"));
				if(namigos==0){
					k=new Amigo("En este momento no tiene amigos","","");
					mandar.add(k);
				}
				JSONArray lcoment = Amigos.getJSONArray("amigos");
				for(int i = 0; i<lcoment.length();i++){
						JSONObject coment = (JSONObject) lcoment.get(i);
						int id_friend = coment.getInt("id_amigo");
						String nombre = coment.getString("nombre");
						String ap1 = coment.getString("ap1");
						String ap2 = coment.getString("ap2");
						String nya = nombre + " " + ap1 + " " + ap2;
						String usuario = coment.getString("amigo");
						String pueblo = coment.getString("pueblo");
						int idpueblo = coment.getInt("idpueblo");
						auxlist.add(id_friend);
						auxlistpueblo.add(idpueblo);
						k = new Amigo(usuario,nya,pueblo);
						mandar.add(k);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.setAdapter(new Plantilla_amigos(activity,mandar));

			
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
	    public void setActivity(Amigos activity) 
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


}
