package me.kxmpxtxnt.chess.fen.convert

import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.convert.converter.CastleConverter
import me.kxmpxtxnt.chess.fen.convert.converter.Rule
import me.kxmpxtxnt.chess.piece.Piece


class ConvertResult(val lineup: HashMap<Field, Piece>,
                    val turn: FieldColor,
                    val castle: List<Pair<FieldColor, CastleConverter.Side>>,
                    val halfMove: Pair<Rule, Int>,
                    val fullMove: Int
)
