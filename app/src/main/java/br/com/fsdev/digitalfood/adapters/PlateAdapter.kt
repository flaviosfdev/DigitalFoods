package br.com.fsdev.digitalfood.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.models.Plate
import com.bumptech.glide.Glide

class PlateAdapter(val platesList: List<Plate>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PlateViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plate,parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is PlateViewHolder -> {
                holder.bindPlate(platesList[position])
            }
        }
    }

    override fun getItemCount(): Int = platesList.size
}

class PlateViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val image: ImageView = view.findViewById(R.id.item_plate_image)
    private val name: TextView = view.findViewById(R.id.item_plate_name)
    private val description: TextView = view.findViewById(R.id.item_plate_description)

    fun bindPlate(item: Plate) {
        name.text = item.name
        description.text = item.description

        Glide.with(image.context).load(item.image).into(image)
    }

}