package me.kxmpxtxnt.chess.game.move

import me.kxmpxtxnt.chess.board.Position

@kotlinx.serialization.Serializable
data class Move(
        val positionFrom: Position,
        val positionTo: Position
)
