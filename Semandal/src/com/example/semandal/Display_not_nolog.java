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

import com.example.semandal.Display_not_log.AsincronDNN;
import com.example.semandal.Nolog.AsincronNolog;
import com.example.semandal.aux.Singleton;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
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
	private Display_not_nolog a = this;
	LinkedList<Integer> idcats;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_not_nolog);
		notid=getIntent().getIntExtra("id",0);
		AsincronDNN tarea = null;
		tarea = new AsincronDNN(this,(TextView) findViewById(R.id.titular),
				(TextView) findViewById(R.id.Noticia),
				(TextView) findViewById(R.id.fecha),(TextView) findViewById(R.id.textView1),
				Singleton.url+":8000/api/noticias/"+notid,this,
				(ListView) findViewById(R.id.listView1),(Button) findViewById(R.id.comment)
				,(TextView) findViewById(R.id.pueblos));
		tarea.execute();

		
		Button b4 = (Button)this.findViewById(R.id.comment);
		Button b1 = (Button)this.findViewById(R.id.loggin);
		Button b2 = (Button)this.findViewById(R.id.info);
		Button b3 = (Button)this.findViewById(R.id.busqueda);
		Button b5 = (Button)this.findViewById(R.id.button1);
		Button b6 = (Button)this.findViewById(R.id.button2);
	
		
		b6.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(a,"Advertencia","Para indicar que te gusta una noticia debe entrar o registrarse, ¿Desea usted hacerlo ahora?");
			}
			
		});	
		
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url1));
				startActivity(browserIntent);
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
				Intent i = new Intent(Display_not_nolog.this, Comentarios_nolog.class);
				i.putExtra("id", notid);
				startActivity(i);
			}
			
	});

		
		
		ListView lv = (ListView) findViewById(R.id.listView1);
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1,int pos, long arg3) {
				Intent i = new Intent(Display_not_nolog.this, Bnologres.class);
				String stringfinal = "id_c:"+idcats.get(pos);
				stringfinal = "("+stringfinal+")";
				i.putExtra("datos", stringfinal);
				startActivity(i);
		    }
		});

		
		lv.setOnTouchListener(new OnTouchListener() {
		    // Setting on Touch Listener for handling the touch inside ScrollView
		    @Override
		    public boolean onTouch(View v, MotionEvent event) {
		    // Disallow the touch request for parent scroll on touch of child view
		    v.getParent().requestDisallowInterceptTouchEvent(true);
		    return false;
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



	private void onTaskCompleted(Object _response){
	}

	public class AsincronDNN extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String url;
		TextView titview,cuerpview,dateview,likes;
		JSONObject html, Comentario;
	    private Display_not_nolog activity;
	    private boolean completed;
	    private Object _response;
	    String[] listacategorias;
	    ListView lv;
	    Button comentarios;
	    TextView pueblo;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincronDNN(Context contexto,TextView titview,TextView cuerpview,
			TextView dateview,TextView likes,String url,Display_not_nolog activity,
			ListView lv,Button comentarios,TextView pueblo){
			this.contexto = contexto;
			this.titview = titview;
			this.cuerpview = cuerpview;
			this.dateview = dateview;
			this.url = url;
			this.activity = activity;
			this.likes = likes;
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
			  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leernoticia();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JSONException e) {
					 String answer = "Ha ocurrido un error en el servidor de Semandal";
					 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
				}

			return null;
		}



		@Override
		public void onPostExecute(Object response){
			String titular="",cuerpo="", fecha="",p="";
			int like=0,ncomentarios=0;
			try {
				idcats = new LinkedList<Integer>();
				titular = html.getString("titular").replace("-","\n");
				cuerpo = html.getString("cuerpo").replace("-","\n");
				fecha = html.getString("fecha");
				notid = html.getInt("id_noticia");
				url1 = html.getString("url");
				like = html.getInt("liked");
				ncomentarios = html.getInt("ncomentarios");
				comentarios.setText("Ver Comentarios ("+ncomentarios+")");
				JSONArray cat = html.getJSONArray("categoria");
				p = html.getString("dspueblo");
				listacategorias =  new String[cat.length()];
			    for(int i=0;i<cat.length();i++){
			    	JSONObject j = cat.getJSONObject(i);
			    	listacategorias[i] = j.getString("dscategoria");
			    	idcats.add(j.getInt("id_categoria"));
			    }
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(contexto,
						android.R.layout.simple_list_item_1, listacategorias);
				lv.setAdapter(adapter);
				likes.setText(""+like);
			    titview.setText(titular);
			    pueblo.setText(p);
			    cuerpview.setText(cuerpo);
			    dateview.setText(fecha);
			    cuerpview.setMovementMethod(new ScrollingMovementMethod());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				 String answer = "Ha ocurrido un error en el parseo json";
				 Toast.makeText(getApplicationContext(), answer, Toast.LENGTH_LONG).show();
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
