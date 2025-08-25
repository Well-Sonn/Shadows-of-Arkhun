package model

import enums.Classe
import enums.EstiloRolagem
import enums.Raca

data class Personagem(
    val nome: String,
    val raca: Raca,
    val classe: Classe,
    val estilo: EstiloRolagem,
    val atributos: Atributos
) {
    override fun toString(): String {
        return """
            Personagem:
              Nome = $nome
              Raça = ${raca.name}
              Classe = ${classe.name}
              Estilo = ${estilo.name}
              Atributos = $atributos
              Habilidades da Raça = ${raca.habilidades.joinToString(", ")}
        """.trimIndent()
    }
}