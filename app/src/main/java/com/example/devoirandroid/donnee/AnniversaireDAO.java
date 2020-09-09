package com.example.devoirandroid.donnee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnniversaireDAO {

    private static AnniversaireDAO instance = null;
    private List<HashMap<String,String>> listeAnniversaire ;

    private AnniversaireDAO(){
        listeAnniversaire = new ArrayList<HashMap<String,String>>();
        preparerListeAnniversaire();
    }
public static AnniversaireDAO getInstance(){
        if(null==instance){
            instance=new AnniversaireDAO();
        }
        return instance;
}
    private void preparerListeAnniversaire(){

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
    }

    public List<HashMap<String,String>> listerAnniversaire(){
        return listeAnniversaire;
    }

    public void ajouterAnniversaire(HashMap<String,String> anniversaire){
        listeAnniversaire.add(anniversaire);
    }
}
