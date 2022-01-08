package uz.mymax.fodei.ui.mainpage.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.mymax.fodei.ui.mainpage.pages.HistoryFragment
import uz.mymax.fodei.ui.mainpage.pages.HomePageFragment
import uz.mymax.fodei.ui.mainpage.pages.ProfileFragment
import uz.mymax.fodei.ui.onboarding.pages.CheapOnboardingFragmant
import uz.mymax.fodei.ui.onboarding.pages.FavoriteOnboardingFragmant
import uz.mymax.fodei.ui.onboarding.pages.NearbyOnboardingFragmant

class MainPageViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomePageFragment()
            }
            1 -> {
                HistoryFragment()
            }
            2 -> {
                ProfileFragment()
            }

            else -> {
                HomePageFragment()
            }
        }

    }


}