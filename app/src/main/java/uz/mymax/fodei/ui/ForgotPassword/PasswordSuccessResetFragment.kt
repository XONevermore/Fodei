package uz.mymax.fodei.ui.ForgotPassword

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentPasswordSuccessResetBinding

class PasswordSuccessResetFragment : Fragment() {
    private lateinit var binding: FragmentPasswordSuccessResetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPasswordSuccessResetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lottieCorrect.playAnimation()
        binding.lottieCorrect.loop(false)
        binding.btnBackEmail.setOnClickListener {
            findNavController().navigate(R.id.mainPageFragment)
        }
    }
}