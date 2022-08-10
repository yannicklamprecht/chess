package me.kxmpxtxnt.chess.lib.game.entity.player

import kotlinx.serialization.Contextual
import me.kxmpxtxnt.chess.lib.game.entity.Entity
import me.kxmpxtxnt.chess.lib.board.field.FieldColor
import java.util.*

@kotlinx.serialization.Serializable
class Player(
        override val nickname: String,
        override val color: FieldColor,
        @Contextual override val uuid: UUID
) : Entity {


}
