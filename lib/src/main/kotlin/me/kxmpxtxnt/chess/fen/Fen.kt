package me.kxmpxtxnt.chess.fen

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.fen.castle.CastleResult
import me.kxmpxtxnt.chess.fen.pieces.LineupResult
import java.util.regex.Pattern

fun toFen(board: ChessBoard): String {
  if (!validateFen(board.fen)) {
    throw IllegalArgumentException("FEN (Forsyth-Edwards Notation) in the board is invalid. [${board.fen}]")
  }

  return ""
}

fun fromFen(board: ChessBoard): FenResult {
  if (!validateFen(board.fen)) throw IllegalArgumentException("Entered FEN (Forsyth-Edwards Notation) is not valid. [${board.fen}]")

  val fenParts = board.fen.split(" ")

  val lineup = LineupResult.of(fenParts[0], board)

  val turn = LineupResult.TurnResult.of(fenParts[1])

  val castle = CastleResult.of(fenParts[2])

  castle.forEach {
    println("${it.first} | ${it.second}")
  }

  return FenResult(lineup, turn, castle)
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
      "(?<EnPassant>-|[a-h][3-6])" +
      "\\s+" +
      "(?<HalfMoveClock>\\d+)" +
      "\\s+" +
      "(?<FullMoveNumber>\\d+)" +
      "\\s*"