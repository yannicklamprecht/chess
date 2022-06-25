package me.kxmpxtxnt.chess.board

import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.piece.Piece
import java.awt.Color

class ChessBoard(val fen: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 0") {

  var lineup: HashMap<Field, Piece> = HashMap()
  var fields = arrayListOf<Field>()

  init {
    initBoard()
  }

  fun getPiece(field: Field): Piece? {
    return lineup[field]
  }

  fun getField(id: Int): Field?{
    if(id > 63) return null
    for(field in fields){
      if(id == field.fieldID){
        return field
      }
    }
    return null
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
    var fieldID = 0
    var c = false
    var color: FieldColor
    for (field in 0..7) {
      for (column in 0..7) {
        if(c){
          color = FieldColor.WHITE
        } else {
          color = FieldColor.BLACK
        }
        when (column) {
          7 -> fields.add(Field("a", row, fieldID, color))
          6 -> fields.add(Field("b", row, fieldID, color))
          5 -> fields.add(Field("c", row, fieldID, color))
          4 -> fields.add(Field("d", row, fieldID, color))
          3 -> fields.add(Field("e", row, fieldID, color))
          2 -> fields.add(Field("f", row, fieldID, color))
          1 -> fields.add(Field("g", row, fieldID, color))
          0 -> fields.add(Field("h", row, fieldID, color))
        }
        c = !c
        fieldID++
      }
      row--

      if (row == 0) {
        row = 7
      }
    }

    fields.sortBy { it.fieldID }
  }

  fun Piece.isOut(): Boolean {
    return getField(this) == null
  }

  fun Field.isEmpty(): Boolean {
    return lineup[this] == null
  }
}