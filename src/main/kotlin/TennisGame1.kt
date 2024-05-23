class TennisGame1 : TennisGame {

    private var scorePlayer1: Int = 0
    private var scorePlayer2: Int = 0

    override fun wonPoint(playerName: String) =
        if (playerName == "player1") {
            scorePlayer1 += 1
        } else {
            scorePlayer2 += 1
        }

    override fun getScore() =
        when {
            isTie() -> tie()
            hasAdvantage() -> advantage()
            hasWon() -> won()
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

    private fun hasAdvantage() =
        scorePlayer1 >= 4 && difference() == 1 || scorePlayer2 >= 4 && difference() == -1

    private fun hasWon() = scorePlayer1 >= 4 || scorePlayer2 >= 4

    private fun advantage() = when {
        difference() == 1 -> "Advantage player1"
        difference() == -1 -> "Advantage player2"
        else -> ""
    }

    private fun won() = when {
        difference() >= 2 -> "Win for player1"
        difference() <= -2 -> "Win for player2"
        else -> ""
    }

    private fun difference() = scorePlayer1 - scorePlayer2

    private fun gameStatus(): String {
        val player1Status = PlayerStatus.fromInt(scorePlayer1).toString()
        val player2Status = PlayerStatus.fromInt(scorePlayer2).toString()
        return "$player1Status-$player2Status"
    }

}
