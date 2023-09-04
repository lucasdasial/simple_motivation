package com.dasial.motivation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.dasial.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var b: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        b = ActivityMainBinding.inflate(layoutInflater)

        setContentView(b.root)

        supportActionBar?.hide()

        val name = Shared(this).getString("USER_NAME")
        b.textHello.text = "Olá, $name"

        b.btnNewPhrase.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }
}