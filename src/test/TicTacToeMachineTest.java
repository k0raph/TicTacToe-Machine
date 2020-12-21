package test;

import main.TicTacToeBoard;
import main.TicTacToeMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static main.TicTacToeBoard.hasPlayerWon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TicTacToeMachineTest {
    TicTacToeBoard board;
    TicTacToeMachine machine;

    @BeforeEach
    public void init() {
        board = new TicTacToeBoard();
        machine = new TicTacToeMachine(board);
        machine.setPiece("O");
    }

    @Test
    public void machineMakeMove_Should_PlayTheWinningMove() {
        board.setBoard(new String[] {
                "X", "X", "tr",
                "O", "O", "cr",
                "bl", "X", "br"
        });

        machine.makeMove(board.getBoard());

        assertTrue(hasPlayerWon(board.getBoard(), "O"));
    }
}
