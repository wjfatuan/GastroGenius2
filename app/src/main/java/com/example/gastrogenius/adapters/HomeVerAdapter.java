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
import com.example.gastrogenius.models.HomeVerModel;

import java.util.List;

public class HomeVerAdapter extends RecyclerView.Adapter<HomeVerAdapter.ViewHolder> {

    Context context;
    List<HomeVerModel> list;

    public HomeVerAdapter(Context context, List<HomeVerModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_vertical_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeVerModel model = list.get(position);
        holder.imageView.setImageResource(model.getImage());
        holder.name.setText(model.getName());
        holder.rating.setText(model.getRating()); // Asegúrate de que rating sí existe en el layout
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name, rating; // Eliminamos "price"

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            name = itemView.findViewById(R.id.name);
            rating = itemView.findViewById(R.id.rating); // Asegúrate de que rating existe en tu XML
        }
    }
}

