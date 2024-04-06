package chessPieces;

import java.util.ArrayList;

public class Pawn extends BaseChessPiece{
    public Pawn(int[] coordinate, boolean isWhite) {
        super(coordinate, isWhite);
        setName("Pawn");
    }

    @Override
    public ArrayList<int[]> canGo(BaseChessPiece[][] board) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        int[] currentLocation = getCoordinate();
        
        if (isWhite()){
            if (board[currentLocation[0]][currentLocation[1]+1].getName().equals("")){
                int[] location = new int[]{currentLocation[0],currentLocation[1] +1};
                moves.add(location);
            }

            if (currentLocation[0]+1 < 8 && currentLocation[1] +1<8 && currentLocation[0]-1 >-1 && currentLocation[1]-1 >-1){
                if (!board[currentLocation[0]+1][currentLocation[1]+1].getName().equals("") && board[currentLocation[0]+1][currentLocation[1]+1].isWhite() != isWhite()){
                    int[] location = new int[]{currentLocation[0]+1,currentLocation[1] +1};
                    moves.add(location);
                } else if (!board[currentLocation[0]-1][currentLocation[1]+1].getName().equals("") && board[currentLocation[0]-1][currentLocation[1]+1].isWhite() != isWhite()) {
                    int[] location = new int[]{currentLocation[0]-1,currentLocation[1] +1};
                    moves.add(location);
                }
            }
        } else{
            if (board[currentLocation[0]][currentLocation[1]-1].getName().equals("")){
                int[] location = new int[]{currentLocation[0],currentLocation[1] -1};
                moves.add(location);
            }

            if (currentLocation[0]+1 < 8 && currentLocation[1] +1<8 && currentLocation[0]-1 >-1 && currentLocation[1]-1 >-1){
                if (!board[currentLocation[0]+1][currentLocation[1]-1].getName().equals("") && board[currentLocation[0]+1][currentLocation[1]-1].isWhite() != isWhite()){
                    int[] location = new int[]{currentLocation[0]+1,currentLocation[1] -1};
                    moves.add(location);
                } else if (!board[currentLocation[0]-1][currentLocation[1]-1].getName().equals("") && board[currentLocation[0]-1][currentLocation[1]-1].isWhite() != isWhite()) {
                    int[] location = new int[]{currentLocation[0]-1,currentLocation[1] -1};
                    moves.add(location);
                }
            }
        }
        
        

        
        return moves;
    }
}
