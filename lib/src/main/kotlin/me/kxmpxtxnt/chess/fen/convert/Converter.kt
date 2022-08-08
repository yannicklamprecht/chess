package me.kxmpxtxnt.chess.fen.convert

interface Converter<Input, Output> {

  fun asString(input: Input): String
  fun fromString(input: String): Output?
}
