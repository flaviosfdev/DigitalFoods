package br.com.fsdev.digitalfood

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.adapters.PlateAdapter
import com.bumptech.glide.Glide

class RestaurantDetailActivity : AppCompatActivity(R.layout.activity_restaurant_detail) {

    private val recyclerPlates: RecyclerView by lazy { findViewById(R.id.restaurant_detail_recycler_plates) }
    private val restaurantImage: ImageView by lazy { findViewById(R.id.restaurant_detail_image) }

    private val plates = DB.getMenu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getExtras()
        initRecycler()
    }

    private fun getExtras() {
        val extras = intent.extras
        Glide
            .with(this)
            .load(extras?.getString("IMG"))
            .into(restaurantImage)
    }

    private fun initRecycler() {
        recyclerPlates.apply {
            layoutManager = GridLayoutManager(this@RestaurantDetailActivity,2)
            adapter = PlateAdapter(plates)
        }
    }

}
