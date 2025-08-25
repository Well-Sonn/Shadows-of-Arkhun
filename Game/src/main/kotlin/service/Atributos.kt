object Atributos {
    private val dado = Dado(8) // Dado de 8 lados

    private fun calcularValor(range: IntRange): Int {
        val resultadoDado = dado.rolar() // 1 até 8
        val proporcao = (resultadoDado - 1).toDouble() / 7.0 // de 0.0 até 1.0
        val valor = range.first + ((range.last - range.first) * proporcao).toInt()

        println("🎲 Rolou $resultadoDado → Valor atribuído: $valor")
        return valor
    }

    fun gerarForca(raca: Raca) = when (raca) {
        Raca.HUMANO -> calcularValor(10..15)
        Raca.ELFO -> calcularValor(8..10)
        Raca.ANAO -> calcularValor(12..18)
    }

    fun gerarDestreza(raca: Raca) = when (raca) {
        Raca.HUMANO -> calcularValor(10..15)
        Raca.ELFO -> calcularValor(8..10)
        Raca.ANAO -> calcularValor(15..20)
    }

    fun gerarInteligencia(raca: Raca) = when (raca) {
        Raca.HUMANO -> calcularValor(8..15)
        Raca.ELFO -> calcularValor(15..20)
        Raca.ANAO -> calcularValor(10..15)
    }
}