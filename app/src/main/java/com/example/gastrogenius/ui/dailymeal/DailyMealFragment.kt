package com.example.gastrogenius.ui.dailymeal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gastrogenius.R
import com.example.gastrogenius.adapters.DailyMealAdapter
import com.example.gastrogenius.models.DailyMealModel // Corregida la importación

class DailyMealFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dailyMealAdapter: DailyMealAdapter
    private val dailyMealModels = mutableListOf<DailyMealModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.daily_meal_fragment, container, false)

        recyclerView = root.findViewById(R.id.daily_meal_rec)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        dailyMealModels.apply {
            add(DailyMealModel(R.drawable.breakfast, "Sandwich", "Recetas de sandwich", "breakfast"))
            add(DailyMealModel(R.drawable.pizza1, "Pizza", "Recetas de pizza!", "lunch"))
            add(DailyMealModel(R.drawable.burger4, "Hamburgesa", "Recetas de Hamburgesas", "dinner"))
            add(DailyMealModel(R.drawable.icecream1, "Postres", "Resetas de postres", "sweets"))
            add(DailyMealModel(R.drawable.coffe, "Coffee", "Recetas de  coffee!", "coffee")) // Corregido el ID
        }

        dailyMealAdapter = DailyMealAdapter(requireContext(), dailyMealModels)
        recyclerView.adapter = dailyMealAdapter

        return root
    }
}
