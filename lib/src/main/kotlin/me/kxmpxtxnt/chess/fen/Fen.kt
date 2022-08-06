package me.kxmpxtxnt.chess.fen

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.fen.load.castle.CastleLoader
import me.kxmpxtxnt.chess.fen.load.FenLoader
import me.kxmpxtxnt.chess.fen.load.enpassent.EnpassentLoader
import me.kxmpxtxnt.chess.fen.load.fullmove.FullMoveLoader
import me.kxmpxtxnt.chess.fen.load.halvmove.HalfMoveLoader
import me.kxmpxtxnt.chess.fen.load.lineup.LineupLoader
import me.kxmpxtxnt.chess.fen.save.lineup.LineupSaver
import me.kxmpxtxnt.chess.fen.save.turn.TurnSaver
import java.util.regex.Pattern

fun toFen(board: ChessBoard): String {
  val lineup = LineupSaver.save(board)

  val turn = TurnSaver.save(board)

  //NOT FULL IMPLEMENTED
  return "$lineup $turn -- 0 0"
}

fun fromFen(board: ChessBoard): FenLoader {
  if (!validateFen(board.fen)) throw IllegalArgumentException("Entered FEN (Forsyth-Edwards Notation) is not valid. [${board.fen}]")

  val fenParts = board.fen.split(" ")

  val lineup = LineupLoader.load(fenParts[0], board)

  val turn = LineupLoader.TurnResult.load(fenParts[1])

  val castle = CastleLoader.load(fenParts[2])

  val enpassent = EnpassentLoader.load(fenParts[3], board)

  val halfMove = HalfMoveLoader.load(fenParts[4])

  val fullMove = FullMoveLoader.load(fenParts[5])

  return FenLoader(lineup, turn, castle, enpassent, halfMove, fullMove)
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
      "(?<EnPassant>-|[a-h][3,6])" +
      "\\s+" +
      "(?<HalfMoveClock>\\d+)" +
      "\\s+" +
      "(?<FullMoveNumber>\\d+)" +
      "\\s*"