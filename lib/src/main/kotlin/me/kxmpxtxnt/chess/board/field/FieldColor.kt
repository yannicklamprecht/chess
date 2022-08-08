package me.kxmpxtxnt.chess.board.field

@kotlinx.serialization.Serializable
enum class FieldColor {

  BLACK,
  WHITE;

  override fun toString(): String {
    return name.uppercase()
  }
}
