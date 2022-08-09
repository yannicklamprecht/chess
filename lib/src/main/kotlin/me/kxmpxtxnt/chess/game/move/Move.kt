package me.kxmpxtxnt.chess.game.move

import me.kxmpxtxnt.chess.board.Position
import me.kxmpxtxnt.chess.board.piece.Piece

@kotlinx.serialization.Serializable
data class Move(
        val piece: Piece,
        val positionFrom: Position,
        val positionTo: Position
)
