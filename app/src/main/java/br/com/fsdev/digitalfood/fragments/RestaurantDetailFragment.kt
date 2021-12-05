package br.com.fsdev.digitalfood.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.DB
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.adapters.PlateAdapter

class RestaurantDetailFragment : Fragment(R.layout.fragment_restaurant_detail) {

    private lateinit var recyclerPlates: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private val plates = DB.getPlates()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manager = LinearLayoutManager(view.context)
        recyclerPlates = view.findViewById(R.id.restaurant_detail_recycler_plates)

        recyclerPlates.layoutManager = manager
        recyclerPlates.adapter = PlateAdapter(plates)

    }

}