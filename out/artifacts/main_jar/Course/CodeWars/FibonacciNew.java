package Course.CodeWars;

import java.math.BigInteger;

public class FibonacciNew {

    public static void main(String[] args) {
//        fib1(new BigInteger("1233392"));
//        System.out.println("0 = " + fib1(new BigInteger("0")));
//        System.out.println("1 = " + fib1(new BigInteger("1")));
//        System.out.println("2 = " + fib1(new BigInteger("2")));
//        System.out.println("3 = " + fib1(new BigInteger("3")));
//        System.out.println("4 = " + fib1(new BigInteger("4")));
//        System.out.println("5 = " + fib1(new BigInteger("5")));
//        System.out.println("6 = " + fib1(new BigInteger("6")));
        System.out.println("-6 = " + fib1(new BigInteger("-6")));
    }

    private static BigInteger[][] multiplyMatrix(BigInteger[][] matrix1,BigInteger[][] matrix2){

        BigInteger[][] newMatrix = new BigInteger[matrix1.length][matrix1.length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[i].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    if (newMatrix[i][j] == null) newMatrix[i][j] = BigInteger.ZERO;
                    newMatrix[i][j] = newMatrix[i][j].add(matrix1[i][k].multiply(matrix2[j][k]));
                }
            }

        }
        return newMatrix;
    }

    public static BigInteger fib1(BigInteger n){
        BigInteger nBI = n.multiply(n.min(BigInteger.ZERO) != BigInteger.ZERO?new BigInteger("-1"):BigInteger.ONE);
        Integer n1 = nBI.intValue();
        BigInteger[][] emptyMatrix = getEmptyMatrix();
        BigInteger[][] newMatrix = recursionFib(emptyMatrix,n1,getEmptyMatrix());

        BigInteger answerBI = n.intValue() < 0 && n.intValue()%2 == 0?newMatrix[0][1].multiply(new BigInteger("-1")):newMatrix[0][1];
        return answerBI;
    }

    @Deprecated
    public static BigInteger fib(BigInteger n){
        if (n == BigInteger.ZERO) return BigInteger.ZERO;

        BigInteger[][] emptyMatrix = getEmptyMatrix();
        BigInteger[][] newMatrix = getEmptyMatrix();
        BigInteger nBI = n.multiply(n.min(BigInteger.ZERO) != BigInteger.ZERO?new BigInteger("-1"):BigInteger.ONE);

        Integer n1 = nBI.intValue();
        if (n1%2 == 0) {
            for (int i = 0; i < (n1 -1)/ 2; i++) {
                newMatrix = multiplyMatrix(newMatrix, emptyMatrix);
            }
            newMatrix = multiplyMatrix(newMatrix, newMatrix);
            newMatrix = multiplyMatrix(newMatrix, emptyMatrix);
        }else {
            for (int i = 0; i < n1 / 2; i++) {
                newMatrix = multiplyMatrix(newMatrix, emptyMatrix);
            }
            newMatrix = multiplyMatrix(newMatrix, newMatrix);
        }

        BigInteger answerBI = n.intValue() < 0 && n.intValue()%2 == 0?newMatrix[1][1].multiply(new BigInteger("-1")):newMatrix[1][1];

        return answerBI;

    }

    private static BigInteger[][] getEmptyMatrix(){
        BigInteger[][] newMatrix = new BigInteger[2][2];

        newMatrix[0][0] = BigInteger.ONE;
        newMatrix[0][1] = BigInteger.ONE;
        newMatrix[1][0] = BigInteger.ONE;
        newMatrix[1][1] = BigInteger.ZERO;

        return newMatrix;
    }

    private static BigInteger[][] recursionFib(BigInteger[][] matrix1,Integer n,BigInteger[][] identity_matrix){

        BigInteger[][] matrix2;

        if (n.equals(0)){
            return identity_matrix;
        }else if (n.equals(1)){
            return matrix1;
        }else {
            Integer n1 = n/2;

            matrix2 = recursionFib(matrix1,n1,identity_matrix);
            matrix2 = multiplyMatrix(matrix2,matrix2);
            if ((n%2)!=0){
                matrix2 = multiplyMatrix(identity_matrix,matrix2);
            }
            return matrix2;
        }

    }

}
