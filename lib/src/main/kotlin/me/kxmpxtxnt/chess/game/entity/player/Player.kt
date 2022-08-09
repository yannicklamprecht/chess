package me.kxmpxtxnt.chess.game.entity.player

import kotlinx.serialization.Contextual
import me.kxmpxtxnt.chess.board.field.FieldColor
import me.kxmpxtxnt.chess.game.entity.Entity
import java.util.*

@kotlinx.serialization.Serializable
class Player(
        override val nickname: String,
        override val color: FieldColor,
        @Contextual override val uuid: UUID
) : Entity {


}
