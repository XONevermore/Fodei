package uz.mymax.fodei.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog
import uz.mymax.fodei.R

class RegistrationPageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_registration_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnShowRegisterSheet = view.findViewById<Button>(R.id.register)

        btnShowRegisterSheet.setOnClickListener {
            val fragment = RegosterLoginFragment()
            fragment.show(childFragmentManager, "add_to_album")
        }

        val btnShowLoginSheet = view.findViewById<Button>(R.id.login)

        btnShowLoginSheet.setOnClickListener {

            val fragment = RegosterLoginFragment()
            fragment.show(childFragmentManager, "add_to_album")

        }
    }
}