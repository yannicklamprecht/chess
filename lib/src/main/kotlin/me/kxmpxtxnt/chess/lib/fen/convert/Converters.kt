package me.kxmpxtxnt.chess.lib.fen.convert

import me.kxmpxtxnt.chess.lib.fen.convert.converter.LineupConverter
import me.kxmpxtxnt.chess.lib.board.ChessBoard
import me.kxmpxtxnt.chess.lib.fen.convert.converter.CastleConverter
import me.kxmpxtxnt.chess.lib.fen.convert.converter.FullMoveConverter
import me.kxmpxtxnt.chess.lib.fen.convert.converter.HalfMoveConverter
import me.kxmpxtxnt.chess.lib.fen.convert.converter.TurnConverter


object Converters{

  fun lineupConverter(board: ChessBoard) = LineupConverter(board)
  fun turnConverter(board: ChessBoard) = TurnConverter(board)
  fun castleConverter() = CastleConverter()
  fun halfMoveConverter() = HalfMoveConverter()
  fun fullMoveConverter() = FullMoveConverter()
}
