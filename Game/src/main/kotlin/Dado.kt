import kotlin.random.Random

class Dado(private val lados: Int) {
    fun rolar(): Int {
        return Random.nextInt(1, lados + 1)
    }
}