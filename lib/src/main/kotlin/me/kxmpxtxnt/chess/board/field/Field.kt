package me.kxmpxtxnt.chess.board.field

import me.kxmpxtxnt.chess.board.ChessBoard

data class Field(val x: String, val  y: Int, val fieldID: Int, val color: FieldColor, val board: ChessBoard) {

  init {
    if(y > 7 || !"abcdefgh".contains(x.lowercase())){
      throw IllegalArgumentException("Field must be in correct order. [a-h] & [0-7]")
    }
  }

  override fun toString(): String {
    val id = board.id.toString().substring(0..5)
    return "[$id] - $x | $y - $fieldID - $color"
  }
}
