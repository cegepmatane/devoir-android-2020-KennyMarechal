package com.example.devoirandroid.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.devoirandroid.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueGestionAnniversaires extends AppCompatActivity {

    protected ListView vueGestionAnniversairesListe;
    protected Button actionAjouterAnniversaire;
    protected List<HashMap<String, String>> listeAnniversaire;
    protected Intent intentActionNaviguerAjouterAnnirversaire;
    protected Intent intentActionNaviguerModifierAnnirversaire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_gestion_anniversaires);

        vueGestionAnniversairesListe = (ListView)findViewById(R.id.vueGestionAnniversairesListeAnniversaire);
        actionAjouterAnniversaire = (Button) findViewById(R.id.vueGestionAnniversairesActionAjouterAnniversaire);
        intentActionNaviguerAjouterAnnirversaire = new Intent (this, VueAjouterAnniversaire.class);
        intentActionNaviguerModifierAnnirversaire = new Intent(this, VueModifierAnniversaire.class);

        listeAnniversaire = preparerListeAnniversaire();

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                listeAnniversaire,
                android.R.layout.two_line_list_item,
                new String[] {"titre", "date de realisation", "heure","description","url"},
                new int[] {android.R.id.text1, android.R.id.text2});

        vueGestionAnniversairesListe.setAdapter(adapter);

        actionAjouterAnniversaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentActionNaviguerAjouterAnnirversaire);
                finish();
            }
        });

        vueGestionAnniversairesListe.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int positionDansAdapteur, long positionItem) {
                        ListView vueListeAnniversaire = (ListView)view.getParent();
                        HashMap<String,String>anniversaire = (HashMap<String,String>)vueListeAnniversaire.getItemAtPosition((int)positionItem);

                        /*Toast message = Toast.makeText(getApplicationContext(),"Position " +positionItem + " Titre "+ anniversaire.get("titre"),
                                Toast.LENGTH_SHORT);
                        message.show();*/

                        startActivity(intentActionNaviguerModifierAnnirversaire);
                        finish();
                    }
                });
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