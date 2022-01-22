package uz.mymax.fodei.ui.auth.pages

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentRegistrationBinding


class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.doRegister.isEnabled = false
                } else {
                    if (binding.etFullName.text.toString()
                            .isNotEmpty() and binding.etPassword.text.toString().isNotEmpty()
                    ) {
                        binding.doRegister.isEnabled = true
                        binding.doRegister.setTextColor(-0x1)
                        binding.doRegister.background =
                            ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                    }

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
        binding.etFullName.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.doRegister.isEnabled = false
                } else {
                    if (binding.etEmail.text.toString()
                            .isNotEmpty() and binding.etPassword.text.toString().isNotEmpty()
                    ) {
                        binding.doRegister.isEnabled = true
                        binding.doRegister.setTextColor(-0x1)
                        binding.doRegister.background =
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
        binding.etPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.doRegister.isEnabled = false
                } else {
                    if (binding.etFullName.text.toString()
                            .isNotEmpty() and binding.etEmail.text.toString().isNotEmpty()
                    ) {
                        binding.doRegister.isEnabled = true
                        binding.doRegister.setTextColor(-0x1)
                        binding.doRegister.background =
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
            RegistrationFragment()
    }
}