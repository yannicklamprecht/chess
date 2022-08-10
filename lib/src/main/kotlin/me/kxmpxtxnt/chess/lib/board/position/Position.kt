package me.kxmpxtxnt.chess.lib.board.position

import me.kxmpxtxnt.chess.lib.board.ChessBoard


@kotlinx.serialization.Serializable
data class Position(
        val x: String,
        val y: Int,
        val board: ChessBoard
)

@kotlinx.serialization.Serializable
data class PiecePosition(
        val x: String,
        val y: Int,
        val isOut: Boolean = false,
        val board: ChessBoard
)
