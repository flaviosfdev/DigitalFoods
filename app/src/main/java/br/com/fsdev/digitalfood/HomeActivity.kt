package br.com.fsdev.digitalfood

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import br.com.fsdev.digitalfood.fragments.HomeFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<HomeFragment>(R.id.home_fragment_container_view)
        }
    }

}