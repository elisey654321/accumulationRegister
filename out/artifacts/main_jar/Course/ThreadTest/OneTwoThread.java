package Course.ThreadTest;

import Course.ThreadTest.TestMain;

import java.util.Scanner;

public class OneTwoThread extends Thread{

    ValueClass valueClass;

    public OneTwoThread(ValueClass valueClass) {
        this.valueClass = valueClass;
    }

    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(1000);
                if (valueClass.getNow().equals("1")) {
                    valueClass.setNow("-2",false);
                }else if (valueClass.getNow().equals("-2")){
                    valueClass.setNow("-3",false);
                }else if (valueClass.getNow().equals("-3")){
                    valueClass.setNow("-4",false);
                }else {
                    valueClass.setNow("1",true);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

}
