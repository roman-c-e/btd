package entity

class Card(private val suit: CardSuit, private val value: CardValue) {

    fun getCardSuit(): CardSuit {
        return suit
    }

    fun getCardValue(): CardValue {
        return value
    }

    fun getValue(): Int {
        return value.value
    }

    override fun toString(): String {
        return "${suit.suit}${value.char}"
    }
}
