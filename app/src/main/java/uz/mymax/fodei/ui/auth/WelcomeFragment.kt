package uz.mymax.fodei.ui.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import uz.mymax.fodei.R
import uz.mymax.fodei.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.register.setOnClickListener {
            val fragment = AuthBottomSheetDialogFragment()
            fragment.show(childFragmentManager, "add_to_album")
        }

        binding.login.setOnClickListener {

            val fragment = AuthBottomSheetDialogFragment()
            fragment.show(childFragmentManager, "add_to_album")

        }
    }
}