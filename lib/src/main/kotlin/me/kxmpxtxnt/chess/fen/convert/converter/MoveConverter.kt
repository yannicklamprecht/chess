package me.kxmpxtxnt.chess.fen.convert.converter

import me.kxmpxtxnt.chess.fen.convert.Converter

enum class Rule{
  DRAW,
  CONTINUE
}

class HalfMoveConverter : Converter<Pair<Rule, Int>, Pair<Rule, Int>> {

  override fun asString(input: Pair<Rule, Int>): String {
    TODO("Not yet implemented")
  }

  override fun fromString(input: String): Pair<Rule, Int> {
    return when {
      input.toIntOrNull() == null -> throw IllegalArgumentException("Entered halfmove argument is not a valid halfmove number.")
      input.toInt() < 100 -> Pair(Rule.CONTINUE, input.toInt())
      else -> Pair(Rule.DRAW, input.toInt())
    }
  }
}

class FullMoveConverter : Converter<Int, Int> {
  override fun asString(input: Int): String {
    TODO("Not yet implemented")
  }

  override fun fromString(input: String): Int {
    return when {
      input.toIntOrNull() == null -> throw IllegalArgumentException("Entered fullmove number is not valid.")
      else -> input.toInt()
    }
  }
}
