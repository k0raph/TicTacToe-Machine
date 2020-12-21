package test;

import main.TicTacToeBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static main.TicTacToeBoard.hasPlayerWon;
import static main.TicTacToeBoard.isBoardFull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicTacToeBoardTest {

    TicTacToeBoard board;

    @BeforeEach
    public void init() {
        board = new TicTacToeBoard();
    }

    @Test
    public void hasPlayerWon_Should_ReturnTrue_When_ARowIsComplete() {
       board.setBoard(new String[] {
               "X", "X", "X",
               "O", "O", "cr",
               "bl", "cb", "br"
       });

       assertTrue(hasPlayerWon(board.getBoard(), "X"));
    }

    @Test
    public void hasPlayerWon_Should_ReturnTrue_When_AColumnIsComplete() {
        board.setBoard(new String[] {
                "X", "ct", "O",
                "X", "O", "cr",
                "X", "cb", "br"
        });

        assertTrue(hasPlayerWon(board.getBoard(), "X"));
    }

    @Test
    public void hasPlayerWon_Should_ReturnTrue_When_ADiagonalIsComplete() {
        board.setBoard(new String[] {
                "X", "ct", "O",
                "cr", "X", "O",
                "bl", "cb", "X"
        });

        assertTrue(hasPlayerWon(board.getBoard(), "X"));
    }

    @Test
    public void isBoardFull_Should_ReturnTrue_When_NoValidMovesAreAvailable() {
        board.setBoard(new String[] {
                "X", "O", "O",
                "O", "X", "X",
                "X", "X", "O"
        });

        assertTrue(isBoardFull(board.getBoard()));
    }

    @Test
    public void isBoardFull_Should_ReturnFalse_When_ValidMovesAreAvailable() {
        board.setBoard(new String[] {
                "X", "O", "O",
                "O", "c", "X",
                "X", "X", "O"
        });

        assertFalse(isBoardFull(board.getBoard()));
    }
}