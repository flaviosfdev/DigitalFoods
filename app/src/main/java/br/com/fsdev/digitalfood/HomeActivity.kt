package br.com.fsdev.digitalfood

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.adapters.RestaurantAdapter
import br.com.fsdev.digitalfood.models.Restaurant

class HomeActivity : AppCompatActivity(R.layout.activity_home) {

    private val recyclerRestaurants: RecyclerView by lazy {
        findViewById(R.id.home_activity_recycler_restaurants)
    }
    private lateinit var restaurantAdapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        restaurantAdapter = RestaurantAdapter(
            { restaurant -> navToRestaurantDetail(restaurant) },
            { title -> onTitleClicked(title) }
        )

        recyclerRestaurants.apply {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            adapter = restaurantAdapter
        }

    }

    private fun navToRestaurantDetail(restaurant: Restaurant) {
        val intent = Intent(this, RestaurantDetailActivity::class.java)
        intent.putExtra("IMG", restaurant.image)
        intent.putExtra("NAME", restaurant.name)
        intent.putExtra("ADDRESS", restaurant.address)
        intent.putExtra("SHUTDOWN", restaurant.shutdown)
        startActivity(intent)
    }

    private fun onTitleClicked(title: String) {
        showToast(title)
    }


    private fun showToast(message: String) {
        Toast.makeText(this , message, Toast.LENGTH_SHORT).show()
    }
}