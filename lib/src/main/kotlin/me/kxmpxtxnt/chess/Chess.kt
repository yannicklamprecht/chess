package me.kxmpxtxnt.chess

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.fen.save.lineup.LineupSaver

fun main() {
  val board = ChessBoard(fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w - - 0 0")

  with(board.lineup.keys.sortedBy { it.fieldID }) {
    this.forEach {
      println("|| $it || ${board.lineup[it]}")
    }
  }

  println(LineupSaver.save(board))
}