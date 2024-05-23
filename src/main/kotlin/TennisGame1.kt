class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var scorePlayer1: Int = 0
    private var scorePlayer2: Int = 0

    override fun wonPoint(playerName: String) =
        if (playerName == "player1") scorePlayer1 += 1 else scorePlayer2 += 1

    override fun getScore(): String {
        var score = ""
        if (scorePlayer1 == scorePlayer2) {
            score = tie()
        } else if (onePlayerHas4OrMorePoints()) {
            val scoreDifference = scorePlayer1 - scorePlayer2
            score = advantageOrWinOf(scoreDifference)
        } else {
            score += PlayerStatus.fromInt(scorePlayer1).toString()
            score += "-"
            score += PlayerStatus.fromInt(scorePlayer2).toString()
        }
        return score
    }

    private fun gameStatus(): String {
        val player1Status = PlayerStatus.fromInt(scorePlayer1).toString()
        val player2Status = PlayerStatus.fromInt(scorePlayer2).toString()
        return "$player1Status-$player2Status"
    }

    private fun advantageOrWinOf(minusResult: Int): String {
        val advantageOrWinOfPlayer = when {
            minusResult == 1 -> "Advantage player1"
            minusResult == -1 -> "Advantage player2"
            minusResult >= 2 -> "Win for player1"
            else -> "Win for player2"
        }
        return advantageOrWinOfPlayer
    }

    private fun onePlayerHas4OrMorePoints() = scorePlayer1 >= 4 || scorePlayer2 >= 4

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
