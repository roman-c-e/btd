import entity.Card
import entity.CardSuit
import entity.CardValue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeckSanityServiceTest {

    private val deckSanityService = DeckSanityService()

    @Test
    fun testDuplicateCheckNoDuplicates() {
        val cards = listOf(
            Card(CardSuit.HEARTS, CardValue.ACE),
            Card(CardSuit.DIAMONDS, CardValue.KING)
        )
        val newCard = Card(CardSuit.CLUBS, CardValue.QUEEN)
        assertDoesNotThrow {
            deckSanityService.duplicateCheck(cards, newCard)
        }
    }

    @Test
    fun testDuplicateCheckWithDuplicates() {
        val cards = listOf(
            Card(CardSuit.HEARTS, CardValue.ACE),
            Card(CardSuit.DIAMONDS, CardValue.KING)
        )
        val duplicateCard = Card(CardSuit.HEARTS, CardValue.ACE)
        assertThrows(IllegalArgumentException::class.java) {
            deckSanityService.duplicateCheck(cards, duplicateCard)
        }
    }

    @Test
    fun testSizeCheckValidSize() {
        val cards = List(52) { Card(CardSuit.HEARTS, CardValue.ACE) }
        assertDoesNotThrow {
            deckSanityService.sizeCheck(cards)
        }
    }

    @Test
    fun testSizeCheckInvalidSize() {
        val cards = List(51) { Card(CardSuit.HEARTS, CardValue.ACE) }
        assertThrows(IllegalArgumentException::class.java) {
            deckSanityService.sizeCheck(cards)
        }
    }
}