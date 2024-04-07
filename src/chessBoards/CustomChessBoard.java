package chessBoards;

import chessPieces.*;

import java.util.ArrayList;

// Starting position fen code: rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1

public class CustomChessBoard extends BaseChessBoard{
    private String fenCode;

    public CustomChessBoard(String fenCode){
        super();
        this.fenCode = fenCode;

        //FEN code will be separated to fields.
        ArrayList<String> fields = new ArrayList<String>();
        for (String field : fenCode.split(" ")){
            fields.add(field);
        }

        //Placement data will be separated to lines.
        ArrayList<String> lines = new ArrayList<String>();
        for (String line : fields.get(0).split("/")){
            lines.add(line);
        }






        // ----- Fields features will be paired except placement data. -----

        // turn codes
        if (fields.get(1).equals("w")) {
            setWhitesTurn(true);
        } else {
            setWhitesTurn(false);
        }

        // castling codes

        // en passant codes

        // halfmove codes

        // fullmove codes





        // ----- Placement data will be set up -----

        // The process starts from left bottom corner to right top corner of the board.
        for (int line = 0; line < 8; line++) {
            String currentFenCodeLine = lines.get(line);
            System.out.println(currentFenCodeLine);
            int convertedRow = 0;

            for (int row = 0; row < currentFenCodeLine.length(); row++) {
                String currentLetter = String.valueOf(currentFenCodeLine.charAt(row));
                boolean isWhite = false;
                BaseChessPiece piece;

                if (currentLetter.toUpperCase().equals(currentLetter)) {
                    isWhite = true;
                }

                try {
                    int numberOfNulls = Integer.parseInt(currentLetter);

                    for (int j = 0; j < numberOfNulls; j++){
                        piece = new NullPiece(new int[] {convertedRow, line}, isWhite);
                        this.board[convertedRow][7-line] = piece;
                        convertedRow++;
                    }

                } catch (NumberFormatException exception) {
                    switch (currentLetter.toLowerCase()) {
                        case "r":
                            piece = new Rook(new int[] {convertedRow, line}, isWhite);
                            break;
                        case "n":
                            piece = new Knight(new int[] {convertedRow, line}, isWhite);
                            break;
                        case "b":
                            piece = new Bishop(new int[] {convertedRow, line}, isWhite);
                            break;
                        case "q":
                            piece = new Queen(new int[] {convertedRow, line}, isWhite);
                            break;
                        case "k":
                            piece = new King(new int[] {convertedRow, line}, isWhite);
                            break;
                        default:
                            piece = new Pawn(new int[] {convertedRow, line}, isWhite);
                            break;
                    }

                    this.board[convertedRow][7-line] = piece;
                }

                convertedRow++;
            }
        }
    }
}
