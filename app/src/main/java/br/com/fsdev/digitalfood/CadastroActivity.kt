package br.com.fsdev.digitalfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import br.com.fsdev.digitalfood.fragments.CadastroRestauranteFragment
import br.com.fsdev.digitalfood.fragments.CadastroUsuarioFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class CadastroActivity : AppCompatActivity() {

    private lateinit var pagerCadastro: ViewPager2
    private lateinit var tabLayoutCadastro: TabLayout
    private val cadastroUsuarioFragment = CadastroUsuarioFragment()
    private val cadastroRestauranteFragment = CadastroRestauranteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        tabLayoutCadastro = findViewById(R.id.tablayout_cadastro)

        pagerCadastro = findViewById(R.id.pager_cadastro)
        pagerCadastro.adapter = PagerCadastroAdapter(this)

        TabLayoutMediator(tabLayoutCadastro, pagerCadastro) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "USUÁRIO"
                }
                1 -> {
                    tab.text = "RESTAURANTE"
                }
            }
        }.attach()
    }

    private inner class PagerCadastroAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> cadastroUsuarioFragment
                else -> cadastroRestauranteFragment
            }
        }

    }


}
