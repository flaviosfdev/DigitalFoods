package br.com.fsdev.digitalfood.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.DB
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.models.Banner
import com.squareup.picasso.Picasso

class BannerAdapter(val context: Context) : RecyclerView.Adapter<BannerAdapter.BannerViewHolder>() {

    val listBanner: List<Banner> = DB.getBanners()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = BannerViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)
    )

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(listBanner[position])
    }

    override fun getItemCount(): Int = listBanner.size

    inner class BannerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgBanner: ImageView = itemView.findViewById(R.id.img_item_rv_banner)

        fun bind(banner: Banner) {
            Picasso.get()
                .load(banner.imgBanner)
                .placeholder(R.drawable.loading)
                .resize(300, 140)
                .centerCrop()
                .into(imgBanner)
        }

    }
}