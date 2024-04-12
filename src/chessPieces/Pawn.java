package chessPieces;

import chessBoards.ChessBoard;

import java.util.ArrayList;

public class Pawn extends BaseChessPiece{
    public Pawn(boolean isWhite) {
        super(isWhite);
        setName("Pawn");
    }

    @Override
    public ArrayList<int[]> canGo(ChessBoard chessBoard, int[] coordinates) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        BaseChessPiece[][] board = chessBoard.getBoard();
        
        if (isWhite()){
            if (board[coordinates[0]][coordinates[1]+1].getName().equals("")){
                int[] location = new int[]{coordinates[0],coordinates[1] +1};
                moves.add(location);
            }

            if (coordinates[0]+1 < 8 && coordinates[1] +1<8 && coordinates[0]-1 >-1 && coordinates[1]-1 >-1){
                if (!board[coordinates[0]+1][coordinates[1]+1].getName().equals("") && board[coordinates[0]+1][coordinates[1]+1].isWhite() != isWhite()){
                    int[] location = new int[]{coordinates[0]+1,coordinates[1] +1};
                    moves.add(location);
                } else if (!board[coordinates[0]-1][coordinates[1]+1].getName().equals("") && board[coordinates[0]-1][coordinates[1]+1].isWhite() != isWhite()) {
                    int[] location = new int[]{coordinates[0]-1,coordinates[1] +1};
                    moves.add(location);
                }
            }
        } else{
            if (board[coordinates[0]][coordinates[1]-1].getName().equals("")){
                int[] location = new int[]{coordinates[0],coordinates[1] -1};
                moves.add(location);
            }

            if (coordinates[0]+1 < 8 && coordinates[1] +1<8 && coordinates[0]-1 >-1 && coordinates[1]-1 >-1){
                if (!board[coordinates[0]+1][coordinates[1]-1].getName().equals("") && board[coordinates[0]+1][coordinates[1]-1].isWhite() != isWhite()){
                    int[] location = new int[]{coordinates[0]+1,coordinates[1] -1};
                    moves.add(location);
                } else if (!board[coordinates[0]-1][coordinates[1]-1].getName().equals("") && board[coordinates[0]-1][coordinates[1]-1].isWhite() != isWhite()) {
                    int[] location = new int[]{coordinates[0]-1,coordinates[1] -1};
                    moves.add(location);
                }
            }
        }
        
        

        
        return moves;
    }
}
