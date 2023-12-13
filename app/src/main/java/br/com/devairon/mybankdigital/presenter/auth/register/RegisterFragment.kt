package br.com.devairon.mybankdigital.presenter.auth.register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.devairon.mybankdigital.R
import br.com.devairon.mybankdigital.data.model.User
import br.com.devairon.mybankdigital.databinding.FragmentRecoverBinding
import br.com.devairon.mybankdigital.databinding.FragmentRegisterBinding
import br.com.devairon.mybankdigital.utils.StateView
import br.com.devairon.mybankdigital.utils.initToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val registerViewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {
        binding.btnCreateAccount.setOnClickListener {
            validate()
        }
    }

    private fun validate() {
        val name = binding.edtName.text.toString()
        val email = binding.edtEmail.text.toString().trim()
        val phoneNumber = binding.edtPhone.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()


        if (name.isNotEmpty()) {
            if (email.isNotEmpty()) {
                if (phoneNumber.isNotEmpty()) {
                    if (password.isNotEmpty()) {
                        val user = User(name, email, phoneNumber, password)
                        registerUser(user)
                    } else {
                        Toast.makeText(
                            requireContext(), "o Campo de senha precisa ser preenchido",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                } else {
                    Toast.makeText(
                        requireContext(),
                        "o Campo de telefone precisa ser preenchido",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            } else {
                Toast.makeText(
                    requireContext(),
                    "o Campo de email precisa ser preenchido",
                    Toast.LENGTH_SHORT
                ).show()

            }
        } else {

            Toast.makeText(
                requireContext(),
                "o Campo de nome precisa ser preenchido",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun registerUser(user: User) {

        registerViewModel.register(user).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is StateView.Success -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        "Usuario Criado com Sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_global_homeFragment)
                }

                is StateView.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(requireContext(), stateView.message, Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}