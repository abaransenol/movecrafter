package chessPieces;

import chessBoards.ChessBoard;

import java.util.ArrayList;

public abstract class BaseChessPiece {
    private String name;
    private boolean isWhite;

    public BaseChessPiece(boolean isWhite){
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isWhite() {
        return isWhite;
    }





    public abstract ArrayList<int[]> canGo(ChessBoard chessBoard, int[] coordinates);
}
