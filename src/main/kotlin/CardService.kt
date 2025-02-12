import entity.Card
import entity.CardSuit
import entity.CardValue

class CardService {
    fun createCard(cardStr: String): Card {
        val suit = when (cardStr[0]) {
            'C' -> CardSuit.CLUBS
            'D' -> CardSuit.DIAMONDS
            'H' -> CardSuit.HEARTS
            'S' -> CardSuit.SPADES
            else -> throw IllegalArgumentException("Invalid card suit")
        }
        val value = when (cardStr.substring(1)) {
            "A" -> CardValue.ACE
            "2" -> CardValue.TWO
            "3" -> CardValue.THREE
            "4" -> CardValue.FOUR
            "5" -> CardValue.FIVE
            "6" -> CardValue.SIX
            "7" -> CardValue.SEVEN
            "8" -> CardValue.EIGHT
            "9" -> CardValue.NINE
            "10" -> CardValue.TEN
            "J" -> CardValue.JACK
            "Q" -> CardValue.QUEEN
            "K" -> CardValue.KING
            else -> throw IllegalArgumentException("Invalid card value")
        }
        return Card(suit, value)
    }
}