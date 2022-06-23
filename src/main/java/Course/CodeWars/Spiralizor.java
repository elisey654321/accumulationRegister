package Course.CodeWars;

import java.util.ArrayList;
import java.util.List;

public class Spiralizor {

    public static int[][] spiralize(int size) {
        int[][] array = createMatrix(size);
        int revers = 0;
        Integer x1 = 0;
        Integer x2 = size;
        Integer y1 = 0;
        Integer y2 = size;
        array[0][0] = 1;

        while (true){

            List<Integer> find = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                if (array[y1][i] == 1){
                    find.add(i);
                }
            }

            boolean first = true;

            while (find.size()>2){
                if (first) find.remove(0);
                else find.remove(find.size()-1);
                first = !first;
            }

            if (find.size() == 1){
                x1 = 1;
                x2 = size;
            }else if (find.size() == 2){
                x1 = find.get(0);
                x2 = find.get(1) - 1;
            }

            for (int i = x1; i < x2; i++) {
                array[y1][i] = 1;
            }
            y1 = y2-x2;

            revers++;
            if (revers == size) break;

            array = reversMatrix(array);

        }

        while (array[1][0]!=0)array = reversMatrix(array);

        return array;
    }

    private static int[][] reversMatrix(int[][] matrix){
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[j][i] = matrix[i][matrix[i].length - j - 1];
            }
        }
        return result;
    }

    private static int[][]createMatrix(int size){
        int [][] result = new int[size][size];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Spiralizor.spiralize(5);
    }
}
