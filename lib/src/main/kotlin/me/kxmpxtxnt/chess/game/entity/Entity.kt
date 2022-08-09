package me.kxmpxtxnt.chess.game.entity

import me.kxmpxtxnt.chess.board.field.FieldColor
import java.util.UUID

interface Entity {

  val nickname: String
  val color: FieldColor

  val uuid: UUID

}
