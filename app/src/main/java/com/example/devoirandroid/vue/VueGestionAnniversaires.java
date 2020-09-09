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
import com.example.devoirandroid.donnee.AnniversaireDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VueGestionAnniversaires extends AppCompatActivity {

    protected ListView vueGestionAnniversairesListe;
    protected Button actionAjouterAnniversaire;
    protected List<HashMap<String, String>> listeAnniversaire;
    protected AnniversaireDAO anniversaireDAO;
    protected Intent intentActionNaviguerAjouterAnnirversaire;
    protected Intent intentActionNaviguerModifierAnnirversaire;

    static final public int ACTIVITE_AJOUTER_ANNIVERSAIRE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_gestion_anniversaires);

        vueGestionAnniversairesListe = (ListView)findViewById(R.id.vueGestionAnniversairesListeAnniversaire);
        actionAjouterAnniversaire = (Button) findViewById(R.id.vueGestionAnniversairesActionAjouterAnniversaire);
        intentActionNaviguerAjouterAnnirversaire = new Intent (this, VueAjouterAnniversaire.class);
        intentActionNaviguerModifierAnnirversaire = new Intent(this, VueModifierAnniversaire.class);
        anniversaireDAO = anniversaireDAO.getInstance();

        afficherListeAnniversaire();

        actionAjouterAnniversaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(intentActionNaviguerAjouterAnnirversaire, ACTIVITE_AJOUTER_ANNIVERSAIRE);
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

    protected void onActivityResult(int activite, int resultat, Intent donnee) {

        super.onActivityResult(activite, resultat, donnee);
        switch (activite){
            case ACTIVITE_AJOUTER_ANNIVERSAIRE:
                afficherListeAnniversaire();
                break;
        }
    }
    public void afficherListeAnniversaire(){
        listeAnniversaire = anniversaireDAO.listerAnniversaire();

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                listeAnniversaire,
                android.R.layout.two_line_list_item,
                new String[] {"titre", "date de realisation", "heure","description","url"},
                new int[] {android.R.id.text1, android.R.id.text2});

        vueGestionAnniversairesListe.setAdapter(adapter);
    }
}