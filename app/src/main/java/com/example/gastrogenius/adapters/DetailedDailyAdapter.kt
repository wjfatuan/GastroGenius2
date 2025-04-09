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
import com.example.gastrogenius.activities.DetailedDailyMealActivity
import com.example.gastrogenius.models.DetailedDailyModel

class DetailedDailyAdapter(
    private val context: Context,
    private val list: List<DetailedDailyModel>
) : RecyclerView.Adapter<DetailedDailyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.detailed_daily_meal_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.imageView.setImageResource(item.image)
        holder.name.text = item.name
        holder.description.text = item.description
        holder.rating.text = item.rating

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailedDailyMealActivity::class.java)
            intent.putExtra("type", item.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.dailyled_img)
        val name: TextView = itemView.findViewById(R.id.detailet_name)
        val description: TextView = itemView.findViewById(R.id.detailet_des)
        val rating: TextView = itemView.findViewById(R.id.detailet_rating)
    }
}
