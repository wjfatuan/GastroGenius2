package com.example.gastrogenius.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastrogenius.R;
import com.example.gastrogenius.models.HomeHorModel;

import java.util.List;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    private Context context;
    private List<HomeHorModel> list;

    // Constructor
    public HomeHorAdapter(Context context, List<HomeHorModel> list) {
        this.context = context;
        this.list = list;
    }

    // Crear una nueva vista para cada item
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false);
        return new ViewHolder(itemView);
    }

    // Asignar valores a los elementos del item
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
    }

    // Devolver el número total de items
    @Override
    public int getItemCount() {
        return list.size();
    }

    // Clase interna ViewHolder para almacenar las vistas de cada item
    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializar las vistas del item
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
        }
    }
}
