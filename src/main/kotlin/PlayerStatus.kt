enum class PlayerStatus(val tempScore: Int) {

    Love(0),
    Fifteen(1),
    Thirty(2),
    Forty(3);

    companion object {
        fun fromInt(value: Int) = PlayerStatus.values().first { it.tempScore == value }
    }
}