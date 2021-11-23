package br.com.fsdev.digitalfood

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import br.com.fsdev.digitalfood.fragments.Launcher01Fragment
import br.com.fsdev.digitalfood.fragments.Launcher02Fragment
import br.com.fsdev.digitalfood.fragments.Launcher03Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class LauncherActivity : AppCompatActivity() {

    private lateinit var launcherTabs: TabLayout
    private lateinit var launcherPager: ViewPager2
    private lateinit var launcherButton: Button

    private val launcher01Fragment = Launcher01Fragment()
    private val launcher02Fragment = Launcher02Fragment()
    private val launcher03Fragment = Launcher03Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        initViews()
        initPager()
        initTabs(launcherTabs, launcherPager)

    }

    private fun initTabs(tabs: TabLayout, pager: ViewPager2) {

        TabLayoutMediator(tabs, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "1"
                }
                1 -> {
                    tab.text = "2"
                }
                2 -> {
                    tab.text = "3"
                }
            }

        }

    }

    private fun initPager() {

        launcherPager.adapter = PagerLauncherAdapter(this)

    }

    private fun initViews() {
        launcherTabs = findViewById(R.id.launcher_tablayout)
        launcherPager = findViewById(R.id.pager_launcher)
        launcherButton = findViewById(R.id.launcher_button_proximo)
    }



    private inner class PagerLauncherAdapter(fragmentActivity: FragmentActivity)
        : FragmentStateAdapter(fragmentActivity) {

        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> { launcher01Fragment }
                1 -> { launcher02Fragment }
                else -> { launcher03Fragment }
            }
        }
    }

}
