package uz.mymax.fodei.ui.ForgotPassword

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
import uz.mymax.fodei.databinding.FragmentForgotPasswordBinding

class ForgotPasswordFragment : Fragment() {
    private lateinit var binding: FragmentForgotPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            findNavController().navigate(R.id.emailSuccessFragment)
        }

        binding.tvSignIn.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.btnSubmit.isEnabled = false
                } else {
                    binding.btnSubmit.isEnabled = true
                    binding.btnSubmit.setTextColor(-0x1)
                    binding.btnSubmit.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                }
                if (!TextUtils.isEmpty(s) && android.util.Patterns.EMAIL_ADDRESS.matcher(s)
                        .matches()
                ) {
                    binding.tvEmailLabel.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.DarkGrey
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
    }
}