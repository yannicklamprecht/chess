package me.kxmpxtxnt.chess.lib.game.move.validation

import me.kxmpxtxnt.chess.lib.board.piece.Piece
import me.kxmpxtxnt.chess.lib.game.move.Move

fun Move.isValid(): Boolean{
  when(piece.type){
    Piece.Type.BLACK_PAWN, Piece.Type.WHITE_PAWN -> {

    }

    else -> {}
  }

  return false
}
