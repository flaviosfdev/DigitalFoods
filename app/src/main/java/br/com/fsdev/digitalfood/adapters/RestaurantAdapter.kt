package br.com.fsdev.digitalfood.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.models.Restaurant
import com.bumptech.glide.Glide

class RestaurantAdapter(val restaurantList: List<Restaurant>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is RestaurantViewHolder -> { holder.bind(restaurantList[position]) }
        }

    }

    override fun getItemCount(): Int = restaurantList.size

}

class RestaurantViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image: ImageView = view.findViewById(R.id.item_restaurant_image)
    private val name: TextView = view.findViewById(R.id.item_restaurant_name)
    private val address: TextView = view.findViewById(R.id.item_restaurant_address)
    private val shutdown: TextView = view.findViewById(R.id.item_restaurant_shutdown)

    fun bind(item: Restaurant) {
        name.text = item.name
        address.text = item.address
        shutdown.text = item.shutdown

        Glide.with(image.context).load(item.image).into(image)
    }
}