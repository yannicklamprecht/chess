package me.kxmpxtxnt.chess.fen.load.fullmove

class FullMoveLoader {

  companion object{
    fun load(fullMove: String): Int{
      return when {
        fullMove.toIntOrNull() == null -> throw IllegalArgumentException("Entered fullmove number is not valid.")
        else -> fullMove.toInt()
      }

    }
  }
}