package uz.mymax.fodei.ui.onboarding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class OnBoardingViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                NearbyOnboardingFragmant.newInstance()
            }
            1 -> {
                FavoriteOnboardingFragmant.newInstance()
            }
            2 -> {
                CheapOnboardingFragmant.newInstance()
            }

            else -> {
                NearbyOnboardingFragmant.newInstance()
            }
        }

    }


}