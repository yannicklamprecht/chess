package me.kxmpxtxnt.chess

import me.kxmpxtxnt.chess.fen.convert.Converters

fun main() {
  Converters.castleConverter().fromString("q").forEach {
    println("${it.first} - ${it.second}")
  }
}
