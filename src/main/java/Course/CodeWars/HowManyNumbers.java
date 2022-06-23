package Course.CodeWars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HowManyNumbers {

    static int mediumNumber = 0;
    static List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(findAll_new(84,4));
//        System.out.println(findAll_new(27,3));
//        System.out.println(findAll_new(35,6));
//        System.out.println(findAll_new(35,4));
//        System.out.println(findAll(26,7));
//        System.out.println(findAll(22,7));
//        System.out.println(findAll(32,8));
//        System.out.println(findAll(35,4));
//        System.out.println(findAll(37,3));
//        System.out.println(findAll(36,8));
//        System.out.println(findAll(38,8));
//        System.out.println(findAll_new(38,17));
    }

    public static List<Long> findAll(int sumDigits, int numDigits) {

        Long begin = System.nanoTime();

        Long firstNumber = 0l;
        Long endNumber = 0l;
        String firstNumberStr = "";

        for (int i = 1; i < numDigits; i++) {
            firstNumberStr += "0";
        }
        firstNumberStr = "1" + firstNumberStr;

        firstNumber = Long.parseLong(firstNumberStr);
        endNumber = Long.parseLong(firstNumberStr + "0");

        List<Long> list = new ArrayList<>();

        list.add(0l);
        list.add(endNumber);
        list.add(0l);

        System.out.println(System.nanoTime() - begin);
        begin = System.nanoTime();

        for (Long i = firstNumber; i < endNumber; i++) {

            String value = String.valueOf(i);
            Integer sumVal = 0;
            Integer lastNumber = 10;
            Boolean allNumber = true;
            for (int j = 0; j < value.length(); j++) {
                Integer number = Integer.parseInt(value.substring(j,j+1));
                if (number>=lastNumber){
                    sumVal += number;
                    lastNumber = number;
                }else {
                    allNumber = false;
                    break;
                }
            }

            if (sumVal == sumDigits && allNumber) {
                list.set(0,list.get(0)+1);
                if (list.get(1) > i) list.set(1,i);
                if (list.get(2) < i) list.set(2,i);
            }


        }
        System.out.println(System.nanoTime() - begin);
        System.out.println(list);
        return list.get(0) == 0l?new ArrayList<>():list;
    }

    public static List<Long> findAll_new(final int sumDigits,final int numDigits) {
        strings = new ArrayList<>();
        for (Integer i = 1; i < 10; i++) {
            rec_FindAll(i,1,sumDigits,numDigits,i,i.toString());
        }

        List<Long> AnswerList = new ArrayList<Long>();

        if (strings.size() != 0){
            AnswerList = new ArrayList<>();

            AnswerList.add(Long.valueOf(strings.size()));
            AnswerList.add(Long.valueOf(strings.get(0)));
            AnswerList.add(Long.valueOf(strings.get(strings.size() - 1)));
        }
        return AnswerList;
    }

    private static String rec_FindAll(Integer number,
                                      Integer nowNumber,
                                      Integer sumDigits,
                                      Integer numDigits,
                                      Integer sum,
                                      String stringNumber){
        for (Integer i = number; i < 10; i++) {
            if (nowNumber == numDigits-1){
                if (sum + i == sumDigits){
                    return i.toString();
                }else if (sum + i >= sumDigits) return "";
            }else {
                if (sum + i >= sumDigits){
                    return "";
                }else {
                    String oneChar = rec_FindAll(i,nowNumber+1,sumDigits,numDigits,sum + i,stringNumber + i);//
                    String newStringNumber = stringNumber + i + oneChar;
                    if (newStringNumber.length() == numDigits)
                        strings.add(newStringNumber);
                }
            }
        }

        return "";
    }



}
