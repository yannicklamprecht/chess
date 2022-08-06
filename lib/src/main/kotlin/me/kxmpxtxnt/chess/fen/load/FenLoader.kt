package me.kxmpxtxnt.chess.fen.load

import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.load.castle.CastleLoader
import me.kxmpxtxnt.chess.fen.load.halvmove.HalfMoveLoader
import me.kxmpxtxnt.chess.piece.Piece

class FenLoader(
  val lineup: HashMap<Field, Piece>,
  val turn: FieldColor,
  val castleLoader: List<Pair<CastleLoader.FieldColor, CastleLoader.Side>>,
  val enpassent: Field?,
  val halfMove: Pair<HalfMoveLoader.Rule, Int>,
  val fullMove: Int
)