package chessPieces;

import java.util.ArrayList;

public class Rook extends BaseChessPiece{
    private boolean isMoved;

    public Rook(int[] coordinate, boolean isWhite) {
        super(coordinate, isWhite);
        setName("Rook");

        if (isWhite && (coordinate[0] == 0 || coordinate[0] == 7) && coordinate[1] == 0){
            this.isMoved = false;
        } else if (!isWhite && (coordinate[0] == 0 || coordinate[0] == 7) && coordinate[1] == 7){
            this.isMoved = false;
        } else {
            this.isMoved = true;
        }
    }

    public Rook(int[] coordinate, boolean isWhite, boolean isMoved) {
        super(coordinate, isWhite);
        setName("Rook");

        this.isMoved = isMoved;
    }

    @Override
    public ArrayList<int[]> canGo(BaseChessPiece[][] currentBoard) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        int[] currentLocation = getCoordinate();

        try{
            int i=1;
            while (currentBoard[currentLocation[0]][currentLocation[1]+i].getName().equals("") || currentBoard[currentLocation[0]][currentLocation[1]+i].isWhite() != isWhite()){
                int[] location = new int[] {currentLocation[0],currentLocation[1]+i};
                moves.add(location);
                if(currentBoard[currentLocation[0]][currentLocation[1]+i].isWhite() != isWhite()!= isWhite() && !currentBoard[currentLocation[0]][currentLocation[1]+i].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        try{
            int i=1;
            while (currentBoard[currentLocation[0]][currentLocation[1]-i].getName().equals("") || currentBoard[currentLocation[0]][currentLocation[1]-i].isWhite() != isWhite()){
                int[] location = new int[] {currentLocation[0],currentLocation[1]-i};
                moves.add(location);
                if(currentBoard[currentLocation[0]][currentLocation[1]-i].isWhite() != isWhite()!= isWhite() && !currentBoard[currentLocation[0]][currentLocation[1]-i].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        try{
            int i=1;
            while (currentBoard[currentLocation[0]+i][currentLocation[1]].getName().equals("") || currentBoard[currentLocation[0]+i][currentLocation[1]].isWhite() != isWhite()){
                int[] location = new int[] {currentLocation[0]+i,currentLocation[1]};
                moves.add(location);
                if(currentBoard[currentLocation[0]+i][currentLocation[1]].isWhite() != isWhite()!= isWhite() && !currentBoard[currentLocation[0]+i][currentLocation[1]].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        try{
            int i=1;
            while (currentBoard[currentLocation[0]-i][currentLocation[1]].getName().equals("") || currentBoard[currentLocation[0]-i][currentLocation[1]].isWhite() != isWhite()){
                int[] location = new int[] {currentLocation[0]-i,currentLocation[1]};
                moves.add(location);
                if(currentBoard[currentLocation[0]-i][currentLocation[1]].isWhite() != isWhite()!= isWhite() && !currentBoard[currentLocation[0]-i][currentLocation[1]].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        return moves;
    }

    public boolean isMoved() {
        return isMoved;
    }
}
