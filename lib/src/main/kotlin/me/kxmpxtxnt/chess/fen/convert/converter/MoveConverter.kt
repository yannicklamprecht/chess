package me.kxmpxtxnt.chess.fen.convert.converter

import me.kxmpxtxnt.chess.fen.convert.Converter

enum class Rule{
  DRAW,
  CONTINUE
}

class HalfMoveConverter : Converter<Pair<Rule, Int>> {

  override fun toFenString(input: Pair<Rule, Int>): String {
    TODO("Not yet implemented")
  }

  override fun fromFenString(fenPart: String): Pair<Rule, Int> {
    return when {
      fenPart.toIntOrNull() == null -> throw IllegalArgumentException("Entered halfmove argument is not a valid halfmove number.")
      fenPart.toInt() < 100 -> Pair(Rule.CONTINUE, fenPart.toInt())
      else -> Pair(Rule.DRAW, fenPart.toInt())
    }
  }
}

class FullMoveConverter : Converter<Int> {
  override fun toFenString(input: Int): String {
    TODO("Not yet implemented")
  }

  override fun fromFenString(fenPart: String): Int {
    return when {
      fenPart.toIntOrNull() == null -> throw IllegalArgumentException("Entered fullmove number is not valid.")
      else -> fenPart.toInt()
    }
  }
}
