package uz.mymax.fodei.ui.auth

import android.app.Dialog
import android.os.Binder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.BottomSheetAuthBinding
import uz.mymax.fodei.databinding.FragmentOnboardingBinding
import uz.mymax.fodei.ui.onboarding.pages.NearbyOnboardingFragmant

class AuthBottomSheetDialogFragment : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetAuthBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = BottomSheetAuthBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vpAdapter = AuthViewPagerAdapter(parentFragmentManager, lifecycle)
        binding.vpAuth.adapter = vpAdapter
        TabLayoutMediator(binding.tabAuth, binding.vpAuth) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Create Account"
                }
                else -> {
                    tab.text = "Login"
                }
            }
        }.attach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener {
            val dialog = it as BottomSheetDialog
            val bottomSheet =
                dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheet!!).state = BottomSheetBehavior.STATE_EXPANDED
        }
        return bottomSheetDialog
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NearbyOnboardingFragmant()
    }
}