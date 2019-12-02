package com.example.tpepsihttp.cocktail

import retrofit2.Call
import retrofit2.http.GET

interface CocktailWebservice{
    @GET("/api/json/v1/1/random.php")
    fun getRandomCocktail(): Call<CocktailResponse>
}
