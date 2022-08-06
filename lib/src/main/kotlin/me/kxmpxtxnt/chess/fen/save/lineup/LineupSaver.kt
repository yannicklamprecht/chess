package me.kxmpxtxnt.chess.fen.save.lineup

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.getPiece
import me.kxmpxtxnt.chess.board.isEmpty

class LineupSaver {

  companion object {
    fun save(board: ChessBoard): String {
      val builder = StringBuilder()

      var skip = 0
      var sequenceSkip = 0

      board.forEachIndexed { index, field ->
        sequenceSkip++
        if (field.isEmpty()) {
          skip++
          if (skip == board.boardSideSize()) {
            builder.append("$skip")
            skip = 0
          }
        } else {
          if (skip > 0) {
            builder.append(skip)
          }
          builder.append(field.getPiece()?.type?.fenChar)
          skip = 0
        }
        if (sequenceSkip == board.boardSideSize() && index < board.elementSize() - 1) {
          builder.append("/")
          sequenceSkip = 0
        }
      }
      return builder.toString()
    }
  }
}
