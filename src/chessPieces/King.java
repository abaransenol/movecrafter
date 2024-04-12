package chessPieces;

import chessBoards.ChessBoard;

import java.util.ArrayList;

public class King extends BaseChessPiece{
    public King(boolean isWhite) {
        super(isWhite);
        setName("King");
    }

    @Override
    public ArrayList<int[]> canGo(ChessBoard chessBoard, int[] coordinates) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        BaseChessPiece[][] board = chessBoard.getBoard();

        try {
            for(int i=-1; i<2; i++){
                for(int j=-1; j<2; j++){
                    if(i == 0 && j == 0){

                    } else {
                        if (coordinates[0]+i < 8 && coordinates[1] +j<8 && coordinates[0]+i >-1 && coordinates[1]+j >-1){
                            if (board[coordinates[0]+i][coordinates[1] +j].isWhite() != isWhite() || board[coordinates[0]+i][coordinates[1] +j].getName().equals("")){
                                int[] location = new int[]{coordinates[0]+i,coordinates[1] +j};
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
                    for (int[] control : board[i][j].canGo(chessBoard, new int[] {i,j})){
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
                        if (coordinates[0]+i < 8 && coordinates[1] +j<8 && coordinates[0]+i >-1 && coordinates[1]+j >-1){
                            if (board[coordinates[0]+i][coordinates[1]+j].getName().equals("King")){
                                kingControl[0] = coordinates[0]+i;
                                kingControl[1] = coordinates[1]+j;
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
}
