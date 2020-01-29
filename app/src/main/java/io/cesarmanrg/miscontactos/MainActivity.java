package io.cesarmanrg.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      contactos = new ArrayList<Contacto>();

      listaContactos = findViewById(R.id.rvContactos);

      // Definir en que forma se presenta el listado
        Context context;
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
        /**
        ListView lstContactos = findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra("Nombre", contactos.get(position).getNombre());
                intent.putExtra("Telefono", contactos.get(position).getTelefono());
                intent.putExtra("Email", contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });**/

    }

    public void inicializarAdaptador(){
        ContactoAdaptador adaptador = new ContactoAdaptador(contactos);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.material_a,"César Manuel ", "4721287190", "a@a.com"));
        contactos.add(new Contacto(R.drawable.material_b,"Pedro ", "4711287190", "b@a.com"));
        contactos.add(new Contacto(R.drawable.material_c,"Juan", "4701287190", "c@a.com"));
        contactos.add(new Contacto(R.drawable.material_d,"Julio", "4751287190", "d@a.com"));
        contactos.add(new Contacto(R.drawable.material_f,"Mario", "4771287190", "e@a.com"));
        contactos.add(new Contacto(R.drawable.material_c,"Orl", "4791287190", "f@a.com"));
    }
}
