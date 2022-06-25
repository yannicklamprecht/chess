package me.kxmpxtxnt.consolechess.board.field

import java.awt.Color

class Field(val x: String,val  y: Int) {

  init {
    if(y > 7 || !"abcdefgh".contains(x)){
      throw IllegalArgumentException("Field must be in correct order. [a-h] & [0-7]")
    }
  }

  fun getColor(): Color{
    when(x.first().toString()){
      "a", "c", "e", "g" ->{
        when(y){
          1, 3, 5, 7 -> {
            return Color.BLACK
          }
        }
      }
    }
    return Color.WHITE
  }
}