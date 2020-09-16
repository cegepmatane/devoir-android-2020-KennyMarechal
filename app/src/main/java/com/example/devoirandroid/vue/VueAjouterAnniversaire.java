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
import com.example.devoirandroid.model.Anniversaire;

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
        String titre =  vueAjouterAnniversaireChampTitre.getText().toString();
        String date = vueAjouterAnniversaireChampDate.getText().toString();
        String heure = vueAjouterAnniversaireChampHeure.getText().toString();
        String description = vueAjouterAnniversaireChampDescription.getText().toString();
        String url = vueAjouterAnniversaireChampURL.getText().toString();

        anniversaireDAO = anniversaireDAO.getInstance();

        anniversaireDAO.ajouterAnniversaire(new Anniversaire(0,titre,date,heure,description,url));
    }

    private void naviguerVueGestionAnniversaire(){
        startActivity(intentActionNaviguerVueGestionAnniversaires);
        finish();
    }
}