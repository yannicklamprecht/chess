package me.kxmpxtxnt.chess.board

import me.kxmpxtxnt.chess.fen.save.lineup.LineupSaver
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ChessBoardTest {

  @Test
  fun ensureSerialization(){
    val expected = "rnbqkbnr/4pppp/8/8/8/8/PPPPPPPP/RNBQKBNR"
    val board = ChessBoard(fen = "$expected w - - 0 0")
    val generated = LineupSaver.save(board)
    assertEquals(expected, generated)
  }

  @Test
  fun ensureSerialization2(){
    val expected = "rnbqkbnr/4p1pp/8/8/8/8/PPP1PPPP/RNBQKBNR"
    val board = ChessBoard(fen = "$expected w - - 0 0")
    val generated = LineupSaver.save(board)
    assertEquals(expected, generated)
  }
}
