package com.rubach.petagram.fragments;

import com.rubach.petagram.adapter.MascotaAdaptador;
import com.rubach.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by Ronald on 07/08/16.
 */
public interface IRecycleViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
