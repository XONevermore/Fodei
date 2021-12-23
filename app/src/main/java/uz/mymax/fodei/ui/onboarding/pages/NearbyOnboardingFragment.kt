package uz.mymax.fodei.ui.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentFavoriteOnboardingFragmantBinding
import uz.mymax.fodei.databinding.FragmentNearbyOnboardingFragmantBinding


class NearbyOnboardingFragmant : Fragment() {
    private lateinit var binding: FragmentNearbyOnboardingFragmantBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNearbyOnboardingFragmantBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NearbyOnboardingFragmant()
    }
}