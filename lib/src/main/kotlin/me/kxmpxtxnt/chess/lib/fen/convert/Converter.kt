package me.kxmpxtxnt.chess.lib.fen.convert

interface Converter<Input, Output> {

  fun asString(input: Input): String? = null
  fun asString(): String? = null
  fun fromString(input: String): Output?{
    return null
  }
  fun fromString(input: Input): Output? {
    return null
  }
}
