package com.example.devoirandroid.donnee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDeDonnee extends SQLiteOpenHelper {

   private static BaseDeDonnee instance = null;

   public static synchronized BaseDeDonnee getInstance(Context contexte){
       if(null == instance){
           instance = new BaseDeDonnee(contexte);
       }
       return instance;
   }

   public static BaseDeDonnee getInstance(){
       return instance;
   }

   public BaseDeDonnee(Context contexte, String name, SQLiteDatabase.CursorFactory factory, int version){
       super(contexte,name,factory,version);
   }

    public BaseDeDonnee(Context contexte){

       super(contexte,"anniversaires",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "create table anniversaire(id INTEGER PRIMARY KEY, titre TEXT, date TEXT)";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        String DELETE = "delete from anniversaire where 1 = 1";
        db.execSQL(DELETE);

        String INSERT_1 = "insert into anniversaire(titre, date) VALUES ('Anniversaire Kenny','27/05/1993')";
        String INSERT_2 = "insert into anniversaire(titre, date) VALUES ('Anniversaire Jessica','01/04/1987')";
        String INSERT_3 = "insert into anniversaire(titre, date) VALUES ('Anniversaire Leon','10/12/2018')";

        db.execSQL(INSERT_1);
        db.execSQL(INSERT_2);
        db.execSQL(INSERT_3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
       String CREATE_TABLE = "create table anniversaire (id PRIMARY KEY, titre TEXT, date TEXT)";
       db.execSQL(CREATE_TABLE);
    }
}
