package chessPieces;

import java.util.ArrayList;

public abstract class BaseChessPiece {
    private String name;
    private int[] coordinate;
    private boolean isWhite;

    public BaseChessPiece(int[] coordinate, boolean isWhite){
        this.coordinate = coordinate;
        this.isWhite = isWhite;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getCoordinate() {
        return coordinate;
    }

    public boolean isWhite() {
        return isWhite;
    }





    public abstract ArrayList<int[]> canGo(BaseChessPiece[][] currentBoard);
}
