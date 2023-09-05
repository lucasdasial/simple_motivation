package com.dasial.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.dasial.motivation.R
import com.dasial.motivation.infra.Constants
import com.dasial.motivation.infra.Shared
import com.dasial.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var b: ActivityMainBinding
    private var categoryId = Constants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        b = ActivityMainBinding.inflate(layoutInflater)

        setContentView(b.root)

        supportActionBar?.hide()

        b.btnNewPhrase.setOnClickListener(this)
        b.imgAll.setOnClickListener(this)
        b.imgHappy.setOnClickListener(this)
        b.imgSunny.setOnClickListener(this)

        handleUser()
        handleFilter(R.id.img_all)
    }

    override fun onClick(v: View) {

        if(v.id == R.id.btn_new_phrase){
            var s = ""
        }else if ( v.id in listOf(R.id.img_all, R.id.img_happy, R.id.img_sunny)){
            handleFilter(v.id)
        }


    }

    private fun handleUser(){
        val name = Shared(this).getString(Constants.KEY.USER_NAME)
        b.textHello.text = "Olá, $name"
    }

    private fun handleFilter(id:Int) {

        b.imgAll.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        b.imgSunny.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
        b.imgHappy.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))

        when (id) {
            R.id.img_all -> {
                categoryId = Constants.FILTER.ALL
                b.imgAll.setColorFilter(ContextCompat.getColor(this,R.color.white))
            }
            R.id.img_sunny -> {
                categoryId = Constants.FILTER.SUNNY
                b.imgSunny.setColorFilter(ContextCompat.getColor(this,R.color.white))
            }
            R.id.img_happy -> {
                categoryId = Constants.FILTER.HAPPY
                b.imgHappy.setColorFilter(ContextCompat.getColor(this,R.color.white))

            }
        }
    }

}