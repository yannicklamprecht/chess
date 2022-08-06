package me.kxmpxtxnt.chess.board.field

import me.kxmpxtxnt.chess.board.ChessBoard

class Field(val x: String, val  y: Int, val fieldID: Int, val color: FieldColor, val board: ChessBoard) {

  init {
    if(y > 7 || !"abcdefgh".contains(x)){
      throw IllegalArgumentException("Field must be in correct order. [a-h] & [0-7]")
    }
  }
}