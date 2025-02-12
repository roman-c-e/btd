package entity

class Player(private val name: String) {

    private val hand: MutableList<Card> = mutableListOf()

    fun addCard(card: Card) {
        hand.add(card)
    }

    override fun toString(): String {
        return name
    }

    fun getHand(): List<Card> {
        return hand
    }

    fun printHand(): String {
        return hand.joinToString(separator = ", ")
    }

    fun getScore(): Int {
        var score = 0
        for (card in hand) {
            score += card.getValue()
        }
        return score
    }

}