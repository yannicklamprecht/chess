package me.kxmpxtxnt.chess

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.fen.convert.Converters

fun main() {
  Converters.castleConverter().fromFenString("q").forEach {
    println("${it.first} - ${it.second}")
  }
}
