package otherSources;

public class Converter {
    private static String columns = "abcdefgh";

    public static String indexesToString(int[] indexes){
        String coordinate = "";
        coordinate = String.valueOf(columns.charAt(indexes[0])) + (indexes[1] + 1);

        return coordinate;
    }

    public static int[] stringToIndexes(String coordinate){
        int[] indexes = new int[2];
        for (int i=0; i<8;i++){
            if (columns.charAt(i) == coordinate.charAt(0)){
                indexes[0] = i;
            }
        }

        indexes[1] = coordinate.charAt(1) -1;
        return indexes;
    }
}

