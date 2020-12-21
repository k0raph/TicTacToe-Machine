package main;

import java.util.Scanner;

public class TicTacToeBoard {

    String[] board;
    String playerSelectedPiece;
    TicTacToeMachine machine;

    public TicTacToeBoard() {
        board = new String[]{
                "tl", "ct", "tr",
                "cl", "c", "cr",
                "bl", "cb", "br"
        };
    }

    /**
     * @return a char[] that represents the current state of the board
     */
    public String[] getBoard() {
        return board;
    }

    /**
     * Sets the current state of the board to the desired configuration
     *
     * @param board char[] representing the desired configuration of the board
     */
    public void setBoard(String[] board) {
        this.board = board;
    }

    /**
     * Prints the current state of the board, in a human readable form
     */
    public void printBoard() {
        System.out.println("Current board:");

        for (int i = 1; i <= board.length; i++) {
            String currentPos = board[i - 1];
            boolean pieceIsValid = currentPos.equals("X") || currentPos.equals("O");
            String piece = pieceIsValid ? currentPos : "-";

            if (i % 3 != 0) {
                System.out.print(piece + "|");
            } else {
                System.out.println(piece);
            }
        }

        System.out.println();
    }

    /**
     * Prints all the available moves for the current state of the board
     */
    public void printAvailableMoves() {
        System.out.println("Available moves:");

        for (int i = 1; i <= board.length; i++) {
            String currentPos = board[i - 1];
            boolean pieceIsValid = currentPos.equals("X") || currentPos.equals("O");
            String piece = pieceIsValid ? "-" : currentPos;

            if (i % 3 != 0) {
                System.out.print(piece + "|");
            } else {
                System.out.println(piece);
            }
        }

        System.out.println();
    }

    /**
     * Places a given piece on the board (in the Array) at a specified position. Additionally, evaluates if the given move
     * leads to a win, or a tie.
     * @param position An Integer, that represents the position on the board (in the Array) to place the given piece
     * @param playerPiece A String, that represents the piece to be played on the board
     */
    public void playMove(Integer position, String playerPiece) {
        board[position] = playerPiece;

        boolean hasPlayerWon = hasPlayerWon(board, playerPiece);
        boolean isBoardFull = isBoardFull(board);

        if (hasPlayerWon) {
            printBoard();

            if (playerPiece.equals(playerSelectedPiece)) {
                System.out.println("Well done, " + playerPiece + " (You) won!");
            } else {
                System.out.println(playerPiece + " (The machine) has won!");
            }
        } else if (isBoardFull) {
            printBoard();
            System.out.println("It's a tie!");
        }

        if (!isBoardFull && !hasPlayerWon) {
            if (playerPiece.equals(playerSelectedPiece)) {
                machine.makeMove(board);
            } else {
                requestPlayersNextMove();
            }
        }
    }

    public void startGame() {
        System.out.println("Would you like to play as X or O? Note: X always plays first!");

        Scanner sc = new Scanner(System.in);
        playerSelectedPiece = sc.next().toUpperCase();

        if (playerSelectedPiece.equals("X")) {
            System.out.println("You have chosen X, this means you play the first move!\n");
            machine.setPiece("O");
            requestPlayersNextMove();
        } else if (playerSelectedPiece.equals("O")) {
            System.out.println("You have chosen O, this means the machine will play the first move!\n");
            machine.setPiece("X");
            machine.makeMove(board);
        } else {
            System.out.println("You can only select either X or O.\n");
            startGame();
        }
    }

    private void requestPlayersNextMove() {
        printAvailableMoves();
        printBoard();

        Scanner sc = new Scanner(System.in);
        String selectedPosition = sc.next();

        boolean moveValid = false;

        for (int i = 0; i < board.length; i++) {
            if (selectedPosition.equals(board[i])) {
                moveValid = true;
                playMove(i, playerSelectedPiece);
                break;
            }
        }

        if (!moveValid) {
            System.out.println("Move not valid! Select an available move.");
            requestPlayersNextMove();
        }
    }

    /**
     * Checks if a given player has a winning state (3 in a row) on the given board
     * @param board The state of the board you wish to check for a win
     * @param player The player (X or O) that you wish to check has won
     * @return True if the given player has a winning state on the given board and false otherwise
     */
    public static boolean hasPlayerWon(String[] board, String player) {

        boolean rowComplete = (player.equals(board[0]) && player.equals(board[1]) && player.equals(board[2]))
                || (player.equals(board[3]) && player.equals(board[4]) && player.equals(board[5]))
                || (player.equals(board[6]) && player.equals(board[7]) && player.equals(board[8]));

        boolean columnComplete = (player.equals(board[0]) && player.equals(board[3]) && player.equals(board[6]))
                || (player.equals(board[1]) && player.equals(board[4]) && player.equals(board[7]))
                || (player.equals(board[2]) && player.equals(board[5]) && player.equals(board[8]));

        boolean diagonalComplete = (player.equals(board[0]) && player.equals(board[4]) && player.equals(board[8]))
                || (player.equals(board[2]) && player.equals(board[4]) && player.equals(board[6]));

        return rowComplete || columnComplete || diagonalComplete;
    }

    /**
     * Checks if a given board is full, i.e. there are no available moves
     * @param board The state of the board you wish to check
     * @return True if the board is full, and false otherwise
     */
    public static boolean isBoardFull(String[] board) {
        for (String piece : board) {
            if (!piece.equals("X") && !piece.equals("O")) {
                return false;
            }
        }

        return true;
    }

    public void setMachine(TicTacToeMachine machine) {
        this.machine = machine;
    }
}
