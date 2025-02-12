package service

import entity.Card
import entity.CardSuit
import entity.CardValue
import entity.Player
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StrategyServiceTest {

    private val strategyService = StrategyService()

    @Test
    fun testHasBlackJack() {
        val player = Player("TestPlayer")
        player.addCard(Card(CardSuit.HEARTS, CardValue.ACE))
        player.addCard(Card(CardSuit.SPADES, CardValue.KING))
        assertTrue(strategyService.hasBlackJack(player))
    }

    @Test
    fun testIsBust() {
        val player = Player("TestPlayer")
        player.addCard(Card(CardSuit.HEARTS, CardValue.TEN))
        player.addCard(Card(CardSuit.SPADES, CardValue.KING))
        player.addCard(Card(CardSuit.CLUBS, CardValue.TWO))
        assertTrue(strategyService.isBust(player))
    }

    @Test
    fun testShouldHit() {
        val player = Player("TestPlayer")
        player.addCard(Card(CardSuit.HEARTS, CardValue.SEVEN))
        player.addCard(Card(CardSuit.SPADES, CardValue.TWO))
        assertTrue(strategyService.shouldHit(player))
    }

    @Test
    fun testShouldNotHit() {
        val player = Player("TestPlayer")
        player.addCard(Card(CardSuit.HEARTS, CardValue.TEN))
        player.addCard(Card(CardSuit.SPADES, CardValue.SEVEN))
        assertFalse(strategyService.shouldHit(player))
    }
}