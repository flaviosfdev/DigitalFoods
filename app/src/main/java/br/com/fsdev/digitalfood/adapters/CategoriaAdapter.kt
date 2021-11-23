package br.com.fsdev.digitalfood.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.DB
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.models.Categoria
import com.squareup.picasso.Picasso

class CategoriaAdapter(val context: Context): RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {

    val listCategoria: List<Categoria> = DB.getCategorias()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoriaViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_categoria, parent, false)
    )

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.bind(listCategoria[position])
    }

    override fun getItemCount(): Int = listCategoria.size

    inner class CategoriaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nomeCategoria: TextView = itemView.findViewById(R.id.text_item_rv_categoria_nome)
        val imagemCategoria: ImageView = itemView.findViewById(R.id.img_item_rv_categoria)

        fun bind(categoria: Categoria) {
            nomeCategoria.text = categoria.nome
            Picasso.get()
                .load(categoria.imagem)
                .placeholder(R.drawable.loading)
                .resize(100, 80)
                .centerCrop()
                .into(imagemCategoria)
        }
    }

}