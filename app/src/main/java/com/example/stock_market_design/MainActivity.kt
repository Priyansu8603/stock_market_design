package com.example.stock_market_design

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.stock_market_design.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() ,NavigationView.OnNavigationItemSelectedListener {

    private lateinit var fragmentManager: FragmentManager


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        setSupportActionBar(binding.toolbar)


        val toggle = ActionBarDrawerToggle(this,binding.drawerLayout,binding.toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        binding.navigationDrawer.setNavigationItemSelectedListener(this)



        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.bottom_home -> openFragment(bottom_home_frag())
                R.id.bottom_PaperTrading -> openFragment(bottom_paperTrading_frag())
                R.id.bottom_stocks -> openFragment(bottom_stocks_frag())
                R.id.bottom_Posts -> openFragment(bottom_posts_frag())
            }
            true
        }
        fragmentManager= supportFragmentManager
        openFragment(bottom_home_frag())


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_credit -> openFragment(navDrawer_credit() )
            R.id.nav_purchases -> openFragment(navDrawer_purchases() )
            R.id.nav_savedPost -> Toast.makeText(this, "saved posts clicked", Toast.LENGTH_SHORT).show()
            R.id.nav_notification -> Toast.makeText(this, "notification clicked", Toast.LENGTH_SHORT).show()
            R.id.nav_contactus -> Toast.makeText(this, "contact us clicked", Toast.LENGTH_SHORT).show()
            R.id.nav_rate -> Toast.makeText(this, "rate us clicked", Toast.LENGTH_SHORT).show()
            R.id.nav_about -> Toast.makeText(this, "about us clicked", Toast.LENGTH_SHORT).show()
            R.id.nav_logout -> Toast.makeText(this, "logout clicked", Toast.LENGTH_SHORT).show()
            R.id.nav_settings -> Toast.makeText(this, "settings clicked", Toast.LENGTH_SHORT).show()

        }
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)){
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }else{
            super.getOnBackPressedDispatcher().onBackPressed()
        }
    }

    private fun openFragment(fragment: Fragment){
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container, fragment)
        fragmentTransaction.commit()


    }
}
