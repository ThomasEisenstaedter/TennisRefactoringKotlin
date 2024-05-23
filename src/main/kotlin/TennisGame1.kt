class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var scorePlayer1: Int = 0
    private var scorePlayer2: Int = 0

    override fun wonPoint(playerName: String) =
        if (playerName == "player1") scorePlayer1 += 1 else scorePlayer2 += 1

    override fun getScore() =
        when {
            isTie() -> tie()
            playerAdvantage() -> advantageOrWinOfPlayer()
            else -> gameStatus()
        }

    private fun isTie() = scorePlayer1 == scorePlayer2

    private fun gameStatus(): String {
        val player1Status = PlayerStatus.fromInt(scorePlayer1).toString()
        val player2Status = PlayerStatus.fromInt(scorePlayer2).toString()
        return "$player1Status-$player2Status"
    }

    private fun advantageOrWinOfPlayer(): String {
        val scoreDifference = scorePlayer1 - scorePlayer2
        val advantageOrWinOfPlayer = when {
            scoreDifference == 1 -> "Advantage player1"
            scoreDifference == -1 -> "Advantage player2"
            scoreDifference >= 2 -> "Win for player1"
            else -> "Win for player2"
        }
        return advantageOrWinOfPlayer
    }

    private fun playerAdvantage() = scorePlayer1 >= 4 || scorePlayer2 >= 4

    private fun tie(): String {
        val tie = when (scorePlayer1) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
        return tie
    }
}
