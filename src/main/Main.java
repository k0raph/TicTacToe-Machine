package main;

public class Main {

    public static void main(String[] args) {
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeMachine machine = new TicTacToeMachine(board);

        board.setMachine(machine);
        board.startGame();
    }
}
