package chessBoards;

import chessPieces.*;
import otherSources.Converter;

/*
 * i => chess boards column index.
 * j => chess boards line index.
 *
 *
 *
 * */

public class MainChessBoard extends BaseChessBoard{
    public MainChessBoard() {
        super();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                BaseChessPiece chessPiece = null;
                boolean isWhite = true;
                int[] coordinate = new int[]{i, j};

                if (j == 6 || j == 7) {
                    isWhite = false;
                }

                if ( j == 6) {
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
    }

    public BaseChessPiece[][] getBoard() {
        return board;
    }

    public BaseChessPiece getPiece(String coordinate){
        int[] indexes = Converter.stringToIndexes(coordinate);

        return board[indexes[0]][indexes[1]];
    }

    public boolean canShortCastle(King king, Rook rook){
        if ((!king.isMoved() && !rook.isMoved() && rook.getCoordinate()[0] == 7) && (board[5][0].getName().equals("") && board[6][0].getName().equals(""))){
            return true;
        }

        return false;
    }

    public boolean canLongCastle(King king, Rook rook){
        if ((!king.isMoved() && !rook.isMoved() && rook.getCoordinate()[0] == 0) && (board[1][0].getName().equals("") && board[2][0].getName().equals("") && board[3][0].getName().equals(""))){
            return true;
        }

        return false;
    }
}
