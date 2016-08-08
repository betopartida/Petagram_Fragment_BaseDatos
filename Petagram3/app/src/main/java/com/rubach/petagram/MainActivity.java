package com.rubach.petagram;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.rubach.petagram.adapter.PageAdapter;
import com.rubach.petagram.fragments.RecycleViewFragment;
import com.rubach.petagram.fragments.ResumenFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ArrayList<Mascota> Mascotas;
    //private RecyclerView listaMascotas;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Toolbar miActionBar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(miActionBar);
        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.cat_footprint_48);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final ActionBar ab = getSupportActionBar();
        //ab.setHomeAsUpIndicator(R.drawable.ic_menu); // set a custom icon for the default home button
        ab.setDisplayShowHomeEnabled(true);

        //cambios para fragments
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabLayout=(TabLayout) findViewById(R.id.tabLayout);
        viewPager=(ViewPager) findViewById(R.id.viewPager);

        setUpViewPager(); //carga los tabs y el view pager.

        if(toolbar!=null){
            setSupportActionBar(toolbar);
        }
        //

/*
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        //muestro los objetos vertical
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //configuro que se muestra asi en el recicleview
        listaMascotas.setLayoutManager(llm);
        //cargo las mascotas
        InicializarListaMascotas();
        //cargo el adaptador
        inicializarAdaptador();*/
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecycleViewFragment());
        fragments.add(new ResumenFragment());
        return fragments;
    }

    private void setUpViewPager(){
        //cargo el view pager con los fragmentes
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        //agrego al tab
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.home_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.year_of_dog_48);
    }

    public void onClickSiguiente(View v){
        Intent intent=new Intent(this,DetalleActivity.class);
        startActivity(intent);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbarmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.action_favorite:
                //al seleccionar, voy a la activity detalle.
                Intent intent=new Intent(this, DetalleActivity.class);
                this.startActivity(intent);
            return true;
            case R.id.action_about:
                Intent in=new Intent(this, AboutActivity.class);
                this.startActivity(in);
                return true;
            case R.id.mContacto:
                Intent icont=new Intent(this, contactoActivity.class);
                this.startActivity(icont);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
