package com.example.stock_market_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.stock_market_design.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var drawerlayout: DrawerLayout
    private lateinit var navigationView: NavigationView
    private lateinit var toggle: ActionBarDrawerToggle



    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setSupportActionBar(binding.toolbar)

        drawerlayout = findViewById(R.id.drawer_layout)
        supportActionBar?.setDisplayHomeAsUpEnabled(false);


        navigationView = findViewById(R.id.nav_view)


        toggle = ActionBarDrawerToggle(
            this,
            drawerlayout,
            findViewById(R.id.toolbar),
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerlayout.addDrawerListener(toggle)



        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item clicks here
            when (menuItem.itemId) {
                R.id.nav_credit -> {
                    // Handle home item click
                    Toast.makeText(applicationContext, "Credit clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    return@setNavigationItemSelectedListener true


                }
                R.id.nav_purchases -> {
                    // Handle profile item click
                    Toast.makeText(applicationContext, "Purchases clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_savedPost -> {
                    // Handle settings item click
                    Toast.makeText(applicationContext, "Saved Posts clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_notification -> {
                    // Handle notifications item click
                    Toast.makeText(applicationContext, "Notifications clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_contactus -> {
                    // Handle help item click
                    Toast.makeText(applicationContext, "Contact us clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_rate -> {
                    // Handle logout item click
                    Toast.makeText(applicationContext, "Rate us clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_about -> {
                    // Handle contact us item click
                    Toast.makeText(applicationContext, "About us clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_logout -> {
                    // Handle rate item click
                    Toast.makeText(applicationContext, "Log Out clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                R.id.nav_settings -> {
                    // Handle about item click
                    Toast.makeText(applicationContext, "Settings clicked", Toast.LENGTH_SHORT).show()
                    drawerlayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }
            true
        }



    }
}
