package com.example.gastrogenius.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gastrogenius.R;
import com.example.gastrogenius.models.HomeHorModel;
import com.example.gastrogenius.models.HomeVerModel;

import java.util.ArrayList;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {

    private final UpdateVerticalRec updateVerticalRec;
    private final Activity activity;
    private final ArrayList<HomeHorModel> list;

    private int row_index = -1; // Controla qué elemento está seleccionado

    public HomeHorAdapter(ArrayList<HomeHorModel> list, Activity activity, UpdateVerticalRec updateVerticalRec) {
        this.list = list;
        this.activity = activity;
        this.updateVerticalRec = updateVerticalRec;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Obtener la posición actualizada del ViewHolder
        int currentPosition = holder.getAdapterPosition();
        if (currentPosition == RecyclerView.NO_POSITION) {
            return; // Evitar errores si la posición no es válida
        }

        // Configurar los datos en los elementos de la vista
        holder.imageView.setImageResource(list.get(currentPosition).getImage());
        holder.name.setText(list.get(currentPosition).getName());

        // Cambiar fondo si el elemento está seleccionado
        if (row_index == currentPosition) {
            holder.cardView.setBackgroundResource(R.drawable.change_bg);
        } else {
            holder.cardView.setBackgroundResource(R.drawable.default_bg);
        }

        // Manejar el clic en el elemento
        holder.cardView.setOnClickListener(v -> {
            row_index = currentPosition;
            notifyDataSetChanged(); // Notificar cambio de selección

            // Lista de elementos para el RecyclerView vertical
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            switch (currentPosition) {
                case 0:
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "Pizza 1", "4.8"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "Pizza 2", "4.7"));
                    homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "Pizza 3", "5.0"));
                    break;
                case 1:
                    homeVerModels.add(new HomeVerModel(R.drawable.burger1, "Burger 1", "4.5"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger2, "Burger 2", "4.3"));
                    homeVerModels.add(new HomeVerModel(R.drawable.burger4, "Burger 3", "4.6"));
                    break;
                case 2:
                    homeVerModels.add(new HomeVerModel(R.drawable.fries1, "Fries 1", "4.2"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries2, "Fries 2", "4.0"));
                    homeVerModels.add(new HomeVerModel(R.drawable.fries3, "Fries 3", "4.5"));
                    break;
                case 3:
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream1, "Ice Cream 1", "4.9"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream2, "Ice Cream 2", "4.8"));
                    homeVerModels.add(new HomeVerModel(R.drawable.icecream3, "Ice Cream 3", "4.7"));
                    break;
                default:
                    break;
            }

            // Llamar al callback para actualizar el RecyclerView vertical
            updateVerticalRec.callBack(currentPosition, homeVerModels);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.hor_img);
            name = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
