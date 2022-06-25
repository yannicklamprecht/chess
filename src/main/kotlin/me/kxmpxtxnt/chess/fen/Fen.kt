package me.kxmpxtxnt.consolechess.fen

import me.kxmpxtxnt.consolechess.board.ChessBoard
import me.kxmpxtxnt.consolechess.board.field.Field
import me.kxmpxtxnt.consolechess.peace.Piece
import me.kxmpxtxnt.consolechess.peace.PieceType
import java.util.regex.Matcher
import java.util.regex.Pattern

fun toFen(board: ChessBoard): String {
  if(!validateFen(board.fen)){
    throw IllegalArgumentException("FEN (Forsyth-Edwards Notation) in the board is invalid. [${board.fen}]")
  }

  return ""
}

fun fromFen(fen: String): HashMap<Field, Piece> {
  if(!validateFen(fen)){
    throw IllegalArgumentException("Entered FEN (Forsyth-Edwards Notation) is not valid. [$fen]")
  }
  val map: HashMap<Field, Piece> = hashMapOf()
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
