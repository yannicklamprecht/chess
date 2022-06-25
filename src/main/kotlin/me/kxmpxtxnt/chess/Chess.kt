package me.kxmpxtxnt.consolechess

import me.kxmpxtxnt.consolechess.board.ChessBoard
import me.kxmpxtxnt.consolechess.fen.validateFen
import me.kxmpxtxnt.consolechess.peace.PieceType

fun main(args: Array<String>){
  val board = ChessBoard()

  println(board.fields.size)

  board.fields.forEach{
    println("Field [${it.x}|${it.y}]")
  }
}