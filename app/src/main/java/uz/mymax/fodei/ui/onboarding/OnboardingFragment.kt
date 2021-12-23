package uz.mymax.fodei.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentForgotPasswordBinding
import uz.mymax.fodei.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {
    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnboardingBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vpAdapter = OnBoardingViewPagerAdapter(parentFragmentManager, lifecycle)
        binding.vpOnboarding.adapter = vpAdapter
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, binding.vpOnboarding) { tab, position ->

        }.attach()
        binding.btnNext.setOnClickListener {
            if (binding.vpOnboarding.currentItem < 2) {
                binding.vpOnboarding.currentItem = binding.vpOnboarding.currentItem + 1
            } else {
                view.findNavController()
                    .navigate(R.id.action_onboardingFragment_to_registrationPageFragment)
            }

        }
        binding.tvSkip.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_onboardingFragment_to_registrationPageFragment)

        }
        binding.vpOnboarding.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                when (position) {
                    0 -> {
                        binding.tvSkip.visibility = View.VISIBLE
                    }
                    1 -> {
                        binding.tvSkip.visibility = View.VISIBLE
                    }
                    2 -> {
                        binding.tvSkip.visibility = View.INVISIBLE
                    }
                    else -> {
                        binding.tvSkip.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}
