package me.kxmpxtxnt.chess.lib

import me.kxmpxtxnt.chess.lib.fen.convert.Converters

fun main() {
  Converters.castleConverter().fromString("-").forEach {
    println(it)
  }
}
