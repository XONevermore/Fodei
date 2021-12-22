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


class OnboardingFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<ImageView>(R.id.next)
        val skipButton = view.findViewById<TextView>(R.id.skip)
        val vpAdapter = OnBoardingViewPagerAdapter(parentFragmentManager, lifecycle)
        val viewPager = view.findViewById<ViewPager2>(R.id.vpOnboarding)
        viewPager.adapter= vpAdapter
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

        }.attach()
        button.setOnClickListener {
            if(viewPager.currentItem<2){
                viewPager.currentItem = viewPager.currentItem+1
            }else{
                view.findNavController()
                    .navigate(R.id.action_onboardingFragment_to_registrationPageFragment)
            }

        }
        skipButton.setOnClickListener {
            view.findNavController()
                .navigate(R.id.action_onboardingFragment_to_registrationPageFragment)

        }
        viewPager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(position: Int,
                                        positionOffset: Float,
                                        positionOffsetPixels: Int) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                when (position){
                    0 -> {
                        skipButton.visibility = View.VISIBLE
                    }
                    1 -> {
                        skipButton.visibility = View.VISIBLE
                    }
                    2 -> {
                        skipButton.visibility = View.INVISIBLE
                    }
                    else -> {
                        skipButton.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}
