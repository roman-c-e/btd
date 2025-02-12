import entity.Card
import entity.Deck
import java.io.File
import java.io.FileNotFoundException

class DeckService {

    private val cards = mutableListOf<Card>()

    fun createDeck(): Deck {
        return Deck(cards).createDeck()
    }

    fun readDeck(path: String): Deck {
        val file = File(path)
        if (!file.exists()) {
            throw FileNotFoundException("File not Found")
        }

        processDeck(file.readText())

        DeckSanityService().sizeCheck(cards)
        return Deck(cards)
    }

    private fun processDeck(input: String) {
        val content = input.replace(" ", "")
        content.split(",").map { cardStr ->
            processCard(cardStr)
        }
    }

    private fun processCard(cardStr: String) {
        val card = CardService().createCard(cardStr)
        DeckSanityService().duplicateCheck(cards, card)
        cards.add(card)
    }

}