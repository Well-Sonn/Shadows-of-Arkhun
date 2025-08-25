fun main() {
    println("Digite o nome do personagem:")
    val nome = readLine()!!

    println("Escolha a raça: HUMANO, ELFO, ANAO")
    val racaInput = readLine()!!
    val raca = Raca.valueOf(racaInput.uppercase())

    println("Escolha a classe: MAGO, NECROMANTE, GUERREIRO")
    val classeInput = readLine()!!
    val classe = Classe.valueOf(classeInput.uppercase())

    // Agora os atributos são gerados via dado
    val forca = Atributos.gerarForca(raca)
    val destreza = Atributos.gerarDestreza(raca)
    val inteligencia = Atributos.gerarInteligencia(raca)

    val personagem = PersonagemService.criarPersonagem(nome, raca, classe, forca, destreza, inteligencia)
    PersonagemService.salvarPersonagem(personagem)

    println("\n Personagem criado com sucesso!!\n")
    println(personagem)
}