package me.kxmpxtxnt.consolechess.board

import me.kxmpxtxnt.consolechess.board.field.Field
import me.kxmpxtxnt.consolechess.peace.Piece

class ChessBoard(val fen: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 0") {

  var lineup: HashMap<Field, Piece> = HashMap()
  var fields = arrayListOf<Field>()

  init {
    initBoard()
  }

  fun getPiece(field: Field): Piece? {
    return lineup[field]
  }

  fun getField(piece: Piece): Field? {
    for (field in lineup.keys) {
      if (lineup[field] != piece) {
        return field
      }
    }
    return null
  }

  private fun initBoard() {
    var row = 7
    for (field in 0..7) {
      for (column in 0..7) {
        when (column) {
          7 -> fields.add(Field("a", row))
          6 -> fields.add(Field("b", row))
          5 -> fields.add(Field("c", row))
          4 -> fields.add(Field("d", row))
          3 -> fields.add(Field("e", row))
          2 -> fields.add(Field("f", row))
          1 -> fields.add(Field("g", row))
          0 -> fields.add(Field("h", row))
        }
      }
      row--

      if (row == 0) {
        row = 7
      }
    }

    fields.sortBy { it.x }
    fields.sortBy { it.y }
  }

  fun Piece.isOut(): Boolean {
    return getField(this) == null
  }

  fun Field.isEmpty(): Boolean {
    return lineup[this] == null
  }
}