package br.com.devairon.mybankdigital.presenter.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.devairon.mybankdigital.R
import br.com.devairon.mybankdigital.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnLogin.setOnClickListener {
            validate()
        }

        binding.btnCreateAccount.setOnClickListener {

        }

    }

    private fun validate() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isNotBlank()) {
            if (password.isNotBlank()) {
                Toast.makeText(requireContext(), "Login Success", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(requireContext(), "Digite uma senha", Toast.LENGTH_SHORT).show()

            }
        } else {
            Toast.makeText(requireContext(), "digite um email", Toast.LENGTH_SHORT).show()

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}