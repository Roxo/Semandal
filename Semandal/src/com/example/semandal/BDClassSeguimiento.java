package com.example.semandal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BDClassSeguimiento extends SQLiteOpenHelper{

	public BDClassSeguimiento(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table siguiendo(id integer primary key, dspueblo text)");		
}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        db.execSQL("drop table if exists siguiendo");
	        db.execSQL("create table siguiendo(id integer primary key, dspueblo text)");		
	}

}
