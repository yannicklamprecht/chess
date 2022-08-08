package me.kxmpxtxnt.chess.fen.convert.converter

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.fen.convert.Converter

class EnpassentConverter(private val board: ChessBoard) : Converter<Field> {

  override fun toFenString(input: Field): String {
    TODO()
  }

  override fun fromFenString(fenPart: String): Field? {
    if(fenPart == "-") return null

    if(!("abcdefgh".contains(fenPart[0].lowercase()) && fenPart[1].digitToInt() in 3..6)){
      throw IllegalArgumentException("Entered en passent is not valid. Valid en passent: a3, h6")
    }
    return board.getField(fenPart)
  }

}
