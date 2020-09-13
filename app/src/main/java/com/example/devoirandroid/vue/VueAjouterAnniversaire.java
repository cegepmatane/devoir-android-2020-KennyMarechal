package com.example.devoirandroid.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.devoirandroid.R;
import com.example.devoirandroid.donnee.AnniversaireDAO;

import java.util.HashMap;

public class VueAjouterAnniversaire extends AppCompatActivity {

    protected Button actionRetour;
    protected Button actionValider;
    protected Intent intentActionNaviguerVueGestionAnniversaires;

    protected AnniversaireDAO anniversaireDAO;

    protected EditText vueAjouterAnniversaireChampTitre;
    protected EditText vueAjouterAnniversaireChampDate;
    protected EditText vueAjouterAnniversaireChampHeure;
    protected EditText vueAjouterAnniversaireChampDescription;
    protected EditText vueAjouterAnniversaireChampURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_ajouter_anniversaire);

        actionRetour = (Button) findViewById(R.id.vueAjouterAnniversaireActionRetour);
        intentActionNaviguerVueGestionAnniversaires = new Intent(this, VueGestionAnniversaires.class);

        actionRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naviguerVueGestionAnniversaire();
            }
        });

        vueAjouterAnniversaireChampTitre = (EditText)findViewById(R.id.vueAjouterAnniversaireChampTitre);
        vueAjouterAnniversaireChampDate = (EditText)findViewById(R.id.vueAjouterAnniversaireChampDate);
        vueAjouterAnniversaireChampHeure = (EditText)findViewById(R.id.vueAjouterAnniversaireChampHeure);
        vueAjouterAnniversaireChampDescription = (EditText)findViewById(R.id.vueAjouterAnniversaireChampDescription);
        vueAjouterAnniversaireChampURL = (EditText)findViewById(R.id.vueAjouterAnniversaireChampURL);

        actionValider = (Button) findViewById(R.id.vueAjouterAnniversaireActionValider);

        actionValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enregistrerAnniversaire();
                naviguerVueGestionAnniversaire();
                /*Toast message = Toast.makeText(getApplicationContext(),"Champ titre "+vueAjouterAnniversaireChampTitre.getText().toString(),
                        Toast.LENGTH_SHORT);
                message.show();*/
            }
        });
    }

    private void enregistrerAnniversaire(){

        HashMap<String, String> anniversaire;

        anniversaire = new HashMap<String,String>();
        anniversaire.put("titre", vueAjouterAnniversaireChampTitre.getText().toString());
        anniversaire.put("date", vueAjouterAnniversaireChampDate.getText().toString());
        anniversaire.put("heure", vueAjouterAnniversaireChampHeure.getText().toString());
        anniversaire.put("description ", vueAjouterAnniversaireChampDescription.getText().toString());
        anniversaire.put("url", vueAjouterAnniversaireChampURL.getText().toString());

        anniversaireDAO = anniversaireDAO.getInstance();

        //anniversaireDAO.ajouterAnniversaire(anniversaire);
    }

    private void naviguerVueGestionAnniversaire(){
        startActivity(intentActionNaviguerVueGestionAnniversaires);
        finish();
    }
}