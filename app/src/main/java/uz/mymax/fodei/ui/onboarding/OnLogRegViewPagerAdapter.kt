package uz.mymax.fodei.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnLogRegViewPagerAdapter (fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
        override fun getItemCount() = 2
        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> {
                    RegFragment()
                }
                1 -> {
                    LogFragment()
                }

                else -> {
                    RegFragment()
                }
            }

        }
}