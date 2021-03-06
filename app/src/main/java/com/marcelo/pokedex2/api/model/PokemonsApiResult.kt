package com.marcelo.pokedex2.api.model

import com.marcelo.pokedex2.domain.PokemonType

data class PokemonsApiResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>,
    val height: Int?,
    val weight: Int?
)

data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
    )