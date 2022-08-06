package me.kxmpxtxnt.chess.fen.save.turn

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.FieldColor

class TurnSaver {

  companion object{
    fun save(board: ChessBoard): String{
      return when(board.turn){
        FieldColor.WHITE -> "w"
        else -> "b"
      }
    }
  }
}