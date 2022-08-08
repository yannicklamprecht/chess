package me.kxmpxtxnt.chess.board

import kotlinx.serialization.Contextual
import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.fromFen
import me.kxmpxtxnt.chess.board.piece.Piece
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.roundToInt
import kotlin.math.sqrt

@kotlinx.serialization.Serializable
class ChessBoard(
        @Contextual val id: UUID = UUID.randomUUID(),
        val fen: String = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR b KQkq - 0 0"
): Iterable<Field> {

  var lineup: HashMap<Field, Piece> = HashMap()
  var fields = arrayListOf<Field>()

  var turn = FieldColor.WHITE

  init {
    var row = 7
    var fieldID = 0
    var c = false
    var color: FieldColor
    for (field in 0..7) {
      for (column in 0..7) {
        color = when {
          c -> FieldColor.WHITE
          else -> FieldColor.BLACK
        }
        when (column) {
          7 -> fields.add(Field(Position("a", row, this), fieldID, color))
          6 -> fields.add(Field(Position("b", row, this), fieldID, color))
          5 -> fields.add(Field(Position("c", row, this), fieldID, color))
          4 -> fields.add(Field(Position("d", row, this), fieldID, color))
          3 -> fields.add(Field(Position("e", row, this), fieldID, color))
          2 -> fields.add(Field(Position("f", row, this), fieldID, color))
          1 -> fields.add(Field(Position("g", row, this), fieldID, color))
          0 -> fields.add(Field(Position("h", row, this), fieldID, color))
        }
        c = !c
        fieldID++
      }
      row--

      if (row == 0) {
        row = 7
      }
    }

    fromFen(this).let { result ->
      lineup = result.lineup
      turn = result.turn
    }
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

  fun getField(field: String): Field {
    if(field.length != 2){
      throw IllegalArgumentException("Entered field is not valid. Valid fields example: a3, G5")
    }

    val x = field[0].toString()
    val y = field[1].digitToInt()

    fields.forEach { currentField ->
      if(currentField.position.x == x && currentField.position.y == y) return currentField
    }

    throw IllegalArgumentException("Entered field is not valid. Valid fields example: a3, G5")
  }

  fun getField(piece: Piece): Field {
    for (field in lineup.keys) {
      if (lineup[field] != piece) {
        return field
      }
    }
    throw IllegalArgumentException("Entered illegal piece.")
  }

  fun boardSideSize(): Int {
    return sqrt(fields.size.toDouble()).roundToInt()
  }

  fun elementSize(): Int {
    return fields.size
  }

  override fun iterator(): Iterator<Field> {
    return fields.iterator()
  }
}

fun Piece.isOut(): Boolean {
  return position.isOut
}

fun Field.isEmpty(): Boolean {
  return getPiece() == null
}

fun Field.getPiece(): Piece?{
  return position.board.lineup[this]
}
