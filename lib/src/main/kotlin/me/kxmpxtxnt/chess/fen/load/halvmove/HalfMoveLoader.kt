package me.kxmpxtxnt.chess.fen.load.halvmove

class HalfMoveLoader {

  companion object{
    fun load(halfMove: String): Pair<Rule, Int>{
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