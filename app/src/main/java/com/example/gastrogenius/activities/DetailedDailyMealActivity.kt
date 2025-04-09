package com.example.gastrogenius.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.example.gastrogenius.R
import com.example.gastrogenius.adapters.DetailedDailyAdapter
import com.example.gastrogenius.models.DetailedDailyModel // <--- ¡CORRECTO!

class DetailedDailyMealActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var imageView: ImageView
    private lateinit var dailyAdapter: DetailedDailyAdapter
    private val detailedDailyModelList = mutableListOf<DetailedDailyModel>() // <--- ¡TIPO CORRECTO!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_daily_meal)

        val type = intent.getStringExtra("type")

        recyclerView = findViewById(R.id.detailet_rec)
        imageView = findViewById(R.id.detailet_img)

        recyclerView.layoutManager = LinearLayoutManager(this)

        dailyAdapter = DetailedDailyAdapter(this, detailedDailyModelList)
        recyclerView.adapter = dailyAdapter

        if (type != null && type.equals("breakfast", ignoreCase = true)) {
            detailedDailyModelList.add(DetailedDailyModel(R.drawable.fav1, "Breakfast", "Descripción", "4.4"))
            detailedDailyModelList.add(DetailedDailyModel(R.drawable.fav2, "Breakfast", "Descripción", "4.4"))
            detailedDailyModelList.add(DetailedDailyModel(R.drawable.fav3, "Breakfast", "Descripción", "4.4"))
            dailyAdapter.notifyDataSetChanged()
        }

        if (type != null && type.equals("sweets", ignoreCase = true)) {
            imageView.setImageResource(R.drawable.s1)
            detailedDailyModelList.add(DetailedDailyModel(R.drawable.s1, "Sweets", "Descripción", "4.4"))
            detailedDailyModelList.add(DetailedDailyModel(R.drawable.s2, "Sweets", "Descripción", "4.4"))
            detailedDailyModelList.add(DetailedDailyModel(R.drawable.s3, "Sweets", "Descripción", "4.4"))
            dailyAdapter.notifyDataSetChanged()
        }
    }
}
