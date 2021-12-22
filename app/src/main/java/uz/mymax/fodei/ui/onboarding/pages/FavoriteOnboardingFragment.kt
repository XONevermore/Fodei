package uz.mymax.fodei.ui.onboarding.pages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.mymax.fodei.R


class FavoriteOnboardingFragmant : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_onboarding_fragmant, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            FavoriteOnboardingFragmant()
    }
}