package me.kxmpxtxnt.chess.piece

import me.kxmpxtxnt.chess.board.ChessBoard

class Piece(val type: Type, val board: ChessBoard) {

  enum class Type(val fenChar: String, val startAmount: Int, val hasMaxAmount: Boolean = false) {

    BLACK_PAWN("p", 7),
    WHITE_PAWN("P", 7),

    BLACK_BISHOP("b", 1),
    WHITE_BISHOP("B", 1),

    BLACK_KNIGHT("n", 1),
    WHITE_KNIGHT("N", 1),

    BLACK_ROCK("r", 1),
    WHITE_ROCK("R", 1),

    BLACK_QUEEN("q", 0),
    WHITE_QUEEN("Q", 0),

    BLACK_KING("k", 0, true),
    WHITE_KING("K", 0, true);

    override fun toString(): String {
      return name.uppercase()
    }
  }

  override fun toString(): String {
    return type.toString()
  }
}
