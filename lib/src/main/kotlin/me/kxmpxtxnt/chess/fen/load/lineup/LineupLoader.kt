package me.kxmpxtxnt.chess.fen.load.lineup

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.piece.Piece

class LineupLoader {

  companion object{

    private val lineup: HashMap<Field, Piece> = hashMapOf()

    fun load(positions: String, board: ChessBoard): HashMap<Field, Piece>{
      var fieldId = 0

      positions.forEach { fenChar ->
        if (fieldId == 64) {
          return@forEach
        }
        if (Character.isSpaceChar(fenChar)) {
          return@forEach
        }

        if (fenChar.isDigit()) {
          val skip = fenChar.digitToInt()
          fieldId += skip
          return@forEach
        }

        for (type in Piece.Type.values()) {
          if (type.fenChar.first() == fenChar) {
            for (field in board.fields) {
              if (field.fieldID == fieldId) {
                lineup[field] = Piece(type, board)
              }
            }
            fieldId++
          }
        }
      }
      return lineup
    }
  }

  class TurnResult{
    companion object{
      fun load(turn: String): FieldColor{
        return when (turn.lowercase().trim()) {
          "b" -> FieldColor.BLACK
          "w" -> FieldColor.WHITE
          else -> FieldColor.WHITE
        }
      }
    }
  }
}