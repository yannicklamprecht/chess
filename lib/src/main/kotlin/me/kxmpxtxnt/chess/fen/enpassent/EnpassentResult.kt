package me.kxmpxtxnt.chess.fen.enpassent

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.Field

class EnpassentResult {

  companion object {
    fun of(passent: String, board: ChessBoard): Field?{
      if(passent == "-") return null

      if(!("abcdefgh".contains(passent[0].lowercase()) && passent[1].digitToInt() in 3..6)){
        throw IllegalArgumentException("Entered en passent is not valid. Valid en passent: a3, h6")
      }
      return board.getField(passent)
    }
  }
}