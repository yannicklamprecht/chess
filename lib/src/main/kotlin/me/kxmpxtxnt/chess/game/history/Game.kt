package me.kxmpxtxnt.chess.game.history

import kotlinx.serialization.Contextual
import me.kxmpxtxnt.chess.board.ChessBoard
import me.kxmpxtxnt.chess.fen.convert.Converter
import me.kxmpxtxnt.chess.game.move.Move
import java.util.Optional
import java.util.TreeSet
import javax.swing.text.html.parser.Entity

@kotlinx.serialization.Serializable
class Game : Converter<ChessBoard, Game.History> {

  override fun asString(input: ChessBoard): String {
    TODO("Not yet implemented")
  }

  override fun fromString(input: ChessBoard): History? {
    TODO("Not yet implemented")
  }

  @kotlinx.serialization.Serializable
  data class History(
          @Contextual val moves: TreeSet<Move>,
          @Contextual val winner: Optional<@Contextual Entity>
  ){

  }
}
