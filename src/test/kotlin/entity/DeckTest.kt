package entity

import DeckService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DeckTest {

    @Test
    fun testCreateDeck() {
        val deckService = DeckService()
        val deck = deckService.createDeck()
        assertEquals(52, deck.getCards().size)
    }

    @Test
    fun testDraw() {
        val deckService = DeckService()
        val deck = deckService.createDeck()
        val card = deck.draw()
        assertNotNull(card)
        assertEquals(51, deck.getCards().size)
    }

    @Test
    fun testShuffle() {
        val deckService = DeckService()
        val deck = deckService.createDeck()
        val originalOrder = deck.getCards().toList()
        deck.shuffle()
        val shuffledOrder = deck.getCards()
        assertNotEquals(originalOrder, shuffledOrder)
    }

    @Test
    fun testToString() {
        val deckService = DeckService()
        val deck = deckService.createDeck()
        assertNotNull(deck.toString())
    }
}