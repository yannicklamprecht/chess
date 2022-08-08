package me.kxmpxtxnt.chess.fen.convert

interface Converter<Any> {

  fun toFenString(input: Any): String
  fun fromFenString(fenPart: String): Any?
}
