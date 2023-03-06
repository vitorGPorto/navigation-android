package com.example.jokenpo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.jokenpo.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var drawer: DrawerLayout // caso der  errado verificar aqui.
    lateinit var navDrawer : NavigationView
    lateinit var bottomNav : BottomNavigationView
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)

        drawer =  binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNav

        //configuracao da navHost e navControlle
        val navHostFragment =  supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val appBarConfigurantion =  AppBarConfiguration(setOf(R.id.playFragment, R.id.resultFragment), drawer)

        setupActionBarWithNavController(navController, appBarConfigurantion)

        navDrawer.setupWithNavController(navController)
        //finalizar aqui
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
                        true
                    }
                    else -> false
                }

            }
        }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }
}