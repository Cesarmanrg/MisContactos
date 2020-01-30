package io.cesarmanrg.miscontactos.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.cesarmanrg.miscontactos.DetalleContacto;
import io.cesarmanrg.miscontactos.R;
import io.cesarmanrg.miscontactos.pojo.Contacto;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador(ArrayList<Contacto> contactos, Activity activity) {

        this.contactos = contactos;
        this.activity = activity;


    }

    // Inflar el layout y lo pasará el viewholder para que el obtenga los views
    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Asocimos el layout al RecyclerView
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent, false);
        return new ContactoViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());
        contactoViewHolder.tvEmailCV.setText(contacto.getEmail());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, DetalleContacto.class);
                intent.putExtra("Nombre", contacto.getNombre());
                intent.putExtra("Telefono", contacto.getTelefono());
                intent.putExtra("Email", contacto.getEmail());
                activity.startActivity(intent);
            }
        });

        final int count = 0;
        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String total = String.valueOf(count + 1);
                contactoViewHolder.tvNumeroLikes.setText(total);

                Toast.makeText(activity, "Diste like a" + " " + contacto.getNombre(),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }

    // Cantidad de elementos que contiene mi lista de contactos
    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private TextView tvEmailCV;
        private TextView tvNumeroLikes;
        private ImageButton btnLike;


        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgFoto);
            tvNombreCV = itemView.findViewById(R.id.tvNombre);
            tvTelefonoCV = itemView.findViewById(R.id.tvTelefono);
            tvEmailCV = itemView.findViewById(R.id.tvEmail);
            tvNumeroLikes = itemView.findViewById(R.id.tvNumeroLikes);
            btnLike = itemView.findViewById(R.id.btnLike);


        }
    }
}
