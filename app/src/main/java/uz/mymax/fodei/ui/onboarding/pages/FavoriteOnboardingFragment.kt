package uz.mymax.fodei.ui.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentFavoriteOnboardingFragmantBinding


class FavoriteOnboardingFragmant : Fragment() {
    private lateinit var binding: FragmentFavoriteOnboardingFragmantBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteOnboardingFragmantBinding.inflate(layoutInflater)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FavoriteOnboardingFragmant()
    }
}