package Course;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainClass {

    public static void main(String[] args) {

        Dsaw dsaw = new Dsaw();
        Thread thread = new Thread(dsaw);
        thread.start();


//        System.out.println("start " + Thread.currentThread().getName());
//
//        HelloThread helloThread = new HelloThread();
//
//        helloThread.start();
//
//        try {
//            helloThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println("end main");

    }

}
