package me.kxmpxtxnt.chess.fen.save.lineup

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.getPiece
import me.kxmpxtxnt.chess.board.isEmpty

class LineupSaver {

  companion object{
    fun save(board: ChessBoard): String{
      val builder = StringBuilder()

      var skip = 0
      var id = 0

      var sequenceSkip = 0

      var pieceBeforeSkip = false

      (0..63).forEach { i ->
        val field = board.getField(i)

        if (field.isEmpty()) {
          skip++
          println(skip)
          if(skip == 8){
            builder.append("$skip/")
            skip = 0
          }
        }

        if (field.getPiece() != null) {
          builder.append("${field.getPiece()?.type?.fenChar}")
          pieceBeforeSkip = true

          if(sequenceSkip == 8){
            builder.append("/")
            sequenceSkip = 0
          }
        }

        id += skip + 1

        if(pieceBeforeSkip) skip = 0
        pieceBeforeSkip = false
        sequenceSkip++
      }
      return builder.toString()
    }
  }
}