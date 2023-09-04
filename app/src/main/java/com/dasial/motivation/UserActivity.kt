package com.dasial.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dasial.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)

        supportActionBar?.hide()

    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btn_save) {
            handleSave()
        }

    }

    private fun handleSave() {
        val name = binding.editTextName.text.toString()

        if (name != "") {

            Shared(this).saveString("USER_NAME",name)

            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(
                applicationContext,
                R.string.validation_mandatory_name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}