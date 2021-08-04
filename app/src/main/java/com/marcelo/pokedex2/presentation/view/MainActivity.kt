package com.marcelo.presentation.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marcelo.pokedex2.R
import com.marcelo.pokedex2.domain.Pokemon
import com.marcelo.pokedex2.viewmodel.PokemonViewModel
import com.marcelo.pokedex2.viewmodel.PokemonViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context) = Intent(context, MainActivity::class.java)
    }

    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvPokemons)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon?>) {

        loader_pokemon.visibility = VISIBLE

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokemonAdapter(pokemons)

        loader_pokemon.visibility = GONE
    }
}