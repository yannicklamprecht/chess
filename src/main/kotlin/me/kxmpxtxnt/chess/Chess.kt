package me.kxmpxtxnt.chess

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.fields
import me.kxmpxtxnt.chess.board.getPiece
import me.kxmpxtxnt.chess.fen.fromFen

fun main(args: Array<String>){
  val board = ChessBoard("r1b1k1nr/p2p1pNp/n2B4/1p1NP2P/6P1/3P1Q2/P1P1K3/q5b1  b KQkq - 0 0")

  println(fields.size)

  fields.forEach{
    println("Field ${it.fieldID} : [${it.x}|${it.y}|${it.color}]")
  }

  val lineup = fromFen(board.fen)

  println(lineup.lineup.keys.size)
  println(lineup.lineup.values.size)

  println(lineup.turn)
}