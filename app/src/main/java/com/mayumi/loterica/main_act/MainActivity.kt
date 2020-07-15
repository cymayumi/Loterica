package com.mayumi.loterica.main_act

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.mayumi.loterica.R
import com.mayumi.loterica.frags.InfoFragment
import com.mayumi.loterica.frags.JogosFragment
import com.mayumi.loterica.frags.ResultadosFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, JogosFragment.newInstance())
                .commit()
        }
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_jogos -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, JogosFragment.newInstance())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_resultados -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ResultadosFragment.newInstance())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_info -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, InfoFragment.newInstance())
                    .commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
