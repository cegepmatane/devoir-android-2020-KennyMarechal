package com.example.devoirandroid.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.devoirandroid.R;
import com.example.devoirandroid.donnee.AnniversaireDAO;
import com.example.devoirandroid.model.Anniversaire;

public class VueModifierAnniversaire extends AppCompatActivity {

    protected Button actionRetour;
    protected Button actionModifier;
    protected Intent intentActionNaviguerVueGestionAnniversaires;

    protected AnniversaireDAO anniversaireDAO;
    protected Anniversaire anniversaire;

    protected EditText vueModifierAnniversaireChampTitre;
    protected EditText vueModifierAnniversaireChampDate;
    protected EditText vueModifierAnniversaireChampHeure;
    protected EditText vueModifierAnniversaireChampDescription;
    protected EditText vueModifierAnniversaireChampURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_anniversare);

        actionRetour = (Button) findViewById(R.id.vueModifierAnniversaireActionRetour);
        actionModifier = (Button) findViewById(R.id.vueModifierAnniversaireActionModifier);
        intentActionNaviguerVueGestionAnniversaires = new Intent(this, VueGestionAnniversaires.class);

        actionRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naviguerVueGestionAnniversaire();
            }
        });

        Bundle parametre = this.getIntent().getExtras();
        String idParametre = (String) parametre.get("id");
        int id = Integer.parseInt(idParametre);
        anniversaireDAO = anniversaireDAO.getInstance();
        anniversaire = anniversaireDAO.chercherAnniversaireParId(id);

        vueModifierAnniversaireChampTitre = (EditText) findViewById(R.id.vueModifierAnniversaireChampTitre);
        vueModifierAnniversaireChampDate = (EditText) findViewById(R.id.vueModifierAnniversaireChampDate);
        vueModifierAnniversaireChampHeure = (EditText) findViewById(R.id.vueModifierAnniversaireChampHeure);
        vueModifierAnniversaireChampDescription = (EditText) findViewById(R.id.vueModifierAnniversaireChampDescription);
        vueModifierAnniversaireChampURL = (EditText) findViewById(R.id.vueModifierAnniversaireChampURL);

        vueModifierAnniversaireChampTitre.setText(anniversaire.getTitre());
        vueModifierAnniversaireChampDate.setText(anniversaire.getDate());
        vueModifierAnniversaireChampHeure.setText(anniversaire.getHeure());
        vueModifierAnniversaireChampDescription.setText(anniversaire.getDescription());
        vueModifierAnniversaireChampURL.setText(anniversaire.getUrl());

        actionModifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enregisterAnniversaire();
                naviguerVueGestionAnniversaire();
            }
        });
    }

    private void enregisterAnniversaire() {
        anniversaire.setTitre(vueModifierAnniversaireChampTitre.getText().toString());
        anniversaire.setDate(vueModifierAnniversaireChampDate.getText().toString());
        anniversaire.setHeure(vueModifierAnniversaireChampHeure.getText().toString());
        anniversaire.setDescription(vueModifierAnniversaireChampDescription.getText().toString());
        anniversaire.setUrl(vueModifierAnniversaireChampURL.getText().toString());

        anniversaireDAO.moidifierAnniversaire(anniversaire, anniversaire.getId());
    }

    private void naviguerVueGestionAnniversaire(){
        startActivity(intentActionNaviguerVueGestionAnniversaires);
        finish();
    }
}