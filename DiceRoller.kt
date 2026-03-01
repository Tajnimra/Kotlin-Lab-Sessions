import kotlin.random.Random

fun rollDice(): Int {
    return Random.nextInt(1, 7)  // Generates number from 1 to 6
}

fun rollPairOfDice() {
    val dice1 = rollDice()
    val dice2 = rollDice()

    println("Dice 1: $dice1")
    println("Dice 2: $dice2")

    if (dice1 == dice2) {
        println("Double! You rolled the same number!")
    } else {
        println("Try again!")
    }
}

fun main() {
    println("Rolling the dice...")
    rollPairOfDice()
}
