import entity.Card

class DeckSanityService {

     fun duplicateCheck(cards: List<Card>, card: Card) {
        for (c in cards) {
            if (c.getCardSuit() == card.getCardSuit() && c.getCardValue() == card.getCardValue()) {
                throw IllegalArgumentException("Duplicate card $card")
            }
        }
    }

     fun sizeCheck(cards: List<Card>) {
        if (cards.size != 52) {
            throw IllegalArgumentException("Deck size is not 52")
        }
    }

}