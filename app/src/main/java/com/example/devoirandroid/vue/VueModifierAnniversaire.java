package com.example.devoirandroid.vue;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.devoirandroid.R;

public class VueModifierAnniversaire extends AppCompatActivity {

    protected Button boutonRetour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vue_modifier_anniversare);

        boutonRetour = (Button) findViewById(R.id.buttonRetourVueModifier);

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