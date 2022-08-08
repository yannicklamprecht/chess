package me.kxmpxtxnt.chess.fen.convert.converter

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.convert.Converter

class TurnConverter(private val board: ChessBoard): Converter<FieldColor, FieldColor> {

  override fun asString(input: FieldColor): String {
    return when(input){
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
