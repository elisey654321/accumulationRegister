package Course.CodeWars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kata {

    ArrayList<Long> result = new ArrayList<>();

    public static void main(String[] args) {
//        nextBiggerNumber(12l);
//        System.out.println(nextBiggerNumber(513l));
//        System.out.println(nextBiggerNumber(2017l));
//        System.out.println(nextBiggerNumber(414l));
//        System.out.println(nextBiggerNumber(144l));
//        System.out.println(nextBiggerNumber(10990l));
//        System.out.println(nextBiggerNumber(1623588465l));
        System.out.println(nextBiggerNumber(123456789l));
    }

    public static long nextBiggerNumber(long n){
        Long number = n;
        String sNumber = number.toString();
        String BigLongString = "0";
        for (int i = 2; i < sNumber.length()+1; i++) {
            Long nNumber = Long.parseLong(sNumber.substring(sNumber.length() - i));
            Long nBigLong = getLong(nNumber);
            if (nBigLong > nNumber){
                BigLongString = sNumber.substring(0,sNumber.length() - i) + nBigLong.toString();
                break;
            }
        }

        Long result = Long.parseLong(BigLongString);
        if (result.equals(0l)){
            result = -1l;
        }
        return result;
    }

    private static Long getLong(Long number){
        Long nNumber = number;
        Long aNumber = 0l;
        ArrayList arrayListNumber = getArrayAllSymbol(nNumber.toString());
        ArrayList<String> arrayList = new ArrayList<>();
        ArrayList<Long> arrayListLong = new ArrayList<>();
        getArrRec(arrayListNumber,arrayList,"");

        for (int i = 0; i < arrayList.size(); i++) {
            arrayListLong.add(Long.parseLong(arrayList.get(i)));
        }

        Collections.sort(arrayListLong);

        Integer index = arrayListLong.indexOf(nNumber);
        while (arrayListLong.size() > index+1){
            if (arrayListLong.get(index+1).equals(number)){
                index++;
            }else if (arrayListLong.get(index+1)>number){
                aNumber = arrayListLong.get(index+1);
                break;
            }
        }
        return aNumber;
    }

    private static ArrayList getArrayAllSymbol(String number){

        ArrayList<String> arrayList = new ArrayList<>();

        for (int i = 0; i < number.length(); i++) {
            arrayList.add(number.substring(i,i+1));
        }

        return arrayList;
    }

    private static String getArrRec(ArrayList<String> arrayListNumber,ArrayList<String> arrayList,String result){
        for (int i = 0; i < arrayListNumber.size(); i++) {
            if (arrayListNumber.size() == 1){
                result += arrayListNumber.get(i);
                arrayList.add(result);
                return arrayListNumber.get(i);
            }else {
                ArrayList<String> newArr = (ArrayList<String>) arrayListNumber.clone();
                newArr.remove(i);
                getArrRec(newArr,arrayList,result + arrayListNumber.get(i));
            }
        }
        return "";
    }

}
