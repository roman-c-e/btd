import entity.Player

class StrategyService {


    fun hasBlackJack(player: Player): Boolean {
        return player.getScore() == 21
    }

    fun isBust(player: Player): Boolean {
        return player.getScore() > 21
    }

    fun shouldHit(player: Player): Boolean {
        return player.getScore() < 17
    }

}