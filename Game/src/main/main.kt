package controller

import enums.Classe
import enums.EstiloRolagem
import enums.Raca
import service.PersonagemService

fun main() {
    println("Digite o nome do personagem:")
    val nome = readLine()!!

    println("Escolha a raça: HUMANO, ANAO, GNOMO")
    val raca = Raca.valueOf(readLine()!!.uppercase())

    println("Escolha a classe: GUERREIRO, MAGO, NECROMANTE")
    val classe = Classe.valueOf(readLine()!!.uppercase())

    println("Escolha o estilo de rolagem: CLASSICO, AVENTUREIRO, HEROICO")
    val estilo = EstiloRolagem.valueOf(readLine()!!.uppercase())

    val personagem = PersonagemService.criarPersonagem(nome, raca, classe, estilo)
    PersonagemService.salvarPersonagem(personagem)

    println("\n Personagem criado com sucesso:")
    println(personagem)
}
