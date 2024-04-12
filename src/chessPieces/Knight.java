package chessPieces;

import chessBoards.ChessBoard;

import java.util.ArrayList;

public class Knight extends BaseChessPiece{
    public Knight(boolean isWhite) {
        super(isWhite);
        setName("Knight");
    }

    @Override
    public ArrayList<int[]> canGo(ChessBoard chessBoard, int[] coordinates) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        BaseChessPiece[][] board = chessBoard.getBoard();

        for (int i=-2; i<3; i++){
            for (int j=-2; j<3; j++){
                if (i == 0 || j == 0){

                } else if ((i % 2 == 0 && j % 2 != 0) || (j % 2 == 0 && i % 2 != 0)){
                    if (coordinates[0]+i < 8 && coordinates[1] +j<8 && coordinates[0]+i >-1 && coordinates[1]+j >-1){
                        if(board[coordinates[0]+i][coordinates[1]+j].isWhite() != isWhite() || board[coordinates[0]+i][coordinates[1]+j].getName().equals("")){
                            int[] location = new int[]{coordinates[0]+i,coordinates[1] +j};
                            moves.add(location);
                        }
                    }
                }
            }
        }

        return moves;
    }
}
