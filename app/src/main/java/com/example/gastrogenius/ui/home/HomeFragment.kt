package com.example.gastrogenius.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gastrogenius.R
import com.example.gastrogenius.adapters.HomeHorAdapter
import com.example.gastrogenius.adapters.HomeVerAdapter
import com.example.gastrogenius.adapters.UpdateVerticalRec
import com.example.gastrogenius.models.HomeHorModel
import com.example.gastrogenius.models.HomeVerModel

class HomeFragment : Fragment(), UpdateVerticalRec {

    private lateinit var homeHorizontalRec: RecyclerView
    private lateinit var homeVerticalRec: RecyclerView

    private lateinit var homeHorAdapter: HomeHorAdapter
    private lateinit var homeVerAdapter: HomeVerAdapter

    private val homeHorModelList = ArrayList<HomeHorModel>()
    private val homeVerModelList = ArrayList<HomeVerModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Inicializar RecyclerViews
        homeHorizontalRec = view.findViewById(R.id.home_hor_rec)
        homeVerticalRec = view.findViewById(R.id.home_ver_rec)

        // Agregar elementos a la lista horizontal
        homeHorModelList.apply {
            add(HomeHorModel(R.drawable.ensalada, "Ensalada"))
            add(HomeHorModel(R.drawable.salmon, "Salmón"))
            add(HomeHorModel(R.drawable.pizza1, "Pizza"))
            add(HomeHorModel(R.drawable.burger1, "Hamburguesa"))
        }
        homeVerModelList.apply {
            add(HomeVerModel(R.drawable.burger2, "Hamburguesa", "4.8"))
            add(HomeVerModel(R.drawable.burger4, "Hamburguesa", "4.7"))
            add(HomeVerModel(R.drawable.pizza3, "Pizza", "5.0"))
        }

        // Configurar Adapter Vertical con `updateData()`
        homeVerAdapter = HomeVerAdapter(requireContext(), homeVerModelList)
        homeVerticalRec.adapter = homeVerAdapter
        homeVerticalRec.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        homeVerticalRec.setHasFixedSize(true)
        homeVerticalRec.isNestedScrollingEnabled = false

        // Configurar Adapter Horizontal con `UpdateVerticalRec`
        homeHorAdapter = HomeHorAdapter(homeHorModelList, requireActivity(), this) // Aquí se pasa `this` para la interfaz
        homeHorizontalRec.adapter = homeHorAdapter
        homeHorizontalRec.layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
        homeHorizontalRec.setHasFixedSize(true)
        homeHorizontalRec.isNestedScrollingEnabled = false

        // Agregar log para verificar que los datos se están cargando correctamente
        Log.d("HomeFragment", "HomeHorModelList size: ${homeHorModelList.size}")
        Log.d("HomeFragment", "HomeVerModelList size: ${homeVerModelList.size}")

        return view
    }

    override fun callBack(position: Int, list: ArrayList<HomeVerModel>) {
        // Actualizar datos en el adaptador
        homeVerAdapter.updateData(list)
        homeVerAdapter.notifyDataSetChanged()

        // Establecer el adaptador actualizado en el RecyclerView vertical
        homeVerticalRec.adapter = homeVerAdapter
    }
}
