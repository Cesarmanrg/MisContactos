package io.cesarmanrg.miscontactos.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

import io.cesarmanrg.miscontactos.R;
import io.cesarmanrg.miscontactos.adapter.ContactoAdaptador;
import io.cesarmanrg.miscontactos.pojo.Contacto;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        contactos = new ArrayList<Contacto>();

        listaContactos = v.findViewById(R.id.rvContactos);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(staggeredGridLayoutManager);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos, getActivity());
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.material_a, "César Manuel ", "4721287190", "a@a.com"));
        contactos.add(new Contacto(R.drawable.material_b, "Pedro ", "4711287190", "b@a.com"));
        contactos.add(new Contacto(R.drawable.material_c, "Juan", "4701287190", "c@a.com"));
        contactos.add(new Contacto(R.drawable.material_d, "Julio", "4751287190", "d@a.com"));
        contactos.add(new Contacto(R.drawable.material_f, "Mario", "4771287190", "e@a.com"));
        contactos.add(new Contacto(R.drawable.material_c, "Orl", "4791287190", "f@a.com"));
    }
}
