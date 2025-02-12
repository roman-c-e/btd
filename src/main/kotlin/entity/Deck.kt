package entity

class Deck(cards: List<Card>) {
    private val cards: MutableList<Card> = mutableListOf()

    init {
        this.cards.addAll(cards)
    }

    fun draw(): Card {
        return cards.removeAt(0)
    }

    fun createDeck(): Deck {
        for (suit in CardSuit.entries) {
            for (value in CardValue.entries) {
                cards.add(Card(suit, value))
            }
        }
        return Deck(cards)
    }

    fun getCards(): List<Card> {
        return cards
    }

    fun shuffle() {
        cards.shuffle()
    }

    override fun toString(): String {
        return cards.toString()
    }
}