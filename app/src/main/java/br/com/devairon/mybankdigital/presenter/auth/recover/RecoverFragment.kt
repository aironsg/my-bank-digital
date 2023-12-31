package br.com.devairon.mybankdigital.presenter.auth.recover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.devairon.mybankdigital.R
import br.com.devairon.mybankdigital.databinding.FragmentRecoverBinding
import br.com.devairon.mybankdigital.utils.StateView
import br.com.devairon.mybankdigital.utils.initToolbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecoverFragment : Fragment() {

    private var _binding: FragmentRecoverBinding? = null
    private val binding get() = _binding!!
    private val recoverViewModel : RecoverViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentRecoverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        initToolbar(binding.toolbar)
    }

    private fun initListener() {
        binding.btnSend.setOnClickListener {
            validate()
        }
    }

    private fun validate() {
        val email = binding.editEmailRecoverAccount.text.toString().trim()
        if(email.isNotBlank()){
            recoverAccount(email)
        }else{
            Toast.makeText(requireContext(),"por favor insira seu email",Toast.LENGTH_SHORT).show()
        }
    }

    private fun recoverAccount(email: String){
        recoverViewModel.recover(email).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressBar.isVisible = true
                }

                is StateView.Success -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        "Email enviado com Sucesso!",
                        Toast.LENGTH_SHORT
                    ).show()

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