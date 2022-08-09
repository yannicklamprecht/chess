package me.kxmpxtxnt.chess.game.move.validation

import me.kxmpxtxnt.chess.board.piece.Piece
import me.kxmpxtxnt.chess.game.move.Move

fun Move.isValid(): Boolean{
  when(piece.type){
    Piece.Type.BLACK_PAWN, Piece.Type.WHITE_PAWN -> {

    }
  }
}
