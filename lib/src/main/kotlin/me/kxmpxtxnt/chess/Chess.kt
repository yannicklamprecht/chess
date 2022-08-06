package me.kxmpxtxnt.chess

import me.kxmpxtxnt.chess.board.ChessBoard

fun main() {
  val board = ChessBoard(fen = "r1b1k1nr/p2p1pNp/n2B4/1p1NP2P/6P1/3P1Q2/P1P1K3/q5b1 w kQ e6 0 1")

  println(board.fenResult.fullMove)
}