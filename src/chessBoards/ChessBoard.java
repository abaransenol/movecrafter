package chessBoards;

import chessPieces.BaseChessPiece;

public class ChessBoard {
    private BaseChessPiece[][] board;
    private boolean isWhitesTurn;
    private boolean[] canCastle;
    private int[] enPassantSquare;
    private int halfMoveCount;
    private int fullMoveCount;

    public ChessBoard(){
        this.setBoard(new BaseChessPiece[8][8]);
    }





    public BaseChessPiece[][] getBoard() {
        return board;
    }
    public void setBoard(BaseChessPiece[][] board) {
        this.board = board;
    }

    public boolean isWhitesTurn() {
        return isWhitesTurn;
    }
    public void setWhitesTurn(boolean whitesTurn) {
        isWhitesTurn = whitesTurn;
    }

    public boolean[] getCanCastle() {
        return canCastle;
    }
    public void setCanCastle(boolean[] canCastle) {
        this.canCastle = canCastle;
    }

    public int[] getEnPassantSquare() {
        return enPassantSquare;
    }
    public void setEnPassantSquare(int[] enPassantSquare) {
        this.enPassantSquare = enPassantSquare;
    }

    public int getHalfMoveCount() {
        return halfMoveCount;
    }
    public void setHalfMoveCount(int halfMoveCount) {
        this.halfMoveCount = halfMoveCount;
    }

    public int getFullMoveCount() {
        return fullMoveCount;
    }
    public void setFullMoveCount(int fullMoveCount) {
        this.fullMoveCount = fullMoveCount;
    }
}


/*
*
* Starting position fen code: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1
*
* --- Starting Board ---
*
*
        setWhitesTurn(true);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BaseChessPiece chessPiece = null;
                boolean isWhite = true;
                int[] coordinate = new int[]{i, j};

                if (j == 6 || j == 7) {
                    isWhite = false;
                }

                if (j == 6) {
                    chessPiece = new Pawn(coordinate, isWhite);
                } else if (j == 0 || j == 7) {
                    switch (i) {
                        case 0:
                        case 7:
                            chessPiece = new Rook(coordinate, isWhite);
                            break;
                        case 1:
                        case 6:
                            chessPiece = new Knight(coordinate, isWhite);
                            break;
                        case 2:
                        case 5:
                            chessPiece = new Bishop(coordinate, isWhite);
                            break;
                        case 3:
                            chessPiece = new Queen(coordinate, isWhite);
                            break;
                        case 4:
                            chessPiece = new King(coordinate, isWhite);
                            break;
                    }
                } else {
                    chessPiece = new NullPiece(coordinate, isWhite);
                }

                this.board[i][j] = chessPiece;
            }
        }
*
* */
