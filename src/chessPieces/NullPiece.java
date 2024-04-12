package chessPieces;

import chessBoards.ChessBoard;

import java.util.ArrayList;

public class NullPiece extends BaseChessPiece{
    public NullPiece() {
        super(true);
        setName("");
    }

    @Override
    public ArrayList<int[]> canGo(ChessBoard chessBoard, int[] coordinates) {
        return null;
    }
}
