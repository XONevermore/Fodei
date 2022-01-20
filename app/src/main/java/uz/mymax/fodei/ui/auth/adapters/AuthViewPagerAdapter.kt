package uz.mymax.fodei.ui.auth.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.mymax.fodei.ui.auth.pages.LoginFragment
import uz.mymax.fodei.ui.auth.pages.RegistrationFragment

class AuthViewPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                RegistrationFragment()
            }
            1 -> {
                LoginFragment()
            }
            else -> {
                RegistrationFragment()
            }
        }

    }
}