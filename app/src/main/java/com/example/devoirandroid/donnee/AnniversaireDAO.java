package com.example.devoirandroid.donnee;

import com.example.devoirandroid.model.Anniversaire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnniversaireDAO {

    private static AnniversaireDAO instance = null;
    //private List<HashMap<String,String>> listeAnniversaire ;
    private List<Anniversaire> listeAnniversaire ;

    private AnniversaireDAO(){
        listeAnniversaire = new ArrayList<Anniversaire>();
        preparerListeAnniversaire();
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
/*
        HashMap<String, String> anniversaire;

        anniversaire = new HashMap<String,String>();
        anniversaire.put("titre", "anniversaire Maman");
        anniversaire.put("date de realisation", "02/09/2020");
        anniversaire.put("heure", "18:16");
        anniversaire.put("description ", "pas de description");
        anniversaire.put("url", "no link");
        listeAnniversaire.add(anniversaire);

        anniversaire = new HashMap<String,String>();
        anniversaire.put("titre", "anniversaire papa");
        anniversaire.put("date de realisation", "02/09/2020");
        anniversaire.put("heure", "18:16");
        anniversaire.put("description ", "pas de description");
        anniversaire.put("url", "no link");
        listeAnniversaire.add(anniversaire);

        anniversaire = new HashMap<String,String>();
        anniversaire.put("titre", "anniversaire Leon");
        anniversaire.put("date de realisation", "02/09/2020");
        anniversaire.put("heure", "18:16");
        anniversaire.put("description ", "pas de description");
        anniversaire.put("url", "no link");
        listeAnniversaire.add(anniversaire);

        anniversaire = new HashMap<String,String>();
        anniversaire.put("titre", "anniversaire Kenny");
        anniversaire.put("date de realisation", "02/09/2020");
        anniversaire.put("heure", "18:16");
        anniversaire.put("description ", "pas de description");
        anniversaire.put("url", "no link");
        listeAnniversaire.add(anniversaire);

 */
    }

    public List<Anniversaire> listerAnniversaire(){
        return listeAnniversaire;
    }

    public void ajouterAnniversaire(Anniversaire anniversaire){
        //listeAnniversaire.add(anniversaire);
    }
}
