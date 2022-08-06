package me.kxmpxtxnt.chess.fen.fullmove

class FullMoveResult {

  companion object{
    fun of(fullMove: String): Int{
      return when {
        fullMove.toIntOrNull() == null -> throw IllegalArgumentException("Entered fullmove number is not valid.")
        else -> fullMove.toInt()
      }

    }
  }
}