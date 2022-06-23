package Course.CodeWars;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Smaller {

    public static int [] smaller(int[] unsorted) {

        int[] sorted = unsorted.clone();
        Arrays.sort(sorted);

        Node node = new Node(0);

        int lefties = -1;

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] == node.value){
                node.occurences++;
            }else {
                int val = sorted[i];
                Node nNode = new Node(val);
                lefties += node.occurences;
                nNode.lefties = lefties;
                node.right = nNode;
                nNode.left = node;
                node = nNode;
            }
        }

        while (unsorted[0] != node.value) node = node.left;

        int count = 0;
        int onRight = 0;
        int onLeft = 0;
        int result = 0;
        while (true){
            if (unsorted[count] == node.value){
                unsorted[count] = node.lefties;
                count++;
                Node nNode = node.right;
//                while (nNode != null){
//                    nNode.lefties -= 1;
//                    nNode = nNode.right;
//                }
            }else if (unsorted[count] < node.value){
                node = node.left;
                onLeft++;
                onRight=0;
            }else if (unsorted[count] > node.value){
                node = node.right;
                onRight += node.occurences;
                onLeft = 0;
            }
            if (count == unsorted.length){
                break;
            }
        }
        return unsorted;
    }

    public static int[] oldSmaller(int[] unsorted) {
        int[] sorted = unsorted.clone();
        Arrays.sort(sorted);
        ArrayList<Integer> listSorted = new ArrayList<>();

        for (int i = 0; i < sorted.length; i++) {
            listSorted.add(sorted[i]);
        }

        for (int i = 0; i < unsorted.length; i++) {
            int result = listSorted.indexOf(unsorted[i]);
            unsorted[i] = result;
            listSorted.remove(result);
        }
        return unsorted;
    }

    public static void main(String[] args) {
//        assertArrayEquals(new int[] {4, 3, 2, 1,0}, Smaller.smaller(new int[] {5,4,3,2,1}));
////        assertArrayEquals(new int[] {0,0,0}, Smaller.oldSmaller(new int[] {1,2,3}));
//        assertArrayEquals(new int[] {0,0,0}, Smaller.smaller(new int[] {1,2,3}));
//        assertArrayEquals(new int[] {1,1,0}, Smaller.smaller(new int[] {1,2,0}));
//        assertArrayEquals(new int[] {0,1,0}, Smaller.smaller(new int[] {1,2,1}));
//        assertArrayEquals(new int[] {3,3,0,0,0}, Smaller.smaller(new int[] {1,1,-1,0,0}));
//        assertArrayEquals(new int[] {4, 1, 5, 5, 0, 0, 0, 0, 0}, Smaller.smaller(new int[] {5, 4, 7, 9, 2, 4, 4, 5, 6}));
//        assertArrayEquals(new int[] {5, 2, 6, 6, 1, 1, 0, 0, 0, 0}, Smaller.smaller(new int[] {5, 4, 7, 9, 2, 4, 1, 4, 5, 6}));
//        Smaller.smaller(new int[] {2, 4, 1, 4, 5, 6});
        int[] bigArr = createBigSizedArr((int) (Math.random() * 100000));
        for (int i = 0; i < 100; i++) {
            Smaller.smaller(bigArr);
        }
//        Arrays.stream(Smaller.smaller(new int[]{3, 2, 2, 3, 1})).forEach(x -> System.out.println(x));

    }

    private static void assertArrayEquals(int[] ints, int[] smaller) {
        boolean same = true;
        if (ints.length == smaller.length){
            for (int i = 0; i < ints.length; i++) {
                if (ints[i] != smaller[i]){
                    same = false;
                }
            }
        }else same = false;
        System.out.println(same);
    }

    private static int[] createBigSizedArr(Integer size){
        int[] bigArr = new int[size];

        for (int i = 0; i < size-1; i++) {
            bigArr[i] = (int) (Math.random() * 10000);
        }
        return bigArr;
    }

    private static class Node {
        int occurences;
        int value;
        int lefties;
        Node left;
        Node right;

        private Node(int x) {
            occurences = 1;
            lefties = 0;
            value = x;
            left = null;
            right = null;
        }
    }

}
