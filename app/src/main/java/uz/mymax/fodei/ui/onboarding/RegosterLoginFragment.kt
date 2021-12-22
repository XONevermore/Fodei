package uz.mymax.fodei.ui.onboarding

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import uz.mymax.fodei.R

class RegosterLoginFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration_sheet_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vpAdapter = OnLogRegViewPagerAdapter(parentFragmentManager, lifecycle)
        val viewPager = view.findViewById<ViewPager2>(R.id.vpLogReg)
        viewPager.adapter= vpAdapter
        val tabLayout = view.findViewById<TabLayout>(R.id.log_reg_tab_layout)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position){
                0 -> {tab.text = "Create Account"}
                else -> {tab.text = "Login"}
            }
        }.attach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog
        bottomSheetDialog.setOnShowListener {
            val dialog = it as BottomSheetDialog
            val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
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