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

import com.example.semandal.aux.Comentario;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class Comentarios extends Activity {
	int notid,iduser,indice;
	private static AsincCL backgroundTask;
	boolean enviar = false,votado=false;
	private static ProgressDialog pleaseWaitDialog;
	private Comentarios a = this;
	private LinkedList<Integer> listacomment = new LinkedList<Integer>();
	private ListView lista;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_comentarios);

		lista =(ListView)this.findViewById(R.id.listacomentarios);
		ImageView b1 = (ImageView)this.findViewById(R.id.Amigos);
		ImageView b2 = (ImageView)this.findViewById(R.id.Noticias);
		ImageView b3 = (ImageView)this.findViewById(R.id.deuda);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		notid=getIntent().getIntExtra("id",0);
		ImageView b6 = (ImageView)this.findViewById(R.id.enviar);
		final EditText comentario = (EditText)this.findViewById(R.id.DwEdit);
		iduser = getIntent().getIntExtra("user_id",0);
		indice = getIntent().getIntExtra("indice",0);
		final Comentarios k = this;
		AsincCL tarea = null;
		tarea = new AsincCL(this,
				Singleton.url+":8000/api/noticias/"+notid+"/comentarios",lista,this
				,"");
		tarea.execute();

		
		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// En este m�todo tenemos que realizar la actualizaci�n del 
				// comentario y posteriormente realizar una consulta en json
				// para pasarle los datos actualizados
				String coment= comentario.getText().toString();
				String prueba = Singleton.url+":8000/api/C_insert/"+notid+"/"+iduser+"/"+coment.replace("\n","-").replace(" ", "%20");
				AsincCL tarea = null;
				tarea = new AsincCL(a,
						Singleton.url+":8000/api/noticias/"+notid+"/comentarios",lista,a
						,prueba);
				tarea.execute();
				

			}
		
		});		
		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			/*	Intent i = new Intent(Comentarios.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			*/
				showDialogSalir(a,"Confirmación","Desea desloguearse?");
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Comentarios.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Comentarios.this, LPueblos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Comentarios.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);

				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		    	try{
		    		listacomment.get(pos);
		    		showDialog(a,"Confimarcion","¿Deseea denunciar el comentario? Si es el autor, el comentario se borrará",listacomment.get(pos));
		    	}catch(Exception e){
		    	}
		    	
			}
		});

	}
	
	
	public void showDialogSalir(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Comentarios.this);
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
				Intent i = new Intent(Comentarios.this, Nolog.class);
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



	private void onTaskCompleted(Object _response){
	}
	

	
	public class AsincCL extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url,urlcat;
		ListView lista;
		JSONObject Comentarios;
		Comentarios activity;
	    private boolean completed;
	    private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincCL(Context contexto,
				String urlcomment,ListView lista,Comentarios activity,String urlcat){
			this.contexto = contexto;
			this.url = urlcomment;
			this.lista = lista;			
			this.activity = activity;
			this.urlcat = urlcat;
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
				       Comentarios = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		
	
				private void actualizar() throws MalformedURLException, IOException {
				    InputStream is = new URL(urlcat).openStream();
				    is.close();
				}


		@Override
		protected Void doInBackground(Void... params) {
			try {
				if(!urlcat.equalsIgnoreCase(""))
					actualizar();
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
			List<Comentario> mandar = new ArrayList<Comentario>();
			Comentario k;
			try {
				int ncomentarios = Integer.parseInt(Comentarios.getString("ncomentarios"));
				if (ncomentarios != 0){
				JSONArray lcoment = Comentarios.getJSONArray("comentarios");
				for(int i = 0; i<lcoment.length();i++){
						JSONObject coment = (JSONObject) lcoment.get(i);
						listacomment.add(coment.getInt("id_comentario"));
						String autor = coment.getString("usuario");
						String comentario = coment.getString("comentario").replace("-", " ");
						String fecha = coment.getString("fecha");
						k = new Comentario(autor,comentario,fecha);
						mandar.add(k);
				}
				}else{
					String autor = "";
					String comentario = "No existen comentarios para esta noticia. Se el primero!";
					String fecha = "";
					k = new Comentario(autor,comentario,fecha);
					mandar.add(k);

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.setAdapter(new Plantilla_Comment(activity,mandar));

			
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
		    public void setActivity(Comentarios activity) 
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
	                                                       "Cargando comentarios", 
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
		AlertDialog.Builder b = new AlertDialog.Builder(Comentarios.this);
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
				AsincCL tarea = null;
				tarea = new AsincCL(a,
						Singleton.url+":8000/api/noticias/"+notid+"/comentarios",lista,a
						,Singleton.url+":8000/api/denunciar/"+iduser+"/"+c);
				tarea.execute();
		    }
		});
		b.show();
	}

}
