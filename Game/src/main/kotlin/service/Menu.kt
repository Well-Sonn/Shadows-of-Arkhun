package controller

import enums.Classe
import enums.EstiloRolagem
import enums.Raca
import service.PersonagemService

object Menu {

    fun exibirMenu() {
        println("Digite o nome do personagem:")
        val nome = readLine()!!
        val raca = escolherRaca()
        val classe = escolherClasse()
        val estilo = escolherEstilo()
        val personagem = PersonagemService.criarPersonagem(nome, raca, classe, estilo)
        PersonagemService.salvarPersonagem(personagem)

        println("\nPersonagem criado com sucesso:")
        println(personagem)
    }

    private fun escolherRaca(): Raca {
        val racas = Raca.values()
        while (true) {
            println("\nEscolha a raça:")
            racas.forEachIndexed { i, r -> println("${i + 1} - ${r.name}") }

            val escolha = readLine()?.toIntOrNull()
            if (escolha != null && escolha in 1..racas.size) {
                return racas[escolha - 1]
            }
            println("Opção inválida, tente novamente.")
        }
    }

    private fun escolherClasse(): Classe {
        val classes = Classe.values()
        while (true) {
            println("\nEscolha a classe:")
            classes.forEachIndexed { i, c -> println("${i + 1} - ${c.name}") }

            val escolha = readLine()?.toIntOrNull()
            if (escolha != null && escolha in 1..classes.size) {
                return classes[escolha - 1]
            }
            println("Opção inválida, tente novamente.")
        }
    }

    private fun escolherEstilo(): EstiloRolagem {
        val estilos = EstiloRolagem.values()
        while (true) {
            println("\nEscolha o estilo de rolagem:")
            estilos.forEachIndexed { i, e -> println("${i + 1} - ${e.name}") }

            val escolha = readLine()?.toIntOrNull()
            if (escolha != null && escolha in 1..estilos.size) {
                return estilos[escolha - 1]
            }
            println("Opção inválida, tente novamente.")
        }
    }
}