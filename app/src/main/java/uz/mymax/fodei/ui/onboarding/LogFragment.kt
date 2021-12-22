package uz.mymax.fodei.ui.onboarding

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import uz.mymax.fodei.R

class LogFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_log, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val emailInput = view.findViewById<EditText>(R.id.email_input)
        val passwordInput = view.findViewById<EditText>(R.id.password_input)
        val emailHeader = view.findViewById<TextView>(R.id.email_header)
        val passwordHeader = view.findViewById<TextView>(R.id.password_header)
        val login = view.findViewById<Button>(R.id.do_login)
        emailInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    login.isEnabled = false
                } else {
                    if(passwordInput.text.toString().isNotEmpty()){
                        login.isEnabled = true
                        login.setTextColor(-0x1)
                        login.background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
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

        passwordInput.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    login.isEnabled = false
                } else {
                    if(emailInput.text.toString().isNotEmpty()){
                        login.isEnabled = true
                        login.setTextColor(-0x1)
                        login.background = ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
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