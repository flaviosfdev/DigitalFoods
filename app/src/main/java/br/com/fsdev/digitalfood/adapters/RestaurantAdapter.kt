package br.com.fsdev.digitalfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.DB
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.models.Restaurant
import com.bumptech.glide.Glide

class RestaurantAdapter(
    private val onItemClicked: (Restaurant) -> Unit,
    private val onTitleClicked: (String) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val restaurantList: List<Restaurant> = DB.getRestaurants()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder) {
            is RestaurantViewHolder -> {
                holder.bind(restaurantList[position],
                    onItemClicked,
                    onTitleClicked
                )
            }
        }

    }

    override fun getItemCount(): Int = restaurantList.size

}

class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val image: ImageView = itemView.findViewById(R.id.item_restaurant_image)
    private val name: TextView = itemView.findViewById(R.id.item_restaurant_name)
    private val address: TextView = itemView.findViewById(R.id.item_restaurant_address)
    private val shutdown: TextView = itemView.findViewById(R.id.item_restaurant_shutdown)

    fun bind(
        item: Restaurant,
        onItemClicked: (Restaurant) -> Unit,
        onTitleClicked: (String) -> Unit
    ) {
        name.text = item.name
        address.text = item.address
        shutdown.text = item.shutdown

        Glide.with(image.context).load(item.image).into(image)

        itemView.setOnClickListener {
            onItemClicked(item)
        }

        name.setOnClickListener {
            onTitleClicked(name.text.toString())
        }

    }
}