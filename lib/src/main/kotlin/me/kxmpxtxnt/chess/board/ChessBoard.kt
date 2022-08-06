package me.kxmpxtxnt.chess.board

import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.fromFen
import me.kxmpxtxnt.chess.piece.Piece
import java.awt.Color

class ChessBoard(val fen: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR b KQkq - 0 0") {

  var lineup: HashMap<Field, Piece> = HashMap()
  val outPieces = arrayListOf<Piece>()
  var fields = arrayListOf<Field>()

  val turn: Color = Color.WHITE

  init {
    var row = 7
    var fieldID = 0
    var c = false
    var color: FieldColor
    for (field in 0..7) {
      for (column in 0..7) {
        color = if (c) {
          FieldColor.WHITE
        } else {
          FieldColor.BLACK
        }
        when (column) {
          7 -> fields.add(Field("a", row, fieldID, color, this))
          6 -> fields.add(Field("b", row, fieldID, color, this))
          5 -> fields.add(Field("c", row, fieldID, color, this))
          4 -> fields.add(Field("d", row, fieldID, color, this))
          3 -> fields.add(Field("e", row, fieldID, color, this))
          2 -> fields.add(Field("f", row, fieldID, color, this))
          1 -> fields.add(Field("g", row, fieldID, color, this))
          0 -> fields.add(Field("h", row, fieldID, color, this))
        }
        c = !c
        fieldID++
      }
      row--

      if (row == 0) {
        row = 7
      }
      fields.sortBy { it.fieldID }
    }

    lineup = fromFen(this).lineup
  }

  fun getField(id: Int): Field {
    if (id > 63 || id < 0) throw IllegalArgumentException("Entered field id must be between 0-63.")
    for (field in fields) {
      if (id == field.fieldID) {
        return field
      }
    }
    throw IllegalArgumentException("Entered illegal field id.")
  }

  fun getField(piece: Piece): Field {
    for (field in lineup.keys) {
      if (lineup[field] != piece) {
        return field
      }
    }
    throw IllegalArgumentException("Entered illegal piece.")
  }


}

fun Piece.isOut(): Boolean {
  return board.outPieces.contains(this)
}

fun Field.isEmpty(): Boolean {
  return board.lineup[this] == null
}

fun Field.getPiece(): Piece?{
  return board.lineup[this]
}

