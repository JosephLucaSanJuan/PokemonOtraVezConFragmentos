package com.turing.alan.pokemonotravezconfragmentos.data.api

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


interface  PokemonApi {
    @GET("api/v2/pokemon/{id}/")
    suspend fun fetchPokemon(@Path("id") id:String):PokemonApiModel
    suspend fun fetchAllPokemon():PokemonListResponse
}


class PokemonRepository private constructor(private val api:PokemonApi) {

    private val _pokemon = MutableLiveData<List<PokemonApiModel>>()
    val pokemon: LiveData<List<PokemonApiModel>>
        get() = _pokemon

    companion object {
        private var _INSTANCE: PokemonRepository? = null
        fun getInstance(): PokemonRepository {

            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val pokemonApi = retrofit.create(PokemonApi::class.java)
            _INSTANCE = _INSTANCE ?: PokemonRepository(pokemonApi)
            return _INSTANCE!!

        }
    }

    suspend fun fetch() {
        // TODO llamar a la api para obtener la lista
        val pokemonList = api.fetchAllPokemon()
        // TODO Recorrer la respuesta
        val pokemonListApiModel = pokemonList.results.map {
            val detailResponse = api.fetchPokemon(it.name)
        }

        // TODO Mapear el resultado a PokemonApiList
        //Log.d("DAVID",pokemonResponse.toString())
        //_pokemon.value = pokemonResponse
    }


}