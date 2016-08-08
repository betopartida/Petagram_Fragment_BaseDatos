package com.rubach.petagram.Presentador;

import android.content.Context;

import com.rubach.petagram.db.ConstructorMascotas;
import com.rubach.petagram.fragments.IRecycleViewFragmentView;
import com.rubach.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ronald on 07/08/16.
 */
public class RecycledViewFragmentPresenter implements IRecycledViewFragmentPresenter {

    private IRecycleViewFragmentView iRecycledViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    public RecycledViewFragmentPresenter(IRecycleViewFragmentView iRecycledViewFragmentView, Context context) {
        this.context=context;
        this.iRecycledViewFragmentView=iRecycledViewFragmentView;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas=new ConstructorMascotas(context);
        mascotas=constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iRecycledViewFragmentView.inicializarAdaptadorRV(iRecycledViewFragmentView.crearAdaptador(mascotas));
        iRecycledViewFragmentView.generarLinearLayoutVertical();
    }
}
