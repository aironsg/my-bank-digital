package br.com.devairon.mybankdigital.presenter.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import br.com.devairon.mybankdigital.R
import br.com.devairon.mybankdigital.databinding.FragmentRecoverBinding
import br.com.devairon.mybankdigital.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        val passwordConfirmation = binding.edtPasswordConfirmation.text.toString().trim()

        if (name.isNotBlank()) {
            if (email.isNotBlank()) {
                if (phoneNumber.isNotBlank()) {
                    if (password.isNotBlank()) {
                        if (passwordConfirmation.isNotBlank()) {
                            if (passwordConfirmation.equals(password)) {
                                Toast.makeText(
                                    requireContext(),
                                    "criando conta",
                                    Toast.LENGTH_SHORT
                                ).show()
                            } else {
                                Toast.makeText(
                                    requireContext(),
                                    "senha diferente, verifique novamente",
                                    Toast.LENGTH_SHORT
                                ).show()

                            }
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "o Campo de confirmação de senha precisa ser preenchido",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "o Campo de senha precisa ser preenchido",
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

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}