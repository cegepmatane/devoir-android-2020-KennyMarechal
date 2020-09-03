package com.example.devoirandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueGestionAnniversaires extends AppCompatActivity {

    protected ListView vueGestionAnniversaires;
    protected Button boutonAjouterAnniversaire;
    protected List<HashMap<String, String>> listeAnniversaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_gestion_anniversaires);

        vueGestionAnniversaires = (ListView)findViewById(R.id.vueListeGestionAnniversaires);
        boutonAjouterAnniversaire = (Button) findViewById(R.id.buttonAjouterAnniversaire);

        boutonAjouterAnniversaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vueAjouterAnniversaire = new Intent(getApplicationContext(), VueAjouterAnniversaire.class);
                startActivity(vueAjouterAnniversaire);
                finish();
            }
        });

        listeAnniversaire = preparerListeAnniversaire();

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                listeAnniversaire,
                android.R.layout.two_line_list_item,
                new String[] {"titre", "date de realisation", "heure","description","url"},
                new int[] {android.R.id.text1, android.R.id.text2});

        vueGestionAnniversaires.setAdapter(adapter);
    }

    public List<HashMap<String,String>> preparerListeAnniversaire(){

        List<HashMap<String,String>> listeAnniversaire = new ArrayList<HashMap<String,String>>();

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

        return listeAnniversaire;
    }
}