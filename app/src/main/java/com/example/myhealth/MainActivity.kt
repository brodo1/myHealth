package com.example.myhealth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myhealth.databinding.ActivityMainBinding
import com.example.myhealth.reminder.reminderFragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController=navHostFragment.findNavController()

        appBarConfiguration= AppBarConfiguration(
            setOf(R.id.reminderFragment3,R.id.tlakFragment2, R.id.secerFragment2)
        )

        setSupportActionBar(binding.toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.bottomNavMenu.setupWithNavController(navController)

    /*
        binding.bottomNavMenu.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.reminderFragment3-> {
                    setCurrFragment(reminderFragment())
                    true
                }
                R.id.tlakFragment->{
                    setCurrFragment(tlakFragment())
                    true
                }
                R.id.secerFragment->{
                    setCurrFragment(secerFragment())
                    true
                }
                else -> false
            }

        }
        binding.bottomNavMenu.selectedItemId=R.id.reminderFragment3
    */


    }

    override fun onSupportNavigateUp(): Boolean { //za back u toolbaru
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    /*
    private fun setCurrFragment(fragment: Fragment)= supportFragmentManager.beginTransaction().apply {
        replace(R.id.nav_host_fragment,fragment)
        commit()
    }
    */


}

