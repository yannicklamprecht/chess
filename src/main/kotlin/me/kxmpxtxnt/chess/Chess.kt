package me.kxmpxtxnt.chess

import me.kxmpxtxnt.chess.board.ChessBoard

fun main(args: Array<String>){
  val board = ChessBoard()

  println(board.fields.size)

  board.fields.forEach{
    println("Field ${it.fieldID} : [${it.x}|${it.y}|${it.color}]")
  }
}