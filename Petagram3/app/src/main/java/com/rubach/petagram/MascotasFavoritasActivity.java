package com.rubach.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MascotasFavoritasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        //asegurarnos que en la toolbar aparezca el botn de atras y funcione segun conf. de manifiest.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
