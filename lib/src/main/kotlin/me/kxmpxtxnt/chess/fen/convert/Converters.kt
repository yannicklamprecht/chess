package me.kxmpxtxnt.chess.fen.convert

import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.fen.convert.converter.*

object Converters{

  fun lineupConverter(board: ChessBoard) = LineupConverter(board)
  fun turnConverter(board: ChessBoard) = TurnConverter(board)
  fun castleConverter() = CastleConverter()
  fun halfMoveConverter() = HalfMoveConverter()
  fun fullMoveConverter() = FullMoveConverter()
}
