import chessBoards.CustomChessBoard;
import chessBoards.MainChessBoard;
import chessPieces.*;
import otherSources.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        CustomChessBoard chessBoard = new CustomChessBoard("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
        //MainChessBoard chessBoard = new MainChessBoard();
        BaseChessPiece[][] board = chessBoard.getBoard();

        //board[6][2] = new King(new int[]{6,2},false);
        /*ArrayList<int[]> moves = board[4][0].canGo(board);

        for(int[] move : moves){
            System.out.println(Converter.indexesToString(move));
        }*/

        System.out.println("---------------------------");

//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                System.out.println(Converter.indexesToString(new int[]{i,j}) + ", name: "+board[i][j].getName() + ", color: " + (board[i][j].isWhite() ? "White" : "Black"));
//            }
//        }
    }
}