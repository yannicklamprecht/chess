package me.kxmpxtxnt.chess.lib.fen.convert.converter

import me.kxmpxtxnt.chess.lib.board.ChessBoard
import me.kxmpxtxnt.chess.lib.board.field.Field
import me.kxmpxtxnt.chess.lib.fen.convert.Converter

class EnpassentConverter(private val board: ChessBoard) : Converter<Field, Field> {

  override fun asString(input: Field): String {
    TODO()
  }

  override fun fromString(input: String): Field? {
    if(input == "-") return null

    if(!("abcdefgh".contains(input[0].lowercase()) && input[1].digitToInt() in 3..6)){
      throw IllegalArgumentException("Entered en passent is not valid. Valid en passent: a3, h6")
    }
    return board.getField(input)
  }

}
