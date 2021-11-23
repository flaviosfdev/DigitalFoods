package br.com.fsdev.digitalfood.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout.HORIZONTAL
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fsdev.digitalfood.R
import br.com.fsdev.digitalfood.adapters.BannerAdapter
import br.com.fsdev.digitalfood.adapters.CategoriaAdapter

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var recyclerBanners: RecyclerView
    private lateinit var recyclerCategorias: RecyclerView
    private lateinit var recyclerOfertas: RecyclerView
    private lateinit var manager: LinearLayoutManager

    @SuppressLint("WrongConstant")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        manager = LinearLayoutManager(view.context, HORIZONTAL, false)
        initViews(view)
        initRecyclers(view)

    }

    private fun initViews(v: View) {
        recyclerBanners = v.findViewById(R.id.recycler_homefrag_banners)
        recyclerCategorias = v.findViewById(R.id.recycler_homefrag_categorias)
        recyclerOfertas = v.findViewById(R.id.recycler_homefrag_ofertas)
    }


    @SuppressLint("WrongConstant")
    private fun initRecyclers(v: View) {

        recyclerBanners.layoutManager = LinearLayoutManager(v.context, HORIZONTAL, false)
        recyclerBanners.adapter = BannerAdapter(v.context)

        recyclerCategorias.layoutManager = LinearLayoutManager(v.context, HORIZONTAL, false)
        recyclerCategorias.adapter = CategoriaAdapter(v.context)

        //recyclerOfertas.layoutManager = manager
        //recyclerOfertas.adapter = OfertaAdapter(v.context)
    }

}