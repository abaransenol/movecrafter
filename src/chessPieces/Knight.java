package chessPieces;

import java.util.ArrayList;

public class Knight extends BaseChessPiece{
    public Knight(int[] coordinate, boolean isWhite) {
        super(coordinate, isWhite);
        setName("Knight");
    }

    @Override
    public ArrayList<int[]> canGo(BaseChessPiece[][] board) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        int[] currentLocation = getCoordinate();

        for (int i=-2; i<3; i++){
            for (int j=-2; j<3; j++){
                if (i == 0 || j == 0){

                } else if ((i % 2 == 0 && j % 2 != 0) || (j % 2 == 0 && i % 2 != 0)){
                    if (currentLocation[0]+i < 8 && currentLocation[1] +j<8 && currentLocation[0]+i >-1 && currentLocation[1]+j >-1){
                        if(board[currentLocation[0]+i][currentLocation[1]+j].isWhite() != isWhite() || board[currentLocation[0]+i][currentLocation[1]+j].getName().equals("")){
                            int[] location = new int[]{currentLocation[0]+i,currentLocation[1] +j};
                            moves.add(location);
                        }
                    }
                }
            }
        }

        return moves;
    }
}
