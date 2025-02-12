import entity.*

import org.junit.jupiter.api.BeforeEach
import org.mockito.Mockito.*

class BlackJackServiceTest {

    private lateinit var deck: Deck
    private lateinit var blackJackService: BlackJackService

    @BeforeEach
    fun setUp() {
        deck = mock(Deck::class.java)
        blackJackService = BlackJackService()
    }

}