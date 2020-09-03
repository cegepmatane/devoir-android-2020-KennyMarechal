package com.example.devoirandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VueAjouterAnniversaire extends AppCompatActivity {

    protected Button boutonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_ajouter_anniversaire);

        boutonRetour = (Button) findViewById(R.id.buttonRetour);

        boutonRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent vueGestionAnniversaires = new Intent(getApplicationContext(), VueGestionAnniversaires.class);
                startActivity(vueGestionAnniversaires);
                finish();
            }
        });
    }
}