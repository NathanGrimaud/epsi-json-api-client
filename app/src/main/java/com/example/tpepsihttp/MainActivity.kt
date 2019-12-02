package com.example.tpepsihttp

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import com.example.tpepsihttp.cocktail.CocktailFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var navigationController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cards = 8
        for (cardIndex in 1..cards){
            val fragment = CocktailFragment()
            supportFragmentManager.beginTransaction().add(
                flexbox.id, fragment
            ).commit()
        }
    }
}
