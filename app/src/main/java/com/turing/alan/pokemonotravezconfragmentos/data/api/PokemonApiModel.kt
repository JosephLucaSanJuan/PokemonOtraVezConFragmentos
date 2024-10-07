package com.turing.alan.pokemonotravezconfragmentos.data.api

data class PokemonApiModel(
    val id:Int,
    val name:String,
    val weight:Int,
    val height:Int,
    val front:String
)

data class PokemonListApiModel(
    val list:List<PokemonApiModel>
)
