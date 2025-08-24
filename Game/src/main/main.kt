fun main() {
    println("Digite o nome do personagem:")
    val nome = readLine()!!

    println("Escolha a raça: HUMANO, ELFO, ANAO")
    val racaInput = readLine()!!
    val raca = Raca.valueOf(racaInput.uppercase())

    println("Escolha a classe: MAGO, NECROMANTE, GUERREIRO")
    val classeInput = readLine()!!
    val classe = Classe.valueOf(classeInput.uppercase())

    val forcaRange = Atributos.limitesForca(raca)
    val destrezaRange = Atributos.limitesDestreza(raca)
    val inteligenciaRange = Atributos.limitesInteligencia(raca)

    println("Escolha Força (${forcaRange.first}-${forcaRange.last}):")
    val forca = readLine()?.toIntOrNull()?.coerceIn(forcaRange) ?: forcaRange.first

    println("Escolha Destreza (${destrezaRange.first}-${destrezaRange.last}):")
    val destreza = readLine()?.toIntOrNull()?.coerceIn(destrezaRange) ?: destrezaRange.first

    println("Escolha Inteligência (${inteligenciaRange.first}-${inteligenciaRange.last}):")
    val inteligencia = readLine()?.toIntOrNull()?.coerceIn(inteligenciaRange) ?: inteligenciaRange.first

    val personagem = PersonagemService.criarPersonagem(nome, raca, classe, forca, destreza, inteligencia)
    PersonagemService.salvarPersonagem(personagem)

    println("Personagem criado com sucesso!")
    println(personagem)
}