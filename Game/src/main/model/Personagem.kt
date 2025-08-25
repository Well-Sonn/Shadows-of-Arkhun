package model

import enums.Classe
import enums.EstiloRolagem
import enums.Raca

data class Personagem(
    val nome: String,
    val raca: Raca,
    val classe: Classe,
    val progresso: EstiloRolagem,
    val atributos: Atributos
)
