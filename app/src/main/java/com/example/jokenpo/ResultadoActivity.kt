package com.example.jokenpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.jokenpo.databinding.ActivityResultadoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class ResultadoActivity : AppCompatActivity() {
    lateinit var drawer: DrawerLayout // caso der  errado verificar aqui.
    lateinit var navDrawer : NavigationView
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_resultado)

        val binding = ActivityResultadoBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar3)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNavigationView

       setupToolbar()
       setDrawer()
      setButtomNavigation()
    }
    private fun setButtomNavigation(){
        bottomNav.setOnItemSelectedListener {
                menuItem ->
            when(menuItem.itemId){
                R.id.bottom_option_1 ->{
                    Snackbar.make(drawer,getString(R.string.bottom_nav_title_1), Snackbar.LENGTH_SHORT).show()
                    true
                }
                R.id.bottom_option_2 -> {
                   Snackbar.make(drawer,getString(R.string.bottom_nav_title_2), Snackbar.LENGTH_SHORT).show()
                    val resultadoActivityIntent = Intent(this, ResultadoActivity::class.java)
                    startActivity(resultadoActivityIntent)
                    true
                }
                else -> false
            }

        }
    }
    private fun setDrawer(){

        navDrawer.setNavigationItemSelectedListener {
                menuItem->
            drawer.closeDrawers()
            when (menuItem.itemId){
                R.id.drawer_home ->{
                    onBackPressed()
                    true
                }
                else -> false
            }

        }

    }
    private fun setupToolbar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)

    }
    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.second_screen_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.menu_save ->{
                Snackbar.make(this,
                    drawer,
                    getString( R.string.menu_save_title),
                    Snackbar.LENGTH_SHORT).show()
                true
            }
            R.id.menu_setting -> {
                Snackbar.make(this,
                    drawer,
                    getString(R.string.menu_settings_title),
                    Snackbar.LENGTH_SHORT).show()
                true
            }
            else -> false
        }
    }
}