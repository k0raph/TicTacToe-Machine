package main;

public class TicTacToeMachine {

    TicTacToeBoard board;
    String machinePiece;
    String playerSelectedPiece;

    public TicTacToeMachine(TicTacToeBoard board) {
        this.board = board;
    }

    public void makeMove(String[] boardState) {
        Minimax minimax = new Minimax(machinePiece, playerSelectedPiece);
        Integer position = minimax.findBestMove(boardState);
        board.playMove(position, machinePiece);
    }

    public void setPiece(String machinePiece) {
        this.machinePiece = machinePiece;
        playerSelectedPiece = machinePiece.equals("X") ? "O" : "X";
    }
}
