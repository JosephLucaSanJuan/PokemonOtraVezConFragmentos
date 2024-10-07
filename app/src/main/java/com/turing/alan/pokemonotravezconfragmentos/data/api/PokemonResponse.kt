package com.turing.alan.pokemonotravezconfragmentos.data.api

import com.google.gson.annotations.SerializedName

data class PokemonListResponse(
    val results: List<PokemonListItemResponse>
)

data class PokemonListItemResponse(
    val name: String
)

data class PokemonDetailResponse(
    val id:Int,
    val name:String,
    val sprites:PokemonSpritesResponse
)

data class PokemonSpritesResponse(
    @SerializedName("front_default")
    val frontDefault:String
)