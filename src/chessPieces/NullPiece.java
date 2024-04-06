package chessPieces;

import java.util.ArrayList;

public class NullPiece extends BaseChessPiece{
    public NullPiece(int[] coordinate, boolean isWhite) {
        super(coordinate, isWhite);
        setName("");
    }

    @Override
    public ArrayList<int[]> canGo(BaseChessPiece[][] board) {
        return null;
    }
}
