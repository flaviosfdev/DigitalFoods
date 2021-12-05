package br.com.fsdev.digitalfood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import br.com.fsdev.digitalfood.R


class IntroContent03Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view: View? = inflater.inflate(R.layout.fragment_launcher, container, false)

        when (view) {
            null -> {

            }

            else -> {

                view.findViewById<ImageView>(R.id.launcher_frag_img)
                    .setImageDrawable(resources.getDrawable(R.drawable.ic_ilustra_3))

                view.findViewById<TextView>(R.id.launcher_frag_titulo)
                    .text = "Receba onde estiver"

                view.findViewById<TextView>(R.id.launcher_frag_subtitulo)
                    .text = "Nossa equipe de entrega leva sua refeição quentinha."

            }


        }

        return view
    }

}