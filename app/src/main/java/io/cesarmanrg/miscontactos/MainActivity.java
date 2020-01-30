package io.cesarmanrg.miscontactos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import io.cesarmanrg.miscontactos.adapter.PageAdapter;
import io.cesarmanrg.miscontactos.fragments.PerfilFragment;
import io.cesarmanrg.miscontactos.fragments.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        setUpViewPager();

        /**
        contactos = new ArrayList<Contacto>();

        listaContactos = findViewById(R.id.rvContactos);

        // Definir en que forma se presenta el listado


         LinearLayoutManager llm = new LinearLayoutManager(this);
         llm.setOrientation(LinearLayoutManager.VERTICAL);**/

        //GridLayoutManager glm = new GridLayoutManager(this, 2);
        /**
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(staggeredGridLayoutManager);
        inicializarListaContactos();
        inicializarAdaptador();

         ListView lstContactos = findViewById(R.id.lstContactos);
         lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombresContacto));
         lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
        intent.putExtra("Nombre", contactos.get(position).getNombre());
        intent.putExtra("Telefono", contactos.get(position).getTelefono());
        intent.putExtra("Email", contactos.get(position).getEmail());
        startActivity(intent);
        finish();
        }
        });**/


    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }

    private void setUpViewPager() {

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_action_name);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_action_profile);

    }
}
