package me.kxmpxtxnt.chess.fen

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.fen.convert.ConvertResult
import me.kxmpxtxnt.chess.fen.convert.Converters
import java.util.regex.Pattern

fun toFen(board: ChessBoard): String {

  return " - - 0 0"
}

fun fromFen(board: ChessBoard): ConvertResult {
  if (!validateFen(board.fen)) throw IllegalArgumentException("Entered FEN (Forsyth-Edwards Notation) is not valid. [${board.fen}]")

  val fenParts = board.fen.split(" ")

  return ConvertResult(
          Converters.lineupConverter(board).fromString(fenParts[0]),
          Converters.turnConverter(board).fromString(fenParts[1]),
          Converters.castleConverter().fromString(fenParts[2]),
          Converters.halfMoveConverter().fromString(fenParts[3]),
          Converters.fullMoveConverter().fromString(fenParts[4])
  )
}

fun validateFen(fen: String): Boolean {
  return Pattern.compile(FEN_REGEX).matcher(fen).matches()
}

private const val FEN_REGEX =
  "^(?<PiecePlacement>((?<RankItem>[pnbrqkPNBRQK1-8]{1,8})/?){8})" +
      "\\s+" +
      "(?<SideToMove>[bw])" +
      "\\s+" +
      "(?<Castling>-|k?q?K?Q?K?Q?q?K?)" +
      "\\s+" +
      "(?<EnPassant>-|[a-h]?[3,6]?-?)" +
      "\\s+" +
      "(?<HalfMoveClock>\\d+)" +
      "\\s+" +
      "(?<FullMoveNumber>\\d+)" +
      "\\s*"
