package me.kxmpxtxnt.chess.fen

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.piece.Piece
import java.util.regex.Matcher
import java.util.regex.Pattern

fun toFen(board: ChessBoard): String {
  if(!validateFen(board.fen)){
    throw IllegalArgumentException("FEN (Forsyth-Edwards Notation) in the board is invalid. [${board.fen}]")
  }

  return ""
}

fun fromFen(fen: String): HashMap<Field, Piece> {
  if(!validateFen(fen))return hashMapOf<Field, Piece>()

  val map: HashMap<Field, Piece> = hashMapOf()

  val fieldId = 0

  fen.forEach { fenChar ->
    for(type in Piece.Type.values()){
      if(type.fenChar.first() == fenChar){
        
      }
    }
  }

  return map
}

fun validateFen(fen: String): Boolean{
  val pattern: Pattern = Pattern.compile(FEN_REGEX)
  val matcher: Matcher = pattern.matcher(fen)
  if (!matcher.matches()) {
    throw IllegalArgumentException("Entered FEN (Forsyth-Edwards Notation) is not valid. [$fen]")
  }
  return true
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
