package me.kxmpxtxnt.chess.lib.fen.convert

import me.kxmpxtxnt.chess.lib.board.field.Field
import me.kxmpxtxnt.chess.lib.board.field.FieldColor
import me.kxmpxtxnt.chess.lib.board.piece.Piece
import me.kxmpxtxnt.chess.lib.fen.convert.converter.CastleConverter
import me.kxmpxtxnt.chess.lib.fen.convert.converter.Rule

class ConvertResult(
        val lineup: HashMap<Field, Piece>,
        val turn: FieldColor,
        val castle: List<CastleConverter.Side>,
        val halfMove: Pair<Rule, Int>,
        val fullMove: Int
)
