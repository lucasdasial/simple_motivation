package com.dasial.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dasial.motivation.infra.Constants
import com.dasial.motivation.R
import com.dasial.motivation.infra.Shared
import com.dasial.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnSave.setOnClickListener(this)

        supportActionBar?.hide()

        verifyUserExist()

    }


    override fun onClick(v: View?) {

        if (v?.id == R.id.btn_save) {
            handleSave()
        }

    }

    private fun navigateToHome() {
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun handleSave() {
        val nameInput = binding.editTextName.text.toString()

        if (nameInput != "") {
            Shared(this).saveString(Constants.KEY.USER_NAME, nameInput)
            navigateToHome()

        } else {
            Toast.makeText(
                applicationContext,
                R.string.validation_mandatory_name,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun verifyUserExist() {
        val name = Shared(this).getString(Constants.KEY.USER_NAME)
        if (name != "") {
            navigateToHome()
        }
    }
}