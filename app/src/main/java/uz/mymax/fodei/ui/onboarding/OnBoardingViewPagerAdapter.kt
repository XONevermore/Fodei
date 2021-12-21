package uz.mymax.fodei.ui.onboarding

import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.mymax.fodei.R

class OnBoardingViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle, skip: TextView) :
    FragmentStateAdapter(fm, lifecycle) {
    override fun getItemCount() = 3
    val skip_buuton = skip
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                skip_buuton.visibility = View.VISIBLE
                return NearbyOnboardingFragmant.newInstance()
            }
            1 -> {
                skip_buuton.visibility = View.VISIBLE
                return FavoriteOnboardingFragmant.newInstance()
            }
            2 -> {
                skip_buuton.visibility = View.INVISIBLE
                return CheapOnboardingFragmant.newInstance()
            }

            else -> {
                skip_buuton.visibility = View.VISIBLE
                return NearbyOnboardingFragmant.newInstance()
            }
        }

    }


}