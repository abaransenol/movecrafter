package chessBoards;

import java.util.ArrayList;

public class CustomChessBoard extends BaseChessBoard{
    private String fenCode;

    public CustomChessBoard(String fenCode){
        super();
        this.fenCode = fenCode;

        ArrayList<String> lines = new ArrayList<String>();
        for (String word : fenCode.split("/")){
            lines.add(word);
        }

        //do that shit

    }


}
