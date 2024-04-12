package chessPieces;

import chessBoards.ChessBoard;

import java.util.ArrayList;

public class Bishop extends BaseChessPiece{
    public Bishop(boolean isWhite) {
        super(isWhite);
        setName("Bishop");
    }

    @Override
    public ArrayList<int[]> canGo(ChessBoard chessBoard, int[] coordinates) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        BaseChessPiece[][] currentBoard = chessBoard.getBoard();

        try{
            int i=1;
            while (currentBoard[coordinates[0]+i][coordinates[1]+i].getName().equals("") || currentBoard[coordinates[0]+i][coordinates[1]+i].isWhite() != isWhite()){
                int[] location = new int[] {coordinates[0]+i,coordinates[1]+i};
                moves.add(location);
                if(currentBoard[coordinates[0]+i][coordinates[1]+i].isWhite() != isWhite() && !currentBoard[coordinates[0]+i][coordinates[1]+i].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        try{
            int i=1;
            while (currentBoard[coordinates[0]-i][coordinates[1]-i].getName().equals("") || currentBoard[coordinates[0]-i][coordinates[1]-i].isWhite() != isWhite()){
                int[] location = new int[] {coordinates[0]-i,coordinates[1]-i};
                moves.add(location);
                if(currentBoard[coordinates[0]-i][coordinates[1]-i].isWhite() != isWhite() && !currentBoard[coordinates[0]-i][coordinates[1]-i].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        try{
            int i=1;
            while (currentBoard[coordinates[0]+i][coordinates[1]-i].getName().equals("") || currentBoard[coordinates[0]+i][coordinates[1]-i].isWhite() != isWhite()){
                int[] location = new int[] {coordinates[0]+i,coordinates[1]-i};
                moves.add(location);
                if(currentBoard[coordinates[0]+i][coordinates[1]-i].isWhite() != isWhite() && !currentBoard[coordinates[0]+i][coordinates[1]-i].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        try{
            int i=1;
            while (currentBoard[coordinates[0]-i][coordinates[1]+i].getName().equals("") || currentBoard[coordinates[0]-i][coordinates[1]+i].isWhite() != isWhite()){
                int[] location = new int[] {coordinates[0]-i,coordinates[1]+i};
                moves.add(location);
                if(currentBoard[coordinates[0]-i][coordinates[1]+i].isWhite() != isWhite() && !currentBoard[coordinates[0]-i][coordinates[1]+i].getName().equals("")){
                    break;
                }
                i++;
            }
        } catch (NullPointerException exception){

        } catch (ArrayIndexOutOfBoundsException exception) {

        }

        return moves;
    }
}
