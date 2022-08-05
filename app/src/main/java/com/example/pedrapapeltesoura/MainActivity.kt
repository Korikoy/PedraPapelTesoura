package com.example.pedrapapeltesoura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.pedrapapeltesoura.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.Pedra.setOnClickListener{
            pedraSelecionado()
        }
        binding.Papel.setOnClickListener{
            papelSelecionado()
        }
        binding.Tesoura.setOnClickListener{
            tesouraSelecionado()
        }

    }


    fun pedraSelecionado(){
        this.opcaoSelecionada("Pedra")
    }
    fun papelSelecionado(){
        this.opcaoSelecionada("Papel")
    }
    fun tesouraSelecionado(){
        this.opcaoSelecionada("Tesoura")
    }

    fun opcaoSelecionada(opcaoselecionada:String){

        var numero = (0..2).random()
        var opcoes = arrayListOf<String>("Pedra","Papel","Tesoura")
        var opcaoApp = opcoes[numero]

        var foto = when(numero) {
            0 -> binding.imageResultado.setImageResource(R.drawable.pedra)
            1 -> binding.imageResultado.setImageResource(R.drawable.papel)
            2 -> binding.imageResultado.setImageResource(R.drawable.tesoura)
            else -> {}
        }

        if(
            (opcaoApp == "Tesoura" && opcaoselecionada == "Papel") ||
            (opcaoApp == "Papel" && opcaoselecionada == "Pedra")  ||
            (opcaoApp == "Pedra" && opcaoselecionada == "Tesoura")
        ){
            binding.ResultadoPart.text = "Voce Perdeu!"
        }else if (
            (opcaoselecionada== "Tesoura" && opcaoApp == "Papel") ||
            (opcaoselecionada == "Pedra" && opcaoApp == "Tesoura") ||
            (opcaoselecionada == "Papel" && opcaoApp == "Pedra")
        ){
            binding.ResultadoPart.text = "Voce Ganhou !!!"
        }else{
            binding.ResultadoPart.text = "Empate!!"
        }

    }





}