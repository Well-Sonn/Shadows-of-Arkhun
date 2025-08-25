import java.io.File

object PersonagemService {
    fun criarPersonagem(nome: String, raca: Raca, classe: Classe, forca: Int, destreza: Int, inteligencia: Int): Personagem {
        val (movimento, visao, alinhamento) = when (raca) {
            Raca.HUMANO -> Triple(5, 8, "Leal e Bom")
            Raca.ELFO -> Triple(5, 10, "Neutro")
            Raca.ANAO -> Triple(3, 12, "Caótico")
        }

        return Personagem(nome, raca, classe, movimento, visao, alinhamento, forca, destreza, inteligencia)
    }

    fun salvarPersonagem(personagem: Personagem) {
        val arquivo = File("personagens.txt")
        arquivo.appendText(
            "${personagem.nome},${personagem.raca},${personagem.classe}," +
                    "${personagem.movimento},${personagem.visao},${personagem.alinhamento}," +
                    "${personagem.forca},${personagem.destreza},${personagem.inteligencia}\n"
        )
    }
}
