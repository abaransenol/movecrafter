package chessBoards;

import chessPieces.BaseChessPiece;

public abstract class BaseChessBoard {
    protected BaseChessPiece[][] board;

    public BaseChessBoard(){
        this.board = new BaseChessPiece[8][8];
    }
}
