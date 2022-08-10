package me.kxmpxtxnt.chess.lib.game.move

import me.kxmpxtxnt.chess.lib.board.piece.Piece
import me.kxmpxtxnt.chess.lib.board.position.Position

@kotlinx.serialization.Serializable
data class Move(
        val piece: Piece,
        val positionFrom: Position,
        val positionTo: Position
)
