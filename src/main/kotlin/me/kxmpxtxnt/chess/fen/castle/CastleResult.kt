package me.kxmpxtxnt.chess.fen.castle

import java.awt.Color

class CastleResult(val colors: Array<Color>, val side: Side) {

  enum class  Side(white:  String, black: String){
    QUEENSIDE("q", "Q"),
    KINGSIDE("k", "K")
  }
}