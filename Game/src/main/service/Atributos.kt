object Atributos {
    fun limitesForca(raca: Raca) = when (raca) {
        Raca.HUMANO -> 10..15
        Raca.ELFO -> 8..10
        Raca.ANAO -> 12..18
    }

    fun limitesDestreza(raca: Raca) = when (raca) {
        Raca.HUMANO -> 10..15
        Raca.ELFO -> 8..10
        Raca.ANAO -> 15..20
    }

    fun limitesInteligencia(raca: Raca) = when (raca) {
        Raca.HUMANO -> 8..15
        Raca.ELFO -> 15..20
        Raca.ANAO -> 10..15
    }
}
