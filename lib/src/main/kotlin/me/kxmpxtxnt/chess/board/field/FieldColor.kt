package me.kxmpxtxnt.chess.board.field

enum class FieldColor {

  BLACK,
  WHITE;

  override fun toString(): String {
    return name.uppercase()
  }
}
