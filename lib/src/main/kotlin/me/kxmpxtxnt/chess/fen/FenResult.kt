package me.kxmpxtxnt.chess.fen

import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.castle.CastleResult
import me.kxmpxtxnt.chess.piece.Piece

class FenResult(val lineup: HashMap<Field, Piece>, val turn: FieldColor, val castleResult: List<Pair<CastleResult.FieldColor, CastleResult.Side>>)