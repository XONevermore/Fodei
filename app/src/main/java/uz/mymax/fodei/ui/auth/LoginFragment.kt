package uz.mymax.fodei.ui.auth

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentLoginBinding
import uz.mymax.fodei.ui.onboarding.pages.NearbyOnboardingFragmant

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvForgetPassword.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordFragment)
        }
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.btnLogin.isEnabled = false
                } else {
                    if (binding.etPassword.text.toString().isNotEmpty()) {
                        binding.btnLogin.isEnabled = true
                        binding.btnLogin.setTextColor(-0x1)
                        binding.btnLogin.background =
                            ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                    }
                }
                if (!TextUtils.isEmpty(s) && android.util.Patterns.EMAIL_ADDRESS.matcher(s)
                        .matches()
                ) {
                    binding.tvEmailLabel.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.text_color
                        )
                    )
                } else {
                    binding.tvEmailLabel.setTextColor(Color.RED)
                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.btnLogin.isEnabled = false
                } else {
                    if (binding.etEmail.text.toString().isNotEmpty()) {
                        binding.btnLogin.isEnabled = true
                        binding.btnLogin.setTextColor(-0x1)
                        binding.btnLogin.background =
                            ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                    }

                }
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            NearbyOnboardingFragmant()
    }
}