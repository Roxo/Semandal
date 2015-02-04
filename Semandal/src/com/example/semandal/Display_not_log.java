package com.example.semandal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.semandal.Comentarios.AsincCL;
import com.example.semandal.Deuda.Asinadd;
import com.example.semandal.Seman.wrong_cat;
import com.example.semandal.aux.Singleton;

import android.annotation.TargetApi;
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
import android.os.Build;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Display_not_log extends Activity {
	int notid,pid;
	String datos,url1;
	int iduser,indice;
	private static AsincronDNN backgroundTask;
	private static Set backgroundTask1;
	private static ProgressDialog pleaseWaitDialog;
	private boolean set=false;
	private Display_not_log a = this;
	Button b7;
	ListView lista ;
	boolean sigue= false,aseguir = false;
	LinkedList<Integer> idcats;
	Bundle bundle;

	public void onSaveInstanceState(Bundle savedInstanceState) {
		bundle = savedInstanceState;
	    // Save the user's current game state
	    // Always call the superclass so it can save the view hierarchy state
	    super.onSaveInstanceState(savedInstanceState);
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_not_log);
		//yourTextView.setMovementMethod(new ScrollingMovementMethod())
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		Button b5 = (Button)this.findViewById(R.id.comment);
		Button b6 = (Button)this.findViewById(R.id.button1);
		b7 = (Button)this.findViewById(R.id.button2);
		ImageView categoriza = (ImageView)this.findViewById(R.id.b1);
		lista = (ListView) this.findViewById(R.id.listView1);
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		notid=getIntent().getIntExtra("id",0);
		indice = getIntent().getIntExtra("indice",0);
		iduser = getIntent().getIntExtra("user_id",0);
		datos = getIntent().getStringExtra("datos");
		ImageView mas = (ImageView) findViewById(R.id.mas);
		AsincronDNN tarea = null;
		TextView pueblo = (TextView) findViewById(R.id.textView3);
		tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
				(TextView) findViewById(R.id.Noticia),
				(TextView) findViewById(R.id.fecha),b7,Singleton.url+":8000/api/usuario/addnoticia/"+iduser+"/"+notid,
				Singleton.url+":8000/api/noticias/"+notid,Singleton.url+":8000/api/nliked/"+iduser+"/"+notid,this
				,(ListView) findViewById(R.id.listView1),(Button)findViewById(R.id.comment),
				pueblo,mas);
		tarea.execute();
		
		mas.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(sigue){
					showDialogSigue(a, "No puede agregar este pueblo", "Usted ya sigue este pueblo");
				}
				else{
					showDialogNSigue(a,"Confirmación","¿Está seguro que quiere seguir este pueblo?");
				}
			}
			
		});				

		
		pueblo.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Deuda.class);
				i.putExtra("pb", pid);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});				

		categoriza.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Seman.class);
				i.putExtra("id", notid);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});				

		b7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Set tarea = null;
				tarea = new Set(Singleton.url+":8000/api/addliked/"+iduser+"/"+notid,a);
				tarea.execute();
			}
			
		});				

		
		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
				startActivity(browserIntent);
			}
			
		});				

		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Comentarios.class);
				i.putExtra("id", notid);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});				
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
	/*			Intent i = new Intent(Display_not_log.this, Amigos.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);*/
				Intent i = new Intent(Display_not_log.this, Nolog.class);
				startActivity(i);

			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Lnoticias.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, LPueblos.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_log.this, Logueado.class);
				i.putExtra("user_id", iduser);
				i.putExtra("indice", indice);
				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
				Intent i = new Intent(Display_not_log.this, Lnoticias.class);
				String stringfinal = "id_c:"+idcats.get(pos);
				stringfinal = "("+stringfinal+")";
				i.putExtra("datos", stringfinal);
				i.putExtra("busqueda", true);
				i.putExtra("noticia", datos);
				i.putExtra("indice", indice);
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
		if(bundle != null){
			bundle = null;
			AsincronDNN tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
					(TextView) findViewById(R.id.Noticia),
					(TextView) findViewById(R.id.fecha),b7,
					Singleton.url+":8000/api/noticias/"+notid,Singleton.url+":8000/api/nliked/"+iduser+"/"+notid,this
					,(ListView) findViewById(R.id.listView1),(Button) findViewById(R.id.comment),(TextView) findViewById(R.id.textView3),(ImageView) findViewById(R.id.mas));
			tarea.execute();

		}
		else{
			if((backgroundTask!=null)&&(backgroundTask.getStatus()==Status.RUNNING)){
				if(pleaseWaitDialog != null)
					pleaseWaitDialog.show();
			}
			if((backgroundTask1!=null)&&(backgroundTask1.getStatus()==Status.RUNNING)){
				if(pleaseWaitDialog != null)
					pleaseWaitDialog.show();
			
		}
		}

	}


	public void showDialogSigue(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Display_not_log.this);
		final AlertDialog builder = b.create();
		b.setTitle(title);
		b.setMessage(message);
		b.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int id) {
		    	builder.cancel();
		    }
		});
		b.show();
	}	

	public void showDialogNSigue(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Display_not_log.this);
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
		    	sigue = true;
				Asinadd tarea = new Asinadd(
						Singleton.url+":8000/api/addsigue/"+iduser+"/"+pid,a
						);
					tarea.execute();
		    }
		});
		b.show();
	}	

	private void onTaskCompleted(Object _response){
		if(set){
			set=false;
			startActivity(getIntent());
			AsincronDNN tarea = null;
			tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
					(TextView) findViewById(R.id.Noticia),
					(TextView) findViewById(R.id.fecha),b7,
					Singleton.url+":8000/api/noticias/"+notid,Singleton.url+":8000/api/nliked/"+iduser+"/"+notid,this
					,(ListView) findViewById(R.id.listView1),(Button) findViewById(R.id.comment),(TextView) findViewById(R.id.textView3),(ImageView) findViewById(R.id.mas));
			tarea.execute();

		}

	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public class AsincronDNN extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url,urlsig,urlvista="";
		TextView titview,cuerpview,dateview,cat;
		ImageView mas;
		Button b7,comentarios;
		JSONObject html,sig;
	    private Display_not_log activity;
	    private boolean completed;
	    private Object _response;
	    ListView lv;
	    TextView pueblo;
	    JSONObject seguir;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincronDNN(Context contexto,TextView titview,TextView cuerpview,
			TextView dateview, Button b7,String urlvista,
			String url,String urlsig,Display_not_log activity,ListView lv,
			Button comentarios,TextView pueblo,ImageView mas){
			this.contexto = contexto;
			this.mas = mas;
			this.titview = titview;
			this.cuerpview = cuerpview;
			this.dateview = dateview;
			this.url = url;
			this.activity = activity;
			this.b7 = b7;
			this.urlsig = urlsig;
			this.lv = lv;
			this.comentarios = comentarios;
			this.pueblo = pueblo;
			this.urlvista = urlvista;
		}
		
		public AsincronDNN(Context contexto,TextView titview,TextView cuerpview,
				TextView dateview, Button b7,
				String url,String urlsig,Display_not_log activity,ListView lv,
				Button comentarios,TextView pueblo,ImageView mas){
				this.contexto = contexto;
				this.mas = mas;
				this.titview = titview;
				this.cuerpview = cuerpview;
				this.dateview = dateview;
				this.url = url;
				this.activity = activity;
				this.b7 = b7;
				this.urlsig = urlsig;
				this.lv = lv;
				this.comentarios = comentarios;
				this.pueblo = pueblo;
				
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
			  
			  public void sigo() throws IOException, JSONException {
				    InputStream is = new URL(urlsig).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				      sig = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }
			  
			  public void addnoticia() throws IOException, JSONException {
				    InputStream is = new URL(urlvista).openStream();
                    is.close();
				    
				  }
		@Override
		protected Void doInBackground(Void... params) {

				try {
					if(!url.equalsIgnoreCase(""))
						leernoticia();
					if(!urlsig.equalsIgnoreCase(""))
						sigo();
					if(!urlvista.equalsIgnoreCase(""))
						addnoticia();
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
			String p = "",titular = "ROTO",cuerpo="ROTO", fecha = "Roto",likes="roto",ca="roto";
			int ncomentarios=0;
			try {
				idcats = new LinkedList<Integer>();
				titular = html.getString("titular").replace("-","\n");
				cuerpo = html.getString("cuerpo").replace("-","\n");
				fecha = html.getString("fecha");
				notid = html.getInt("id_noticia");
				url1 = html.getString("url");
				likes = html.getString("liked");
				pid = html.getInt("id_pueblo");
				p = html.getString("dspueblo");
				aseguir=true;
				ncomentarios = html.getInt("ncomentarios");
				comentarios.setText("Ver Comentarios ("+ncomentarios+")");
				JSONArray cat = html.getJSONArray("categoria");
				String[] listacategorias = new String[cat.length()];
			    for(int i=0;i<cat.length();i++){
			    	JSONObject j = cat.getJSONObject(i);
			    	listacategorias[i] = j.getString("dscategoria");
			    	idcats.add(j.getInt("id_categoria"));
			    }
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto,
						android.R.layout.simple_list_item_1, listacategorias);
				lv.setAdapter(adapter);

				if(sig.getBoolean("sigue"))
					b7.setEnabled(false);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b7.setText("Vótame ("+likes+")");
		    titview.setText(titular);
		    cuerpview.setText(cuerpo);
		    dateview.setText(fecha);
		    pueblo.setText(p);
		    cuerpview.setMovementMethod(new ScrollingMovementMethod());
		    
		    
	        BDClass admin1 = new BDClass(contexto,"following", null, 1);
		    SQLiteDatabase db1 = admin1.getReadableDatabase();
			String sql = "SELECT * FROM siguiendo WHERE id="+pid;
			Cursor c = db1.rawQuery(sql, null);
			if(c.getCount()==0){
				mas.setEnabled(true);
			}
			else{
				sigue = true;
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
		    public void setActivity(Display_not_log activity) 
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
	                                                       "Cargando noticia", 
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

	public class Set extends AsyncTask<Void, Void, Object> {
		String url;
	    private Display_not_log activity;
	    private boolean completed;
	    private Object _response;

		public Set(String url,Display_not_log activity){
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
	                                                       "Guardando su voto", 
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
	    public void setActivity(Display_not_log activity) 
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
	            set = true;
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	}
	
	

	public class Asinadd extends AsyncTask<Void, Void, Object> {
		String url;
		Context contexto;
	    private Display_not_log activity;
	    private boolean completed;
	    private Object _response;
	    JSONObject datosuser;
	    private String urlsigue = Singleton.url+":8000/api/logginuser/"+iduser;

		public Asinadd(String url,Display_not_log activity){
			this.url=url;
			this.activity = activity;
			this.contexto = activity;
		}
		@Override
		protected Void doInBackground(Void... params) {
			try {
				actualizar();
				leerdatos();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
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
	                                                       "Agregando pueblo", 
	                                                       false);

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
				    InputStream is = new URL(urlsigue).openStream();
				    try {
				      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
				      String jsonText = readAll(rd);
				       datosuser = new JSONObject(jsonText);
				    } finally {
				      is.close();
				    }
				  }		  


	    public void onPostExecute(Object response){
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
	    public void setActivity(Display_not_log activity) 
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
	            activity.onTaskCompleted(_response); 
	        } 
	    } 
	}
}
