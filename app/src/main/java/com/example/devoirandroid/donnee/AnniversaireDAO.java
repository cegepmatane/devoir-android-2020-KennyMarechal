package com.example.devoirandroid.donnee;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.devoirandroid.model.Anniversaire;

import java.util.ArrayList;
import java.util.List;

public class AnniversaireDAO {

    private static AnniversaireDAO instance = null;
    private List<Anniversaire> listeAnniversaire ;
    private BaseDeDonnee baseDeDonnee;

    private AnniversaireDAO(){
        baseDeDonnee = this.baseDeDonnee.getInstance();

        listeAnniversaire = new ArrayList<Anniversaire>();
        //preparerListeAnniversaire();
    }

    public static AnniversaireDAO getInstance(){
        if(null==instance){
            instance=new AnniversaireDAO();
        }
        return instance;
}
    private void preparerListeAnniversaire(){

        listeAnniversaire.add(new Anniversaire(0,"anniversaire Maman","19/04/1960","null","pas de description","null"));
        listeAnniversaire.add(new Anniversaire(1,"anniversaire papa","27/04/1958","null","pas de description","null"));
        listeAnniversaire.add(new Anniversaire(2,"anniversaire Leon","10/12/2018","null","pas de description","null"));
        listeAnniversaire.add(new Anniversaire(3,"anniversaire Kenny","27/05/1993","null","pas de description","null"));
        listeAnniversaire.add(new Anniversaire(3,"anniversaire Jessica <3","01/04/1987","null","pas de description","null"));
    }


    public List<Anniversaire> listerAnniversaire(){
        String LISTER_ANNIVERSAIRE = "SELECT * FROM anniversaire" ;
        Cursor curseur = baseDeDonnee.getReadableDatabase().rawQuery(LISTER_ANNIVERSAIRE,
                null);

        listeAnniversaire.clear();

        int indexId = curseur.getColumnIndex("id");
        int indexTitre = curseur.getColumnIndex("titre");
        int indexDate = curseur.getColumnIndex("date");
        int indexDescription = curseur.getColumnIndex("description");

        /*int indexHeure = curseur.getColumnIndex("date");
        int indexURL = curseur.getColumnIndex("date");*/

        for(curseur.moveToFirst();!curseur.isAfterLast();curseur.moveToNext()){
            int id = curseur.getInt(indexId);
            String titre = curseur.getString(indexTitre);
            String date = curseur.getString(indexDate);
            String description = curseur.getString(indexDescription);

            listeAnniversaire.add(new Anniversaire(id, titre, date,"null",description,"null"));
        }
        return listeAnniversaire;
    }

    public void ajouterAnniversaire(Anniversaire anniversaire){
        SQLiteDatabase baseDeDonneeEcriture = this.baseDeDonnee.getWritableDatabase();

        baseDeDonneeEcriture.beginTransaction();
        try {
            ContentValues anniversaireEnCleValeur = new ContentValues();
            anniversaireEnCleValeur.put("titre",anniversaire.getTitre());
            anniversaireEnCleValeur.put("date",anniversaire.getDate());

            baseDeDonneeEcriture.insertOrThrow("anniversaire",null, anniversaireEnCleValeur);
            baseDeDonneeEcriture.setTransactionSuccessful();
        }catch (Exception e){
            Log.d("AnniversaireDAO","Errreur en tentant d'ajouter un anniversaire dans la base de donnee");
        }finally {
            baseDeDonneeEcriture.endTransaction();
        }
    }

    public void moidifierAnniversaire(Anniversaire anniversaire){

        //TODO

    }

    public Anniversaire chercherAnniversaireParId(int id){
        listerAnniversaire();
        for(Anniversaire anniversaireRecherche : this.listeAnniversaire){
            if(anniversaireRecherche.getId()== id)return anniversaireRecherche;
        }
        return  null;
    }
}
