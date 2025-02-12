package service

import entity.CardSuit
import entity.CardValue
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CardServiceTest {

    private val cardService = CardService()

    @Test
    fun testCreateCardValid() {
        val card = cardService.createCard("HA")
        assertEquals(CardSuit.HEARTS, card.getCardSuit())
        assertEquals(CardValue.ACE, card.getCardValue())
    }

    @Test
    fun testCreateCardInvalidSuit() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            cardService.createCard("XA")
        }
        assertEquals("Invalid card suit", exception.message)
    }

    @Test
    fun testCreateCardInvalidValue() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            cardService.createCard("HZ")
        }
        assertEquals("Invalid card value", exception.message)
    }
}