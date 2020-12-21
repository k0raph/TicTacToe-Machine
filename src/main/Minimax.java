package main;

import static main.TicTacToeBoard.hasPlayerWon;
import static main.TicTacToeBoard.isBoardFull;

public class Minimax {

    String machinePiece;
    String playerSelectedPiece;

    public Minimax(String machinePiece, String playerSelectedPiece) {
        this.machinePiece = machinePiece;
        this.playerSelectedPiece = playerSelectedPiece;
    }

    /**
     *
     * @param board the current state of the board
     * @return An Integer that represents the position/index for move with the highest score, as determined by the minimax algorithm
     */
    public Integer findBestMove(String[] board) {
        int bestScore = Integer.MIN_VALUE;
        int bestMove = -1;
        for (int i = 0; i < board.length; i++) {
            if (!board[i].equals("X") && !board[i].equals("O")) {
                String[] clonedBoard = board.clone();

                clonedBoard[i] = machinePiece;
                Integer score = minimax(clonedBoard, 0, false);
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        return bestMove;
    }

    private Integer minimax(String[] boardState, Integer depth, Boolean isMaxPlayer) {
        int score;
        if (hasPlayerWon(boardState, machinePiece)) {
            score = Integer.MAX_VALUE - depth;
            return score;
        } else if (hasPlayerWon(boardState, playerSelectedPiece)) {
            score = Integer.MIN_VALUE + depth;
            return score;
        } else if (isBoardFull(boardState)) {
            score = 0;
            return score;
        }

        int bestScore;
        if (isMaxPlayer) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < boardState.length; i++) {
                if (!boardState[i].equals("X") && !boardState[i].equals("O")) {
                    String[] clonedBoard = boardState.clone();

                    clonedBoard[i] = machinePiece;
                    score = minimax(clonedBoard, depth + 1, false);

                    bestScore = Math.max(score, bestScore);
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < boardState.length; i++) {
                if (!boardState[i].equals("X") && !boardState[i].equals("O")) {
                    String[] clonedBoard = boardState.clone();

                    clonedBoard[i] = playerSelectedPiece;
                    score = minimax(clonedBoard, depth + 1, true);

                    bestScore = Math.min(score, bestScore);

                }
            }
        }
        return bestScore;
    }
}
