package me.kxmpxtxnt.chess.fen.halvmove

class HalfMoveResult {

  companion object{
    fun of(halfMove: String): Pair<Rule, Int>{
      return when {
        halfMove.toIntOrNull() == null -> throw IllegalArgumentException("Entered halfmove argument is not a valid halfmove number.")
        halfMove.toInt() < 100 -> Pair(Rule.CONTINUE, halfMove.toInt())
        else -> Pair(Rule.DRAW, halfMove.toInt())
      }
    }
  }

  enum class Rule{
    DRAW,
    CONTINUE
  }
}