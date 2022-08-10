package me.kxmpxtxnt.chess.lib.board.field

import me.kxmpxtxnt.chess.lib.board.position.Position

@kotlinx.serialization.Serializable
data class Field(
        val position: Position,
        val fieldID: Int,
        val color: FieldColor
) {

  init {
    if(position.y > 7 || !"abcdefgh".contains(position.x.lowercase())){
      throw IllegalArgumentException("Field must be in correct order. [a-h] & [0-7]")
    }
  }
}
