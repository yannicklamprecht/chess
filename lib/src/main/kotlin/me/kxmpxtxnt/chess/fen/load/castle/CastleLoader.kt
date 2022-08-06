package me.kxmpxtxnt.chess.fen.load.castle

class CastleLoader {

  enum class FieldColor{
    BOTH,
    BLACK,
    WHITE;

    override fun toString(): String {
      return name.uppercase()
    }
  }

  companion object {
    fun load(castle: String): List<Pair<FieldColor, Side>> {
      return when (castle.length) {
        1 -> when(castle){
          "-" -> emptyList()

          else -> throw IllegalArgumentException("Wrong arguments for castling detection.")
        }

        2 -> when (castle) {
          "KQ" -> listOf(Pair(FieldColor.WHITE, Side.BOTH))
          "kq" -> listOf(Pair(FieldColor.BLACK, Side.BOTH))
          "kQ" -> listOf(
            Pair(FieldColor.BLACK, Side.KINGSIDE),
            Pair(FieldColor.WHITE, Side.QUEENSIDE)
          )
          "Kq" ->listOf(
            Pair(FieldColor.WHITE, Side.KINGSIDE),
            Pair(FieldColor.BLACK, Side.QUEENSIDE)
          )

          else -> throw IllegalArgumentException("Wrong arguments for castling detection.")
        }

        4 -> listOf(Pair(FieldColor.BOTH, Side.BOTH))

        else -> throw IllegalArgumentException("Wrong arguments for castling detection.")
      }
    }
  }

  enum class Side{
    BOTH,
    QUEENSIDE,
    KINGSIDE
  }
}