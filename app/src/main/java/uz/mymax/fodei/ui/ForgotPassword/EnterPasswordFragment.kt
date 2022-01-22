package uz.mymax.fodei.ui.ForgotPassword

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentEnterPasswordBinding

class EnterPasswordFragment : Fragment() {
    private lateinit var binding: FragmentEnterPasswordBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEnterPasswordBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnReset.setOnClickListener {
            findNavController().navigate(R.id.passwordSuccessResetFragment)
        }
        binding.etNewPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.btnReset.isEnabled = false
                } else if(binding.etConfirmPassword.text.toString().isNotEmpty()){
                    binding.btnReset.isEnabled = true
                    binding.btnReset.setTextColor(-0x1)
                    binding.btnReset.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                }
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

        binding.etConfirmPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.isEmpty()) {
                    binding.btnReset.isEnabled = false
                } else if(binding.etNewPassword.text.toString().isNotEmpty()){
                    binding.btnReset.isEnabled = true
                    binding.btnReset.setTextColor(-0x1)
                    binding.btnReset.background =
                        ContextCompat.getDrawable(requireContext(), R.drawable.round_button)
                }
                if(s.toString() == binding.etNewPassword.text.toString()){
                    binding.tvConfirmPassword.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.DarkGrey
                        )
                    )
                }else{
                    binding.tvConfirmPassword.setTextColor(Color.RED)
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