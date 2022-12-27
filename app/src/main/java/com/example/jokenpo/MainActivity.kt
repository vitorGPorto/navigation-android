package com.example.jokenpo


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //criando binding
         val binding = ActivityMainBinding.inflate(layoutInflater)
        val toolbar = binding.toolbar

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        supportActionBar?.title = "Jokenpô"
        //supportActionBar?.setLogo(R.drawable.ic_logo)

        //adcionar icon na barra
        supportActionBar?.setDisplayUseLogoEnabled(true)

        //colocar icon de voltar
       // supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val activity2Intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("Nome", "Vitor")
        intent.putExtra("idade", 26)



        binding.startActivitybutton.setOnClickListener {
            startActivity(activity2Intent)
        }


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}