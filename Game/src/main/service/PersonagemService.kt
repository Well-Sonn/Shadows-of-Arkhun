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
                List(6) { (1..3).sumOf { rolarDado(6) } }
            }
            EstiloRolagem.AVENTUREIRO -> {
                List(6) { (1..3).sumOf { rolarDado(6) } }
            }
            EstiloRolagem.HEROICO -> {
                List(6) {
                    val rolagens = List(4) { rolarDado(6) }
                    rolagens.sortedDescending().take(3).sum()
                }
            }
        }
    }

    private fun distribuirAtributos(valores: List<Int>): Atributos {
        val atributos = listOf("Força", "Destreza", "Constituição", "Inteligência", "Sabedoria", "Carisma")
        val escolhidos = mutableMapOf<String, Int>()
        val valoresDisponiveis = valores.toMutableList()

        for (atributo in atributos) {
            println("Escolha um valor para $atributo (valores disponíveis: $valoresDisponiveis):")
            val escolha = readLine()!!.toInt()
            if (!valoresDisponiveis.contains(escolha)) {
                println("Valor inválido, tente novamente.")
                return distribuirAtributos(valores)
            }
            escolhidos[atributo] = escolha
            valoresDisponiveis.remove(escolha)
        }

        return Atributos(
            forca = escolhidos["Força"]!!,
            destreza = escolhidos["Destreza"]!!,
            constituicao = escolhidos["Constituição"]!!,
            inteligencia = escolhidos["Inteligência"]!!,
            sabedoria = escolhidos["Sabedoria"]!!,
            carisma = escolhidos["Carisma"]!!
        )
    }

    fun criarPersonagem(nome: String, raca: Raca, classe: Classe, estilo: EstiloRolagem): Personagem {
        val valores = rolarAtributos(estilo)

        val atributos = if (estilo == EstiloRolagem.CLASSICO) {
            Atributos(
                forca = valores[0],
                destreza = valores[1],
                constituicao = valores[2],
                inteligencia = valores[3],
                sabedoria = valores[4],
                carisma = valores[5]
            )
        } else {
            println("Valores rolados: $valores")
            distribuirAtributos(valores)
        }

        return Personagem(nome, raca, classe, estilo, atributos)
    }

    fun salvarPersonagem(personagem: Personagem) {
        val arquivo = File("personagens.txt")
        arquivo.appendText("${personagem.nome},${personagem.raca},${personagem.classe},${personagem.atributos}\n")
    }
}
