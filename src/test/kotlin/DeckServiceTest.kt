import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.FileNotFoundException

class DeckServiceTest {

    @Test
    fun testCreateDeck() {
        val deckService = DeckService()
        val deck = deckService.createDeck()
        assertEquals(52, deck.getCards().size)
    }

    @Test
    fun testReadDeckFileNotFound() {
        val deckService = DeckService()
        val path = "path/to/nonexistent/file.txt"
        assertThrows(FileNotFoundException::class.java) {
            deckService.readDeck(path)
        }
    }
}