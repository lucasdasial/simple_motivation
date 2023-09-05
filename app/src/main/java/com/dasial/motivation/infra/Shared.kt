package com.dasial.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class Shared(ctx: Context) {

    private val storage : SharedPreferences = ctx.getSharedPreferences("motivation", Context.MODE_PRIVATE)

     fun saveString (key: String, value: String) {
        storage.edit().putString(key,value).apply()
    }

    fun  getString(key: String): String{

       return  storage.getString(key,"") ?: ""
    }
}