package com.example.gastrogenius.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gastrogenius.R
import com.example.gastrogenius.adapters.HomeHorAdapter
import com.example.gastrogenius.adapters.HomeVerAdapter
import com.example.gastrogenius.models.HomeHorModel
import com.example.gastrogenius.models.HomeVerModel

class HomeFragment : Fragment() {

    private lateinit var homeHorizontalRec: RecyclerView
    private lateinit var homeVerticalRec: RecyclerView
    private lateinit var homeHorAdapter: HomeHorAdapter
    private lateinit var homeVerAdapter: HomeVerAdapter

    private val homeHorModelList = mutableListOf<HomeHorModel>()
    private val homeVerModelList = mutableListOf<HomeVerModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Inicializar RecyclerViews
        homeHorizontalRec = view.findViewById(R.id.home_hor_rec)
        homeVerticalRec = view.findViewById(R.id.home_ver_rec)

        // Agregar elementos a la lista horizontal
        homeHorModelList.add(HomeHorModel(R.drawable.ensalada, "Ensalada"))
        homeHorModelList.add(HomeHorModel(R.drawable.salmon, "Salmon"))
        homeHorModelList.add(HomeHorModel(R.drawable.pizza1, "Pizza"))
        homeHorModelList.add(HomeHorModel(R.drawable.burger1, "Hamburguesa"))

        // Configurar Adapter Horizontal
        homeHorAdapter = HomeHorAdapter(requireContext(), homeHorModelList)
        homeHorizontalRec.adapter = homeHorAdapter
        homeHorizontalRec.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        homeHorizontalRec.setHasFixedSize(true)
        homeHorizontalRec.isNestedScrollingEnabled = false

        // Agregar elementos a la lista vertical
        homeVerModelList.add(HomeVerModel(R.drawable.burger2, "Hamburguesa", "4.8"))
        homeVerModelList.add(HomeVerModel(R.drawable.burger4, "Hamburguesa", "4.7"))
        homeVerModelList.add(HomeVerModel(R.drawable.pizza3, "Pizza", "5.0"))

        // Configurar Adapter Vertical
        homeVerAdapter = HomeVerAdapter(requireContext(), homeVerModelList)
        homeVerticalRec.adapter = homeVerAdapter
        homeVerticalRec.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        homeVerticalRec.setHasFixedSize(true)
        homeVerticalRec.isNestedScrollingEnabled = false

        return view
    }
}

