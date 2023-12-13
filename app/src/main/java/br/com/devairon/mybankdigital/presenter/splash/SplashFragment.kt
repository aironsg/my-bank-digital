package br.com.devairon.mybankdigital.presenter.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.devairon.mybankdigital.R
import br.com.devairon.mybankdigital.databinding.FragmentSplashBinding
import br.com.devairon.mybankdigital.utils.helper.FirebaseHelper
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler(Looper.getMainLooper()).postDelayed(this::verifyAuth, 3000)
    }

    private fun verifyAuth() {
        if (FirebaseHelper.isAuthenticated()) {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        } else {
            findNavController().navigate(R.id.action_splashFragment_to_authentication)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}