package com.mycompany.nbcapp.ui

import android.content.Context
import android.content.DialogInterface
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.lifecycle.lifecycleScope
import com.google.gson.GsonBuilder
import com.mycompany.nbcapp.R
import com.mycompany.nbcapp.databinding.ActivityMainBinding
import com.mycompany.nbcapp.datasource.Api
import com.mycompany.nbcapp.models.Page
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.internal.format
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var list: Page
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val gson=GsonBuilder().setLenient().create()
        val api = Retrofit.Builder()
            .baseUrl("https://s3.us-west-2.amazonaws.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(Api::class.java)



    }
}