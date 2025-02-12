package entity

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PlayerTest {

    @Test
    fun testAddCard() {
        val player = Player("TestPlayer")
        val card = Card(CardSuit.HEARTS, CardValue.ACE)
        player.addCard(card)
        assertEquals("HA", player.printHand())
    }

    @Test
    fun testToString() {
        val player = Player("TestPlayer")
        assertEquals("TestPlayer", player.toString())
    }

    @Test
    fun testGetHand() {
        val player = Player("TestPlayer")
        val card1 = Card(CardSuit.HEARTS, CardValue.ACE)
        val card2 = Card(CardSuit.SPADES, CardValue.KING)
        player.addCard(card1)
        player.addCard(card2)
        assertEquals("HA, SK", player.printHand())
    }

    @Test
    fun testGetScoreBlackJack() {
        val player = Player("TestPlayer")
        val card1 = Card(CardSuit.HEARTS, CardValue.ACE)
        val card2 = Card(CardSuit.SPADES, CardValue.KING)
        player.addCard(card1)
        player.addCard(card2)
        assertEquals(21, player.getScore())
    }

    @Test
    fun testGetScoreTooHigh() {
        val player = Player("TestPlayer")
        val card1 = Card(CardSuit.HEARTS, CardValue.ACE)
        val card2 = Card(CardSuit.SPADES, CardValue.ACE)
        player.addCard(card1)
        player.addCard(card2)
        assertEquals(22, player.getScore())
    }
}