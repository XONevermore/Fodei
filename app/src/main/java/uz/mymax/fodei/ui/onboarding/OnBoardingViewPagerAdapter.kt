package uz.mymax.fodei.ui.onboarding

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.mymax.fodei.R

class OnBoardingViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = 3
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return NearbyOnboardingFragmant.newInstance()
            }
            1 -> {
                return FavoriteOnboardingFragmant.newInstance()
            }
            2 -> {
                return CheapOnboardingFragmant.newInstance()
            }

            else -> {
                return NearbyOnboardingFragmant.newInstance()
            }
        }

    }


}