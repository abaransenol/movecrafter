package chessPieces;

import java.util.ArrayList;

public class King extends BaseChessPiece{
    private boolean isMoved;

    public King(int[] coordinate, boolean isWhite) {
        super(coordinate, isWhite);
        setName("King");

        if (isWhite && coordinate[0] == 4 && coordinate[1] == 0){
            this.isMoved = false;
        } else if (!isWhite && coordinate[0] == 4 && coordinate[1] == 7){
            this.isMoved = false;
        } else {
            this.isMoved = true;
        }
    }

    public King(int[] coordinate, boolean isWhite, boolean isMoved) {
        super(coordinate, isWhite);
        setName("King");

        this.isMoved = isMoved;
    }

    @Override
    public ArrayList<int[]> canGo(BaseChessPiece[][] board) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        int[] currentLocation = getCoordinate();

        try {
            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    if(i == 0 && j == 0){

                    } else {
                        if (currentLocation[0]+i < 8 && currentLocation[1] +j<8 && currentLocation[0]+i >-1 && currentLocation[1]+j >-1){
                            if (board[currentLocation[0]+i][currentLocation[1] +j].isWhite() != isWhite() || board[currentLocation[0]+i][currentLocation[1] +j].getName().equals("")){
                                int[] location = new int[]{currentLocation[0]+i,currentLocation[1] +j};
                                moves.add(location);
                            }
                        }
                    }
                }
            }

        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception){

        }

        for (int i=0; i<8;i++){
            for (int j=0; j<8; j++){
                if (!board[i][j].getName().equals("") && board[i][j].isWhite() != isWhite() && !board[i][j].getName().equals("King")){
                    for (int[] control : board[i][j].canGo(board)){
                        int length = moves.size();
                        int k = 0;
                        while (k<length){
                            if (control[0] == moves.get(k)[0] && control[1] == moves.get(k)[1]){
                                moves.remove(k);
                                length--;
                            }

                            k++;
                        }
/*
                        for (int[] kingCanGo : moves){
                            if (kingCanGo[0] == control[0] && kingCanGo[1] == control[1]){
                                moves.remove(kingCanGo);
                            }
                        }*/
                    }
                }
            }
        }

        int[] kingControl = new int[2];

        try {
            for(int i=-2; i<3; i++){
                for(int j=-2; j<3; j++){
                    if(i == 0 && j == 0){

                    } else if (i % 2 == 0 || j % 2 == 0){
                        if (currentLocation[0]+i < 8 && currentLocation[1] +j<8 && currentLocation[0]+i >-1 && currentLocation[1]+j >-1){
                            if (board[currentLocation[0]+i][currentLocation[1]+j].getName().equals("King")){
                                kingControl[0] = currentLocation[0]+i;
                                kingControl[1] = currentLocation[1]+j;
                                break;
                            }
                        }
                    }
                }
            }

        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception){

        }

        ArrayList<int[]> controller = new ArrayList<int[]>();

        for(int i=-1; i<2; i++){
            for(int j=-1; j<2; j++){
                if(i == 0 && j == 0){

                } else {
                    if (kingControl[0]+i < 8 && kingControl[1] +j<8 && kingControl[0]+i >-1 && kingControl[1]+j >-1){
                        int[] location = new int[]{kingControl[0]+i,kingControl[1] +j};
                        controller.add(location);
                    }
                }
            }
        }

        for (int[] control : controller){
            int length = moves.size();
            int k = 0;

            while (k<length){
                if (control[0] == moves.get(k)[0] && control[1] == moves.get(k)[1]){
                    moves.remove(k);
                    length--;
                }

                k++;
            }
        }
        
        return moves;
    }

    public boolean isMoved() {
        return isMoved;
    }
}
