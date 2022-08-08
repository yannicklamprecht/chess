package me.kxmpxtxnt.chess.fen.convert.converter

import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.convert.Converter

class CastleConverter : Converter<List<Pair<FieldColor, CastleConverter.Side>>> {

  enum class Side(val indicatorWhite: String, val indicatorBlack: String, val color: FieldColor) {
    QUEENSIDE("Q", "K", FieldColor.WHITE),
    KINGSIDE("q", "k", FieldColor.BLACK)
  }

  override fun toFenString(input: List<Pair<FieldColor, Side>>): String {
    TODO("Not yet implemented")
  }

  override fun fromFenString(fenPart: String): List<Pair<FieldColor, Side>> {
    return if (fenPart == "-") {
      emptyList()
    } else {
      val castles = arrayListOf<Pair<FieldColor, Side>>()

      fenPart.forEach { char ->
        Side.values().forEach { side ->
          when (char.toString() ) {
            side.indicatorBlack -> {
              castles.add(Pair(side.color, side))
            }

            side.indicatorWhite -> {
              castles.add(Pair(side.color, side))
            }
          }
        }
      }

      castles
    }
  }
}

  /*
      "-"
      "QkqK"
      "QK"
      "qk"
      "qK"
      "Qk"
      "Q"
      "K"
      "q"
      "k"
   */
