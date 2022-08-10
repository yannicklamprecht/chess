package me.kxmpxtxnt.chess.lib.fen.convert.converter

import me.kxmpxtxnt.chess.lib.board.ChessBoard
import me.kxmpxtxnt.chess.lib.board.field.FieldColor
import me.kxmpxtxnt.chess.lib.fen.convert.Converter

class TurnConverter(private val board: ChessBoard): Converter<FieldColor, FieldColor> {

  override fun asString(): String? {
    return when(board.turn){
      FieldColor.WHITE -> "w"
      else -> "b"
    }
  }

  override fun fromString(input: String): FieldColor {
    return when(input){
      "w" -> FieldColor.WHITE
      "b" -> FieldColor.BLACK
      else -> throw IllegalArgumentException("Entered turn is not valid: b or w!")
    }
  }
}
