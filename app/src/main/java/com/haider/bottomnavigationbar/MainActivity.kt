package com.haider.bottomnavigationbar

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.haider.bottomnavigationbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personFragment = PersonFragment()
        val homeFragment = HomeFragment()
        val settingsFragment = SettingsFragment()


        setCurrentFragment(personFragment)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.person -> setCurrentFragment(personFragment)
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.settings -> setCurrentFragment(settingsFragment)
            }
            true
        }

    }

    private fun setCurrentFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
    }
}