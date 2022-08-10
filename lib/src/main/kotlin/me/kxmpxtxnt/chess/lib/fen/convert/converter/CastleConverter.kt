package me.kxmpxtxnt.chess.lib.fen.convert.converter

import me.kxmpxtxnt.chess.lib.board.field.FieldColor
import me.kxmpxtxnt.chess.lib.fen.convert.Converter

class CastleConverter : Converter<List<CastleConverter.Side>, List<CastleConverter.Side>> {

  enum class Side(val indicator: String, val color: FieldColor) {
    WHITE_QUEEN_SIDE("Q",  FieldColor.WHITE),
    WHITE_KING_SIDE("K", FieldColor.WHITE),
    BLACK_QUEEN_SIDE("q",  FieldColor.BLACK),
    BLACK_KING_SIDE("k", FieldColor.BLACK),
  }

  override fun asString(input: List<Side>): String {
    TODO()
  }

  override fun fromString(input: String): List<Side> {
    arrayListOf<Side>().run {
      for(c in input) Side.values().forEach { side ->
        if(side.indicator == c.toString()){
          add(side)
        }
      }

      return this
    }
  }

}
