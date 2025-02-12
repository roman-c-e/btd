package service

import entity.Deck
import entity.Player
import kotlin.system.exitProcess

class BlackJackService {

    private val dealer = Player("dealer")
    private val sam = Player("sam")
    private var deck: Deck

    constructor() {
        deck = DeckService().createDeck()
        deck.shuffle()
        startGame()
    }

    constructor(path: String) {
        deck = DeckService().readDeck(path)
        startGame()
    }

    fun startGame() {
        dealPlayer(sam)
        dealPlayer(dealer)
        dealPlayer(sam)
        dealPlayer(dealer)

        playRound()
    }

    fun getSam(): Player {
        return sam
    }

    fun getDealer(): Player {
        return dealer
    }

    private fun dealPlayer(player: Player) {
        player.addCard(deck.draw())
    }

    private fun playRound() {
        if (StrategyService().hasBlackJack(sam)) {
            printWinner(sam)
        }
        if (StrategyService().hasBlackJack(dealer)) {
            printWinner(dealer)
        }
        if (StrategyService().isBust(sam)) {
            printWinner(dealer)
        }
        if (StrategyService().isBust(dealer)) {
            printWinner(sam)
        }
        if (StrategyService().shouldHit(sam)) {
            dealPlayer(sam)
            playRound()
        }

        if (dealer.getScore() > sam.getScore()) {
            printWinner(dealer)
        }

        dealPlayer(dealer)
        playRound()
    }

    fun printWinner(player: Player) {
        println(player)
        println("$sam: ${sam.printHand()}")
        println("$dealer: ${dealer.printHand()}")
        exitProcess(1)
    }
}