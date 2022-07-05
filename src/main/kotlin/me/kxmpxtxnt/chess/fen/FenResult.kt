package me.kxmpxtxnt.chess.fen

import me.kxmpxtxnt.chess.board.field.Field
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.fen.castle.CastleResult
import me.kxmpxtxnt.chess.piece.Piece
import java.awt.Color

class FenResult(val lineup: Map<Field, Piece>, val turn: FieldColor) {
}