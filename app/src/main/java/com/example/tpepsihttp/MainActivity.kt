package com.example.tpepsihttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tpepsihttp.cocktail.CocktailFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cards = 10
        for (cardIndex in 1..cards){
            val fragment = CocktailFragment()
            supportFragmentManager.beginTransaction().add(
                flexbox.id, fragment
            ).commit()
        }

    }
}
