package chessBoards;

import chessPieces.*;
import otherSources.Converter;

import java.util.ArrayList;

public class ChessBoardManager {
    public ChessBoard fenCodeToChessBoard(String fenCode) {
        ChessBoard chessBoard = new ChessBoard();
        BaseChessPiece[][] board = new BaseChessPiece[8][8];
        boolean isCastleAvailable = true;

        //FEN code will be separated to fields.
        ArrayList<String> fields = new ArrayList<String>();
        for (String field : fenCode.split(" ")){
            fields.add(field);
        }
        if (fields.size() == 5) {
            isCastleAvailable = false;
        }

        //Placement data will be separated to lines.
        ArrayList<String> lines = new ArrayList<String>();
        for (String line : fields.get(0).split("/")){
            lines.add(line);
        }






        // ----- Fields features will be paired except placement data. -----

        // turn codes
        if (fields.get(1).equals("w")) {
            chessBoard.setWhitesTurn(true);
        } else {
            chessBoard.setWhitesTurn(false);
        }

        // castling codes
        boolean[] canCastle = {false, false, false, false};
        if (isCastleAvailable) {
            String canCastleString = fields.get(2);

            for (int i = 0; i < canCastleString.length(); i++) {
                String letter = String.valueOf(canCastleString.charAt(i));
                switch (letter) {
                    case "K" -> canCastle[0] = true;
                    case "Q" -> canCastle[1] = true;
                    case "k" -> canCastle[2] = true;
                    case "q" -> canCastle[3] = true;
                }
            }
        }
        chessBoard.setCanCastle(canCastle);


        // en passant codes
        String enPassantSquare = fields.get(isCastleAvailable ? 3 : 2);
        if (enPassantSquare.equals("-")) {
            chessBoard.setEnPassantSquare(new int[] {});
        } else {
            int[] enPassantMove = Converter.stringToIndexes(enPassantSquare);
            chessBoard.setEnPassantSquare(enPassantMove);
        }

        // halfmove codes
        chessBoard.setHalfMoveCount(Integer.parseInt(fields.get(isCastleAvailable ? 4 : 3)));

        // fullmove codes
        chessBoard.setFullMoveCount(Integer.parseInt(fields.get(isCastleAvailable ? 5 : 4)));





        // ----- Placement data will be set up -----

        // The process starts from left bottom corner to right top corner of the board.
        for (int line = 0; line < 8; line++) {
            String currentFenCodeLine = lines.get(line);
            int convertedColumn = 0;

            for (int column = 0; column < currentFenCodeLine.length(); column++) {
                String currentLetter = String.valueOf(currentFenCodeLine.charAt(column));
                boolean isWhite = false;
                BaseChessPiece piece;

                if (currentLetter.toUpperCase().equals(currentLetter)) {
                    isWhite = true;
                }

                try {
                    int numberOfNulls = Integer.parseInt(currentLetter);

                    for (int j = 0; j < numberOfNulls; j++){
                        piece = new NullPiece();
                        board[convertedColumn][7-line] = piece;
                        convertedColumn++;
                    }

                } catch (NumberFormatException exception) {
                    switch (currentLetter.toLowerCase()) {
                        case "r":
                            piece = new Rook(isWhite);
                            break;
                        case "n":
                            piece = new Knight(isWhite);
                            break;
                        case "b":
                            piece = new Bishop(isWhite);
                            break;
                        case "q":
                            piece = new Queen(isWhite);
                            break;
                        case "k":
                            piece = new King(isWhite);
                            break;
                        default:
                            piece = new Pawn(isWhite);
                            break;
                    }

                    board[convertedColumn][7-line] = piece;
                    convertedColumn++;
                }
            }
        }

        chessBoard.setBoard(board);

        return chessBoard;
    }










    public String boardToFenCode(ChessBoard chessBoard) {
        StringBuilder fenCode = new StringBuilder();

        BaseChessPiece[][] board = chessBoard.getBoard();
        boolean isWhitesTurn = chessBoard.isWhitesTurn();
        boolean[] canCastle = chessBoard.getCanCastle();
        int[] enPassantSquare = chessBoard.getEnPassantSquare();
        int halfMoveCount = chessBoard.getHalfMoveCount();
        int fullMoveCount = chessBoard.getFullMoveCount();



        // --- Chess board data will be transformed to fen code string. ---

        for (int line = 7; line >= 0; line--){
            int counter = 0;

            for (int column = 0; column <= 7; column++) {
                BaseChessPiece chessPiece = board[column][line];

                switch (chessPiece.getName()) {
                    case "Rook":
                        if (counter > 0) {
                            fenCode.append(counter);
                            counter = 0;
                        }
                        if (chessPiece.isWhite()) {
                            fenCode.append("R");
                        } else {
                            fenCode.append("r");
                        }
                        break;
                    case "Knight":
                        if (counter > 0) {
                            fenCode.append(counter);
                            counter = 0;
                        }
                        if (chessPiece.isWhite()) {
                            fenCode.append("N");
                        } else {
                            fenCode.append("n");
                        }
                        break;
                    case "Bishop":
                        if (counter > 0) {
                            fenCode.append(counter);
                            counter = 0;
                        }
                        if (chessPiece.isWhite()) {
                            fenCode.append("B");
                        } else {
                            fenCode.append("b");
                        }
                        break;
                    case "Queen":
                        if (counter > 0) {
                            fenCode.append(counter);
                            counter = 0;
                        }
                        if (chessPiece.isWhite()) {
                            fenCode.append("Q");
                        } else {
                            fenCode.append("q");
                        }
                        break;
                    case "King":
                        if (counter > 0) {
                            fenCode.append(counter);
                            counter = 0;
                        }
                        if (chessPiece.isWhite()) {
                            fenCode.append("K");
                        } else {
                            fenCode.append("k");
                        }
                        break;
                    case "Pawn":
                        if (counter > 0) {
                            fenCode.append(counter);
                            counter = 0;
                        }

                        if (chessPiece.isWhite()) {
                            fenCode.append("P");
                        } else {
                            fenCode.append("p");
                        }
                        break;
                    default:
                        counter++;
                        break;
                }
            }
            if (counter > 0) {
                fenCode.append(counter);
            }

            fenCode.append("/");
        }
        fenCode.deleteCharAt(fenCode.length() - 1);

        // Turn part
        if (isWhitesTurn) {
            fenCode.append(" w ");
        } else {
            fenCode.append(" b ");
        }

        // Castling part
        /*
         * Definition of canCastle parameter
         *
         * index 0: White's king side castle
         * index 1: White's queen side castle
         * index 2: Black's king side castle
         * index 3: Black's queen side castle
         *
         * */

        String castlingSymbols = "KQkq";
        boolean anyCastleOption = false;
        for (int i=0; i < 4; i++) {
            if (canCastle[i]) {
                fenCode.append(castlingSymbols.charAt(i));
                anyCastleOption = true;
            }
        }

        if (!anyCastleOption) {
            fenCode.deleteCharAt(fenCode.length() - 1);
        }

        //en passant part
        if (enPassantSquare.length < 2) {
            fenCode.append(" - ");
        } else {
            fenCode.append(Converter.indexesToString(enPassantSquare) + " ");
        }

        // half and full move part
        fenCode.append(halfMoveCount + " " + fullMoveCount);

        return fenCode.toString();
    }
}
