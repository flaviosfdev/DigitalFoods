package br.com.fsdev.digitalfood

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import br.com.fsdev.digitalfood.fragments.IntroContent01Fragment
import br.com.fsdev.digitalfood.fragments.IntroContent02Fragment
import br.com.fsdev.digitalfood.fragments.IntroContent03Fragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IllegalArgumentException

class LauncherActivity : AppCompatActivity() {

    private val viewPager: ViewPager2 by lazy { findViewById(R.id.viewpager_launcher) }
    private val indicator: TabLayout by lazy { findViewById(R.id.indicator_launcher) }
    private val buttonNext: Button by lazy { findViewById(R.id.button_next_launcher) }

    private val launcher01Fragment = IntroContent01Fragment()
    private val launcher02Fragment = IntroContent02Fragment()
    private val launcher03Fragment = IntroContent03Fragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        setupViewPager()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                buttonNext.text = "próximo"
                when(position) {
                    2 -> {
                        buttonNext.text = "entendi"
                    }
                }
            }
        })


        buttonNext.setOnClickListener {
            if (buttonNext.text.toString() == "entendi") {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                viewPager.currentItem ++
            }
        }
    }

    private fun setupViewPager() {

        val listFragments = listOf(IntroContent01Fragment(),IntroContent02Fragment(), IntroContent03Fragment())

        viewPager.adapter = IntroAdapter(
            this, listFragments
        )

        TabLayoutMediator(indicator, viewPager) {_, _ -> }.attach()

    }

    class IntroAdapter(
        fragmentManager: FragmentActivity,
        private val views: List<Fragment>
    ) : FragmentStateAdapter(fragmentManager) {

        override fun getItemCount(): Int = views.size

        override fun createFragment(position: Int): Fragment {

            return if (views.isEmpty()) {
                throw IllegalArgumentException("The view's list is empty")
            } else {
                views[position]
            }

        }
    }

}
