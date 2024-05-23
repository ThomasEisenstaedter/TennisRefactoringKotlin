class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var scorePlayer1: Int = 0
    private var scorePlayer2: Int = 0

    override fun wonPoint(playerName: String) =
        if (playerName == "player1") scorePlayer1 += 1 else scorePlayer2 += 1

    override fun getScore() =
        when {
            isTie() -> tie()
            playerAdvantage() -> advantage()
            playerWin() -> win()
            else -> gameStatus()
        }

    private fun isTie() = scorePlayer1 == scorePlayer2

    private fun tie(): String {
        val tie = when (scorePlayer1) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
        return tie
    }

    private fun playerAdvantage(): Boolean {
        val scoreDifference = scorePlayer1 - scorePlayer2
        return scorePlayer1 >= 4 && scoreDifference == 1|| scorePlayer2 >= 4 && scoreDifference == -1
    }
    private fun playerWin() = scorePlayer1 >= 4 || scorePlayer2 >= 4

    private fun advantage(): String {
        return when (scorePlayer1 - scorePlayer2) {
            1 -> "Advantage player1"
            -1 -> "Advantage player2"
            else -> ""
        }
    }

    private fun win(): String {
        val scoreDifference = scorePlayer1 - scorePlayer2
        return if (scoreDifference >= 2) {
            "Win for player1"
        } else {
            "Win for player2"
        }
    }

    private fun gameStatus(): String {
        val player1Status = PlayerStatus.fromInt(scorePlayer1).toString()
        val player2Status = PlayerStatus.fromInt(scorePlayer2).toString()
        return "$player1Status-$player2Status"
    }

}
