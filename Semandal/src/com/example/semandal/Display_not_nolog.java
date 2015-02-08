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

import com.example.semandal.Display_not_log.Asinadd;
import com.example.semandal.Display_not_log.AsincronDNN;
import com.example.semandal.Display_not_log.Set;
import com.example.semandal.Nolog.AsincronNolog;
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
import android.os.Bundle;
import android.os.AsyncTask.Status;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Display_not_nolog extends Activity {
	String url,url1;
	int notid=0;
	private static AsincronDNN backgroundTask;
	private static ProgressDialog pleaseWaitDialog;
	LinkedList<Integer> idcats;
	int iduser,indice;
	private boolean set=false,enabled = false,sigo = false;
	private Display_not_nolog a = this;
	ImageView b7;
	ListView lista ;
	boolean sigue= false,aseguir = false;
	Bundle bundle;
	ImageView mas;
	ScrollView sc;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_not_nolog);
		ImageView b1 = (ImageView)this.findViewById(R.id.Entrar);
		ImageView b2 = (ImageView)this.findViewById(R.id.Info);
		ImageView b3 = (ImageView)this.findViewById(R.id.Buscar);
		ImageView b4 = (ImageView)this.findViewById(R.id.Imagebtton);
		ImageView b5 = (ImageView)this.findViewById(R.id.comentario);
		ImageView b6 = (ImageView)this.findViewById(R.id.button1);
		final TextView votos = (TextView)this.findViewById(R.id.votos);
		b7 = (ImageView)this.findViewById(R.id.button2);
		ImageView categoriza = (ImageView)this.findViewById(R.id.b1);
		lista = (ListView) this.findViewById(R.id.listView1);
		/////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////
		notid=getIntent().getIntExtra("id",0);
		mas = (ImageView) findViewById(R.id.mas);
		sc = (ScrollView)this.findViewById(R.id.scroll);
		final TextView pueblo = (TextView) findViewById(R.id.textView3);
		AsincronDNN tarea = null;
		tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
				(TextView) findViewById(R.id.Noticia),
				(TextView) findViewById(R.id.fecha),b7,
				Singleton.url+":8000/api/noticias/"+notid,this
				,(ListView) findViewById(R.id.listView1),(TextView)findViewById(R.id.comment),
				pueblo,mas,votos,"");
		tarea.execute();
		
		mas.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					showDialog(a,"Confirmación","Para seguir pueblos necesita entrar o registrarse. ¿Desea hacerlo ahora?");
			}
		});				

		
		categoriza.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(a,"Confirmación","Para categorizar noticias necesita entrar o registrarse. ¿Desea hacerlo ahora?");
			}
			
		});				

		b7.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				showDialog(a,"Confirmación","Para votar noticias necesita entrar o registrarse. ¿Desea hacerlo ahora?");
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
				Intent i = new Intent(Display_not_nolog.this, Comentarios_nolog.class);
				i.putExtra("id", notid);
				startActivity(i);
			}
			
		});				
		
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, Log.class);
				startActivity(i);
		}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, Informacion.class);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, Bnolog.class);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Display_not_nolog.this, Nolog.class);
				startActivity(i);
			}
			
		});
		
		lista.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
				Intent i = new Intent(Display_not_nolog.this, Bnologres.class);
				String stringfinal = "id_c:"+idcats.get(pos);
				stringfinal = "("+stringfinal+")";
				i.putExtra("datos", stringfinal);
				i.putExtra("busqueda", true);
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
					Singleton.url+":8000/api/noticias/"+notid,this
					,(ListView) findViewById(R.id.listView1),(TextView) findViewById(R.id.comment),(TextView) findViewById(R.id.textView3),(ImageView) findViewById(R.id.mas),(TextView)findViewById(R.id.votos),"");
			tarea.execute();

		}
		else{
			if((backgroundTask!=null)&&(backgroundTask.getStatus()==Status.RUNNING)){
				if(pleaseWaitDialog != null)
					pleaseWaitDialog.show();
			}
		}

	}




	private void onTaskCompleted(Object _response){
		sc.smoothScrollTo(0,0);
		if(set){
			set=false;
			AsincronDNN tarea = null;
			tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
					(TextView) findViewById(R.id.Noticia),
					(TextView) findViewById(R.id.fecha),b7,
					Singleton.url+":8000/api/noticias/",this
					,(ListView) findViewById(R.id.listView1),(TextView) findViewById(R.id.comment),(TextView) findViewById(R.id.textView3),(ImageView) findViewById(R.id.mas),(TextView) findViewById(R.id.votos),"");
			tarea.execute();

		}

	}

	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public class AsincronDNN extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		TextView titview,cuerpview,dateview,cat,comentarios;
		ImageView mas;
		ImageView b7;
		JSONObject html;
	    private Display_not_nolog activity;
	    private boolean completed;
	    private Object _response;
	    ListView lv;
	    TextView pueblo;
	    JSONObject seguir;
	    TextView votos;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincronDNN(Context contexto,TextView titview,TextView cuerpview,
			TextView dateview, ImageView b7,String urlvista,
			String url,String urlsig,Display_not_nolog activity,ListView lv,
			TextView comentarios,TextView pueblo,ImageView mas,TextView votos,
			String urlmegusta){
			this.contexto = contexto;
			this.mas = mas;
			this.titview = titview;
			this.cuerpview = cuerpview;
			this.dateview = dateview;
			this.url = url;
			this.activity = activity;
			this.b7 = b7;
			this.lv = lv;
			this.comentarios = comentarios;
			this.pueblo = pueblo;
			this.votos = votos;
		}
		
		public AsincronDNN(Context contexto,TextView titview,TextView cuerpview,
				TextView dateview, ImageView b7,
				String url,Display_not_nolog activity,ListView lv,
				TextView comentarios,TextView pueblo,ImageView mas,TextView votos,
				String urlmegusta){
				this.contexto = contexto;
				this.mas = mas;
				this.titview = titview;
				this.cuerpview = cuerpview;
				this.dateview = dateview;
				this.url = url;
				this.activity = activity;
				this.b7 = b7;
				this.lv = lv;
				this.comentarios = comentarios;
				this.pueblo = pueblo;
				this.votos = votos;
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
					if(!url.equalsIgnoreCase(""))
						leernoticia();
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
				p = html.getString("dspueblo");
				ncomentarios = html.getInt("ncomentarios");
				comentarios.setText(""+ncomentarios);
				votos.setText(""+html.getInt("liked"));
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
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    titview.setText(titular);
		    cuerpview.setText(cuerpo);
		    dateview.setText(fecha);
		    pueblo.setText(p);
		    cuerpview.setMovementMethod(new ScrollingMovementMethod());
		    
		    

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
		    public void setActivity(Display_not_nolog activity) 
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
	
	public void showDialog(Activity activity, String title, CharSequence message) {
		AlertDialog.Builder b = new AlertDialog.Builder(Display_not_nolog.this);
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
				Intent i = new Intent(Display_not_nolog.this, Log.class);
				startActivity(i);
		    }
		});
		b.show();
	}

	
}
