package service

import enums.EstiloRolagem
import model.Atributos
import model.Personagem
import enums.Raca
import enums.Classe
import kotlin.random.Random
import java.io.File

object PersonagemService {

    private fun rolarDado(lados: Int): Int = Random.nextInt(1, lados + 1)

    private fun rolarAtributos(estilo: EstiloRolagem): List<Int> {
        return when (estilo) {
            EstiloRolagem.CLASSICO -> {
                // 3 atributos, cada um com 3d6
                List(3) { (1..3).sumOf { rolarDado(6) } }
            }
            EstiloRolagem.AVENTUREIRO -> {
                // também 3 atributos, mas você pode diferenciar se quiser
                List(3) { (1..3).sumOf { rolarDado(6) } }
            }
            EstiloRolagem.HEROICO -> {
                // 4d6 descartando o menor, para cada atributo
                List(4) {
                    val rolagens = List(4) { rolarDado(6) }
                    rolagens.sortedDescending().take(3).sum()
                }
            }
        }
    }

    private fun distribuirAtributos(valores: List<Int>): Atributos {
        val atributos = listOf("Força", "Destreza", "Inteligência")
        val escolhidos = mutableMapOf<String, Int>()
        val valoresDisponiveis = valores.toMutableList()

        for (atributo in atributos) {
            println("Escolha um valor para $atributo (valores disponíveis: $valoresDisponiveis):")
            val escolha = readLine()?.toIntOrNull()

            if (escolha == null || !valoresDisponiveis.contains(escolha)) {
                println("Valor inválido, tente novamente.")
                return distribuirAtributos(valores)
            }

            escolhidos[atributo] = escolha
            valoresDisponiveis.remove(escolha)
        }

        return Atributos(
            forca = escolhidos["Força"]!!,
            destreza = escolhidos["Destreza"]!!,
            inteligencia = escolhidos["Inteligência"]!!
        )
    }

    fun criarPersonagem(nome: String, raca: Raca, classe: Classe, estilo: EstiloRolagem): Personagem {
        val valores = rolarAtributos(estilo)

        println("Valores rolados: $valores")
        val atributos = distribuirAtributos(valores)

        return Personagem(nome, raca, classe, estilo, atributos)
    }

    fun salvarPersonagem(personagem: Personagem) {
        val arquivo = File("personagens.txt")
        arquivo.appendText("${personagem.nome},${personagem.raca},${personagem.classe},${personagem.atributos}\n")
    }
}
