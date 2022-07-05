package me.kxmpxtxnt.chess.fen

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.board.fields
import me.kxmpxtxnt.chess.piece.Piece
import java.awt.Color
import java.util.regex.Matcher
import java.util.regex.Pattern

fun toFen(board: ChessBoard): String {
  if(!validateFen(board.fen)){
    throw IllegalArgumentException("FEN (Forsyth-Edwards Notation) in the board is invalid. [${board.fen}]")
  }

  return ""
}

fun fromFen(fen: String): FenResult {
  if(!validateFen(fen)) throw IllegalArgumentException("Entered FEN (Forsyth-Edwards Notation) is not valid. [$fen]")

  val lineup: HashMap<Field, Piece> = hashMapOf()

  val fenParts = fen.split(" ")

  val positions = fenParts[0]
  val turn: FieldColor = when(fenParts[1].trim().lowercase()){
    "b" -> FieldColor.BLACK
    "w" -> FieldColor.WHITE
    else -> FieldColor.WHITE
  }

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
      println("Skipped $skip fields.")
      fieldId += skip
      return@forEach
    }

    for (type in Piece.Type.values()) {
      if (type.fenChar.first() == fenChar) {
        println("Piece ${type.name} at fieldID: $fieldId")
        for(field in fields){
          if(field.fieldID == fieldId){
            lineup[field] = Piece(type)
          }
        }
        fieldId++
      }
    }
  }

  return FenResult(lineup, turn)
}

fun validateFen(fen: String): Boolean{
  val pattern: Pattern = Pattern.compile(FEN_REGEX)
  val matcher: Matcher = pattern.matcher(fen)
  return matcher.matches()
}

private const val FEN_REGEX =
    "^(?<PiecePlacement>((?<RankItem>[pnbrqkPNBRQK1-8]{1,8})/?){8})" +
    "\\s+" +
    "(?<SideToMove>[bw])" +
    "\\s+" +
    "(?<Castling>-|K?Q?k?q)" +
    "\\s+" +
    "(?<EnPassant>-|[a-h][3-6])" +
    "\\s+" +
    "(?<HalfMoveClock>\\d+)" +
    "\\s+" +
    "(?<FullMoveNumber>\\d+)" +
    "\\s*"
