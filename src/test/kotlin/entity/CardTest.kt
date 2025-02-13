package entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardTest {

    @Test
    fun testGetCardSuit() {
        val card = Card(CardSuit.HEARTS, CardValue.ACE)
        assertEquals(CardSuit.HEARTS, card.getCardSuit())
    }

    @Test
    fun testGetCardValue() {
        val card = Card(CardSuit.HEARTS, CardValue.ACE)
        assertEquals(CardValue.ACE, card.getCardValue())
    }

    @Test
    fun testHeartsAce() {
        val card = Card(CardSuit.HEARTS, CardValue.ACE)
        assertEquals(11, card.getValue()) // Assuming value of ACE is 11
    }

    @Test
    fun testHeartsKing() {
        val card = Card(CardSuit.HEARTS, CardValue.KING)
        assertEquals(10, card.getValue())
    }

    @Test
    fun testHeartsQueen() {
        val card = Card(CardSuit.HEARTS, CardValue.QUEEN)
        assertEquals(10, card.getValue())
    }

    @Test
    fun testHeartsJack() {
        val card = Card(CardSuit.HEARTS, CardValue.JACK)
        assertEquals(10, card.getValue())
    }

    @Test
    fun testHearts2() {
        val card = Card(CardSuit.HEARTS, CardValue.TWO)
        assertEquals(2, card.getValue())
    }

    @Test
    fun testHeartsAceToString() {
        val card = Card(CardSuit.HEARTS, CardValue.ACE)
        assertEquals("HA", card.toString())
    }
}