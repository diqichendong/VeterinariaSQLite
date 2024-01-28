package com.example.veterinariasqlite;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class AdaptadorPropietarios extends RecyclerView.Adapter<AdaptadorPropietarios.ViewHolder> {

    private List<Propietario> dataset;
    private Context context;

    public AdaptadorPropietarios (List<Propietario> dataset) {
        this.dataset = dataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public MaterialCardView card;
        public TextView lblNombre, lblTelefono, lblEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblTelefono = itemView.findViewById(R.id.lblTelefono);
            lblEmail = itemView.findViewById(R.id.lblEmail);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.propietario_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Propietario p = this.dataset.get(position);

        holder.lblNombre.setText(p.getNombre() + " " + p.getApellidos());
        holder.lblTelefono.setText(p.getTelefono());
        holder.lblEmail.setText(p.getEmail());

        holder.card.setOnClickListener(v -> {
            Intent i = new Intent(context, PerrosActivity.class);
            i.putExtra("propietario", p);
            context.startActivity(i);
        });
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
