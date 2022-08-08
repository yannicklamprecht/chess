package me.kxmpxtxnt.chess.fen.convert.converter

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.getPiece
import me.kxmpxtxnt.chess.board.isEmpty
import me.kxmpxtxnt.chess.fen.convert.Converter
import me.kxmpxtxnt.chess.piece.Piece

class LineupConverter(private val board: ChessBoard) : Converter<HashMap<Field, Piece>> {

  override fun toFenString(input: HashMap<Field, Piece>): String {
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

  override fun fromFenString(fenPart: String): HashMap<Field, Piece> {
    val lineup: HashMap<Field, Piece> = hashMapOf()

    var fieldId = 0

    fenPart.forEach { fenChar ->
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
