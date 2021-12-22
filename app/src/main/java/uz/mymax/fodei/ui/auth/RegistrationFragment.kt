package uz.mymax.fodei.ui.auth

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import uz.mymax.fodei.R
import uz.mymax.fodei.ui.onboarding.pages.NearbyOnboardingFragmant


class RegistrationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val emailInput = view.findViewById<EditText>(R.id.etEmail)
        val fullNameInput = view.findViewById<EditText>(R.id.full_name_input)
        val passwordInput = view.findViewById<EditText>(R.id.etPassword)
        val emailHeader = view.findViewById<TextView>(R.id.tvEmailLabel)
        val fullNameHeader = view.findViewById<TextView>(R.id.full_name_header)
        val passwordHeader = view.findViewById<TextView>(R.id.tvPasswordLabel)
        val register = view.findViewById<Button>(R.id.do_register)
        emailInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    register.isEnabled = false
                } else {
                    if(fullNameInput.text.toString().isNotEmpty() and passwordInput.text.toString().isNotEmpty()){
                        register.isEnabled = true
                        register.setTextColor(-0x1)
                        register.background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                    }

                }
                if(!TextUtils.isEmpty(s) && android.util.Patterns.EMAIL_ADDRESS.matcher(s).matches()){
                    emailHeader?.setTextColor(ContextCompat.getColor(requireContext(),R.color.text_color))
                }else{
                    emailHeader?.setTextColor(Color.RED)
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {}

            override fun afterTextChanged(s: Editable) {}
        })
        fullNameInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    register.isEnabled = false
                } else {
                    if(emailInput.text.toString().isNotEmpty() and passwordInput.text.toString().isNotEmpty()){
                        register.isEnabled = true
                        register.setTextColor(-0x1)
                        register.background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                    }

                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {}

            override fun afterTextChanged(s: Editable) {}
        })
        passwordInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    register.isEnabled = false
                } else {
                    if(fullNameInput.text.toString().isNotEmpty() and emailInput.text.toString().isNotEmpty()){
                        register.isEnabled = true
                        register.setTextColor(-0x1)
                        register.background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                    }

                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {}

            override fun afterTextChanged(s: Editable) {}
        })
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            NearbyOnboardingFragmant()
    }
}