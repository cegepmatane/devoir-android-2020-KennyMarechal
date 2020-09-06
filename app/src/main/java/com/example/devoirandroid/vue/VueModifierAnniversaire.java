package com.example.devoirandroid.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.devoirandroid.R;

public class VueModifierAnniversaire extends AppCompatActivity {

    protected Button actionRetour;
    protected Intent intentActionNaviguerVueGestionAnniversaires;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_anniversare);

        actionRetour = (Button) findViewById(R.id.vueModifierAnniversaireActionRetour);
        intentActionNaviguerVueGestionAnniversaires = new Intent(this, VueGestionAnniversaires.class);

        actionRetour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intentActionNaviguerVueGestionAnniversaires);
                finish();
            }
        });
    }
}