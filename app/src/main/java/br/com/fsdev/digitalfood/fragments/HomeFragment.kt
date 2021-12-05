package br.com.fsdev.digitalfood.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.DB
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.adapters.RestaurantAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerRestaurants: RecyclerView
    private lateinit var manager: LinearLayoutManager
    private val restaurants = DB.getRestaurants()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manager = LinearLayoutManager(view.context)
        recyclerRestaurants = view. findViewById(R.id.home_fragment_recycler_restaurants)

        recyclerRestaurants.layoutManager = manager
        recyclerRestaurants.adapter = RestaurantAdapter(restaurants)
    }


}