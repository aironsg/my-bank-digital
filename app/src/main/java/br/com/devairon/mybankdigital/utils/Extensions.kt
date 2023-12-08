package br.com.devairon.mybankdigital.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.devairon.mybankdigital.R

fun Fragment.initToolbar(
    toolbar: androidx.appcompat.widget.Toolbar,
    homeAUpEnabled: Boolean = true
) {

    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(homeAUpEnabled)
    (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressed()
    }


}

