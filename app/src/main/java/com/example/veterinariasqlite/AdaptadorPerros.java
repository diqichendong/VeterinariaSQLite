package com.example.veterinariasqlite;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;

import java.text.SimpleDateFormat;
import java.util.List;

public class AdaptadorPerros extends RecyclerView.Adapter<AdaptadorPerros.ViewHolder> {

    private List<Perro> dataset;

    public AdaptadorPerros(List<Perro> dataset) {
        this.dataset = dataset;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public MaterialCardView card;
        public TextView lblNombre, lblFechaNacimiento, lblVacunado, lblSexo, lblRaza, lblCaracteristicas, lblComentarios;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card);
            lblNombre = itemView.findViewById(R.id.lblNombre);
            lblFechaNacimiento = itemView.findViewById(R.id.lblFechaNacimiento);
            lblVacunado = itemView.findViewById(R.id.lblVacunado);
            lblSexo = itemView.findViewById(R.id.lblSexo);
            lblRaza = itemView.findViewById(R.id.lblRaza);
            lblCaracteristicas = itemView.findViewById(R.id.lblCaracteristicas);
            lblComentarios = itemView.findViewById(R.id.lblComentarios);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.perro_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Perro p = this.dataset.get(position);
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-YYYY");

        holder.lblNombre.setText(p.getNombre());
        holder.lblFechaNacimiento.setText(format.format(p.getFechaNacimiento()));
        holder.lblVacunado.setText(p.isEstaVacunado() ? "Sí" : "No");
        holder.lblSexo.setText(p.isEsMacho() ? "Macho" : "Hembra");
        holder.lblRaza.setText(p.getRaza().getNombre());
        holder.lblCaracteristicas.setText(p.getRaza().getCaracteristicas());
        holder.lblComentarios.setText(p.getComentarios());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
