package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Log.loguear;
import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.AlmacenUsuario;
import com.example.semandal.aux.Noticia;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Logueado extends Activity {
	LinkedList<Integer> auxlist = new LinkedList<Integer>();
	int pid=0,notid=0,iduser=0;
	private static Asinlog backgroundTask;
	private int click = 0;
	private static ProgressDialog pleaseWaitDialog;
	private String nombreuser = "";
	List<Noticia> mandar = new LinkedList<Noticia>();
	Logueado a = this;
	AlmacenUsuario j;
	Bundle bundle;
	 ListView noticia;
	public void onSaveInstanceState(Bundle savedInstanceState) {
		bundle = savedInstanceState;
	    // Save the user's current game state
	    bundle.putInt("CLICK", click);

	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logueado);
		ImageView b1 = (ImageView)this.findViewById(R.id.Amigos);
		ImageView b2 = (ImageView)this.findViewById(R.id.Noticias);
		ImageView b3 = (ImageView)this.findViewById(R.id.deuda);
		ImageView b5 = (ImageView)this.findViewById(R.id.button1);
		ImageView b6 = (ImageView)this.findViewById(R.id.imageView2);
		iduser = getIntent().getIntExtra("user_id",0);
		j = new AlmacenUsuario(this);
		TextView bienvenida=(TextView) this.findViewById(R.id.bienvenida);
		noticia=(ListView) this.findViewById(R.id.noticias);
		TextView pueblo=(TextView) this.findViewById(R.id.pueblo);
		ImageView mispueblos=(ImageView) this.findViewById(R.id.button2);
		Asinlog tarea = null;
		final int indice = getIntent().getIntExtra("indice", -1);
		tarea = new Asinlog(this,bienvenida,noticia,pueblo,
				Singleton.url+":8000/api/logginuser/"+iduser,this
				);
		tarea.execute();
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		
		
		mispueblos.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(Logueado.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("datos","(id_p:"+pid+")");
				i.putExtra("busqueda",true);
				i.putExtra("indice",indice);
				startActivity(i);
			}

		});		

		
		noticia.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
		    	try{
			        int k =  (Integer) noticia.getAdapter().getItem(pos);
			        click = k;
		        	auxlist.get(k);			
		        	Intent i= new Intent(Logueado.this,Display_not_log.class);
		        	int s =  (Integer) noticia.getAdapter().getItem(pos);
		        	i.putExtra("id",auxlist.get(s));
		        	i.putExtra("user_id", iduser);
		        	startActivity(i);	   
		        }catch(Exception E){		        	
		        }
		    }
		    
		});
	
		noticia.setOnTouchListener(new OnTouchListener() {
		    // Setting on Touch Listener for handling the touch inside ScrollView
		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
		    // Disallow the touch request for parent scroll on touch of child view
		    v.getParent().requestDisallowInterceptTouchEvent(true);
		    return false;
		    }

		});

	
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Blog.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});		
		
		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Perfil.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
		/*		Intent i = new Intent(Logueado.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);*/
				showDialogSalir(a,"Confirmación","Desea desloguearse?");

			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, LPueblos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Logueado.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice",indice);
				startActivity(i);
			}
			
		});
	

	}
	
	public void showDialogSalir(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Logueado.this);
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
				Intent i = new Intent(Logueado.this, Nolog.class);
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
		if(bundle != null){
			
			click = bundle.getInt("CLICK");
			bundle = null;
			mandar.get(click).setVista(true);
			noticia.setAdapter(new Plantilla_dispnot(this,mandar));
		}
		else{	
			if((backgroundTask!=null)&&(backgroundTask.getStatus()==Status.RUNNING)){
				if(pleaseWaitDialog != null)
					pleaseWaitDialog.show();
			}
		}
	}


		void onTaskCompleted(Object _response) 
		{ 
			((ScrollView)a.findViewById(R.id.scroll)).smoothScrollTo(0,0);
			int f = Integer.parseInt(j.GetUsuario().split("-")[1]);
			if(iduser != f){
				j.GuardaridUsuario(iduser);
				j.GuardarStringUsuario(nombreuser);
			}
		}

	public class Asinlog extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		ListView noticia;
		TextView bienvenida,pueblo;
		JSONObject datosuser;
	    private Logueado activity;
	    private boolean completed;
	     private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public Asinlog(Context contexto,TextView bienvenida,ListView noticia,TextView pueblo,String url,Logueado activity){
			this.contexto = contexto;
			this.noticia = noticia;
			this.url = url;
			this.bienvenida = bienvenida;
			this.pueblo = pueblo;
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
				       datosuser = new JSONObject(jsonText);
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
			try {
		        BDClassSeguimiento admin = new BDClassSeguimiento(contexto,"following", null, 1);
		        SQLiteDatabase bd = admin.getWritableDatabase();
		        try{
		        	admin.onCreate(bd);
		        }catch(Exception e){}
				bd.execSQL("DELETE FROM siguiendo");
		        bd.execSQL("INSERT INTO siguiendo VALUES ("+(-1)+", '"+"Todos"+"')");
		        bd.execSQL("INSERT INTO siguiendo VALUES ("+0+", '"+"Sigo"+"')");
				try {
					JSONArray psig = datosuser.getJSONArray("siguiendo");
					for (int i = 0;i<psig.length(); i++){
						JSONObject f = psig.getJSONObject(i);
						bd.execSQL("INSERT INTO siguiendo VALUES ("+f.getInt("id_pueblo")+", '"+f.getString("dspueblo")+"')");
					}
				bd.close();
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				JSONArray lcoment = datosuser.getJSONArray("noticias");
				for(int i = 0; i<lcoment.length();i++){
						JSONObject coment = (JSONObject) lcoment.get(i);
						int autor = coment.getInt("id_noticia");
						String comentario = coment.getString("titular");
						String puntuacion = coment.getString("fecha");
						int nlikes = coment.getInt("liked");
						int comentarios = coment.getInt("ncomentarios");
						String categoria = "";
						String dspueblo = coment.getString("dspueblo");
						boolean vista = coment.getBoolean("vista");
						auxlist.add(autor);
						Noticia k = new Noticia(autor,puntuacion,comentario,nlikes,comentarios,categoria,dspueblo,vista);
						mandar.add(k);
				}
				if(lcoment.length()==0){
					Noticia k = new Noticia(0,"","No tenemos noticias de su municipio principal",0,0,"","",false);
					mandar.add(k);
				}
				noticia.setAdapter(new Plantilla_dispnot(activity,mandar));

				pid=datosuser.getInt("pid");
				nombreuser = datosuser.getString("dsusuario");
				bienvenida.setText(datosuser.getString("dsusuario"));
			    pueblo.setText(datosuser.getString("dspueblo"));
			    iduser=datosuser.getInt("id");
			} catch (Exception e) {
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
		    public void setActivity(Logueado activity) 
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
	                pleaseWaitDialog= ProgressDialog.show(activity, "Espere un momento",
	                                                       "Recopilando las 5 primeras noticias de su municipio principal", 
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
