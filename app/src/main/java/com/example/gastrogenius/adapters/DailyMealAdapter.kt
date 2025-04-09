package com.example.gastrogenius.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.gastrogenius.R
import com.example.gastrogenius.models.DailyMealModel
import com.example.gastrogenius.activities.DetailedDailyMealActivity // Asegúrate que esta clase existe y el import sea correcto

class DailyMealAdapter(
    private val context: Context,
    private val list: List<DailyMealModel>
) : RecyclerView.Adapter<DailyMealAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.daily_meal_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.imageView.setImageResource(item.image)
        holder.name.text = item.name
        holder.description.text = item.description

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailedDailyMealActivity::class.java)
            intent.putExtra("type", item.type)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val name: TextView = itemView.findViewById(R.id.textView9)
        val description: TextView = itemView.findViewById(R.id.textView8)
    }
}
