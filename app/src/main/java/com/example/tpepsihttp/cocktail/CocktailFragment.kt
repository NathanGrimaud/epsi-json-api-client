package com.example.tpepsihttp.cocktail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.squareup.picasso.Picasso

import com.example.tpepsihttp.R
import com.google.gson.Gson
import kotlinx.android.synthetic.main.cocktail_fragment.*
import kotlinx.android.synthetic.main.cocktail_fragment.view.*

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CocktailFragment : Fragment() {

    lateinit var cocktail: Cocktail
    companion object {
       fun newInstance() = CocktailFragment()
    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater?.inflate(R.layout.cocktail_fragment, container, false)
        return view
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val retrofit = Retrofit
            .Builder()
            .baseUrl("https://www.thecocktaildb.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(CocktailWebservice::class.java)
        val cocktailService = CocktailService(retrofitService)

        cocktailService.getRandomCocktail(
            { cocktail ->
                Picasso.get().load(cocktail.strDrinkThumb).into(view.cocktailImage)
                view.cocktailName.text = cocktail.strDrink
                this.cocktail = cocktail
                fragmentLayout.setOnClickListener{
                    val bundle = bundleOf("cocktail" to Gson().toJson(cocktail))
                    findNavController(this).navigate(R.id.cocktailDetails, bundle )
                }
            }, { error -> TODO() }
        )

    }

}
