package com.example.tpepsihttp

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tpepsihttp.cocktail.Cocktail
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cocktail_details_fragment.*


class CocktailDetails : Fragment() {

    companion object {
        fun newInstance() = CocktailDetails()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.cocktail_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cocktailJson = arguments!!.getString("cocktail")
        val cocktail = Gson().fromJson(cocktailJson, Cocktail::class.java)
        Picasso.get().load(cocktail.strDrinkThumb).into(imageView)
        cocktailName.text = cocktail.strDrink
        cocktailInstruction.text = cocktail.strInstructions
    }

}
