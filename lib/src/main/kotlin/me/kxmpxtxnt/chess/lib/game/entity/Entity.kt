package me.kxmpxtxnt.chess.lib.game.entity

import me.kxmpxtxnt.chess.lib.board.field.FieldColor
import java.util.UUID

interface Entity {

  val nickname: String
  val color: FieldColor

  val uuid: UUID

}
