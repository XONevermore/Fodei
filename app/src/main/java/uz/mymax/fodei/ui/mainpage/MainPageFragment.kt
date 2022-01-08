package uz.mymax.fodei.ui.mainpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentMainPageBinding
import uz.mymax.fodei.ui.mainpage.adapters.MainPageViewPagerAdapter

class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainPageBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vpAdapter = MainPageViewPagerAdapter(parentFragmentManager, lifecycle)
        binding.vpMainPage.adapter = vpAdapter
        binding.vpMainPage.isUserInputEnabled = false
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {

                when(tab!!.position){
                    0 -> {
                        tab.setIcon(R.drawable.selected_home)
                    }
                    1 -> {
                        tab.setIcon(R.drawable.selected_history)
                    }
                    2 -> {
                        tab.setIcon(R.drawable.selected_profile)
                    }
                    else -> {
                        tab.setIcon(R.drawable.selected_home)
                    }
                }

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when(tab!!.position){
                    0 -> {
                        tab.setIcon(R.drawable.home)
                    }
                    1 -> {
                        tab.setIcon(R.drawable.history)
                    }
                    2 -> {
                        tab.setIcon(R.drawable.profile)
                    }
                    else -> {
                        tab.setIcon(R.drawable.home)
                    }
                }
            }


        })

        TabLayoutMediator(tabLayout, binding.vpMainPage) { tab, position ->
            when(position){
                0 -> {
                    tab.setIcon(R.drawable.home)
                }
                1->{
                    tab.setIcon(R.drawable.history)
                }
                2->{
                    tab.setIcon(R.drawable.profile)
                }
                else -> {
                    tab.setIcon(R.drawable.home)
                }
            }
        }.attach()
    }
}