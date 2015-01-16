package com.example.semandal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BDClass extends SQLiteOpenHelper{

	public BDClass(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pueblos(id integer primary key, dspueblo text)");		
        db.execSQL("create table categorias(id integer primary key, categoria text)");		
}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        db.execSQL("drop table if exists pueblos");
	        db.execSQL("create table pueblos(id integer primary key, dspueblo text)");		
	        db.execSQL("drop table if exists categorias");
	        db.execSQL("create table categorias(id integer primary key, categoria text)");		
	}

}
