package chessBoards;

import chessPieces.BaseChessPiece;

public abstract class BaseChessBoard {
    protected BaseChessPiece[][] board;

    private boolean isWhitesTurn;
    private boolean canWhiteCastleKingSide;
    private boolean canWhiteCastleQueenSide;
    private boolean canBlackCastleKingSide;
    private boolean canBlackCastleQueenSide;

    public BaseChessBoard(){
        this.board = new BaseChessPiece[8][8];
    }
    public BaseChessPiece[][] getBoard() {
        return board;
    }

    public boolean isWhitesTurn() {
        return isWhitesTurn;
    }

    public void setWhitesTurn(boolean whitesTurn) {
        isWhitesTurn = whitesTurn;
    }

    public boolean isCanWhiteCastleKingSide() {
        return canWhiteCastleKingSide;
    }

    public void setCanWhiteCastleKingSide(boolean canWhiteCastleKingSide) {
        this.canWhiteCastleKingSide = canWhiteCastleKingSide;
    }

    public boolean isCanWhiteCastleQueenSide() {
        return canWhiteCastleQueenSide;
    }

    public void setCanWhiteCastleQueenSide(boolean canWhiteCastleQueenSide) {
        this.canWhiteCastleQueenSide = canWhiteCastleQueenSide;
    }

    public boolean isCanBlackCastleKingSide() {
        return canBlackCastleKingSide;
    }

    public void setCanBlackCastleKingSide(boolean canBlackCastleKingSide) {
        this.canBlackCastleKingSide = canBlackCastleKingSide;
    }

    public boolean isCanBlackCastleQueenSide() {
        return canBlackCastleQueenSide;
    }

    public void setCanBlackCastleQueenSide(boolean canBlackCastleQueenSide) {
        this.canBlackCastleQueenSide = canBlackCastleQueenSide;
    }
}
