package Course.CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snail {

    public static void main(String[] args) {

//        System.out.println("test","test","tetst");


//        int[][] array
//                = {{1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9}};
//        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
//
//        snail(array);

    }

    public static int[] snail(int[][] array) {
        ArrayList<Integer> list = new ArrayList();
        while (array.length > 0){
            int[][] newArray = new int[array.length-1][array[0].length];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (i==0){
                        list.add(array[i][j]);
                    }else {
                        newArray[i-1][j] = array[i][j];
                    }
                }
            }
            array = newArray.length>0?reversMatrix(newArray):newArray;
        }
        int[] r = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            r[i] = list.get(i);
        }
        return r;
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


}
