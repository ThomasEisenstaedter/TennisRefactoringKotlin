class TennisGame1(private val player1Name: String, private val player2Name: String) : TennisGame {

    private var scorePlayer1: Int = 0
    private var scorePlayer2: Int = 0

    override fun wonPoint(playerName: String) =
        if (playerName === "player1") scorePlayer1 += 1 else scorePlayer2 += 1

    override fun getScore(): String {
        var score = ""
        var tempScore: Int
        if (scorePlayer1 == scorePlayer2) {
            score = tie()
        } else if (onePlayerHas4OrMorePoints()) {
            val minusResult = scorePlayer1 - scorePlayer2
            score = when {
                minusResult == 1 -> "Advantage player1"
                minusResult == -1 -> "Advantage player2"
                minusResult >= 2 -> "Win for player1"
                else -> "Win for player2"
            }
        } else {
            for (i in 1..2) {
                if (i == 1)
                    tempScore = scorePlayer1
                else {
                    score += "-"
                    tempScore = scorePlayer2
                }
                when (tempScore) {
                    0 -> score += "Love"
                    1 -> score += "Fifteen"
                    2 -> score += "Thirty"
                    3 -> score += "Forty"
                }
            }
        }
        return score
    }

    private fun onePlayerHas4OrMorePoints() = scorePlayer1 >= 4 || scorePlayer2 >= 4

    private fun tie(): String {
        val score1: String = when (scorePlayer1) {
            0 -> "Love-All"
            1 -> "Fifteen-All"
            2 -> "Thirty-All"
            else -> "Deuce"
        }
        return score1
    }
}
