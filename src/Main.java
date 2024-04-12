import chessBoards.ChessBoard;
import chessBoards.ChessBoardManager;
import chessPieces.*;
import otherSources.*;

public class Main {
    public static void main(String[] args) {
        ChessBoardManager boardManager = new ChessBoardManager();
        ChessBoard chessBoard = boardManager.fenCodeToChessBoard("rnbqkbnr/pp1ppppp/8/2p5/4P3/8/PPPP1PPP/RNBQKBNR w KQkq c6 0 2");

        BaseChessPiece[][] board = chessBoard.getBoard();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println(Converter.indexesToString(new int[]{i,j}) + ", name: "+board[i][j].getName());
            }
        }

        //  + ", color: " + (board[i][j].isWhite() ? "White" : "Black")
    }
}