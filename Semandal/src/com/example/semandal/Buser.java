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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class Buser extends Activity  implements OnItemSelectedListener{
	String pid,iduser,datos;
	int upos = 0;
	private List<String> lista1,lista1aux;
	private Spinner spinner1;
	private static AsincBlog backgroundTask;
	private static ProgressDialog pleaseWaitDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buser);
		Button b1 = (Button)this.findViewById(R.id.Amigos);
		Button b2 = (Button)this.findViewById(R.id.Noticias);
		Button b3 = (Button)this.findViewById(R.id.deuda);
		ImageButton b4 = (ImageButton)this.findViewById(R.id.Imagebtton);
		final EditText usuario = (EditText)this.findViewById(R.id.NUsuario);
		final EditText nombre = (EditText)this.findViewById(R.id.Nombre);
		final EditText ap1 = (EditText)this.findViewById(R.id.apellido1);
		final EditText ap2 = (EditText)this.findViewById(R.id.apellido2);
		pid = getIntent().getStringExtra("p_id");
		iduser = getIntent().getStringExtra("user_id");
		datos = getIntent().getStringExtra("datos");
		Button b5 = (Button)this.findViewById(R.id.busc);
		AsincBuser tarea = new AsincBuser(this,
				Singleton.url+":8000/api/pueblos",this
				);
		tarea.execute();

		
		
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				String  User,Name,AP1,AP2,idpueblo="";
				User = usuario.getText().toString();
				Name = nombre.getText().toString();
				AP1 = ap1.getText().toString();
				AP2 = ap2.getText().toString();
				if(upos != 0){
					idpueblo = lista1aux.get(upos);
				}
				String stringfinal ="";
				if(!User.equals(""))
					stringfinal = stringfinal+"u:"+User+",";
				if(!Name.equals(""))
					stringfinal = stringfinal+"n:"+Name+",";
				if(!AP1.equals(""))
					stringfinal = stringfinal+"ap1:"+AP1+",";
				if(!AP2.equals(""))
					stringfinal = stringfinal+"ap2:"+AP2+",";
				if(!idpueblo.equals(""))
					stringfinal = stringfinal+"p:"+idpueblo+",";
				stringfinal = stringfinal.substring(0,stringfinal.length()-1);
				stringfinal = "("+stringfinal+")";
				Intent i = new Intent(Buser.this, Amigos.class);
				i.putExtra("busqueda",stringfinal);
				i.putExtra("user_id", iduser);
				i.putExtra("datos", datos);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});		

		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Buser.this, Amigos.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});		
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Buser.this, Lnoticias.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Buser.this, Deuda.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
				startActivity(i);
			}
			
		});
		
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Buser.this, Logueado.class);
				i.putExtra("datos", datos);
				i.putExtra("user_id", iduser);
				i.putExtra("p_id", pid);
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
		   spinner1 = (Spinner) findViewById(R.id.Pob);
		   spinner1 = (Spinner) this.findViewById(R.id.Pob);
		   ArrayAdapter<String> adaptador1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista1);
		   adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   spinner1.setAdapter(adaptador1);
		   spinner1.setOnItemSelectedListener(this);

	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		String selected = parent.getItemAtPosition(pos).toString();
        if(parent == this.findViewById(R.id.Pob))
        	upos=pos;
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// do nothing
		
	}
	
	
	public class AsincBuser extends AsyncTask<Void, Void, Object> {
		Context contexto;
		String urlpueblos;
		JSONObject pueblos;
	    private Buser activity;
	    private boolean completed;
	    private Object _response;
		/*
		 * ERROR DE IO AL EJECUTAR ESTE CÓDIGO
		 * 
		 * */
		
		public AsincBuser(Context contexto,String urlpueblos,Buser activity){
			this.contexto = contexto;
			this.urlpueblos=urlpueblos;
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

			  public void leerpueblos() throws IOException, JSONException {
			    InputStream is = new URL(urlpueblos).openStream();
			    try {
			      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			      String jsonText = readAll(rd);
			       pueblos = new JSONObject(jsonText);
			    } finally {
			      is.close();
			    }
			  }
			  

		@Override
		protected Void doInBackground(Void... params) {

				try {
					leerpueblos();
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
				int npueblos = pueblos.getInt("npueblos");
				lista1= new ArrayList<String>();
				lista1aux= new ArrayList<String>();
				lista1.add("Pueblos");
				lista1aux.add("");
				JSONArray p = pueblos.getJSONArray("pueblos");
				for(int i = 0;i<npueblos;i++){
					JSONObject f = (JSONObject)p.get(i);
				   	lista1.add(f.getString("nombre"));
				   	lista1aux.add(f.getString("idpueblo"));
				}
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
	    public void setActivity(Buser activity) 
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
