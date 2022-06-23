package progressBar;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class main {
    public static void main(String[] args) throws InterruptedException {

        Count count = new Count();
        count.count = 1;
        ProgressBar progressBar = new ProgressBar(count);

        Thread progressBarThread = new Thread(progressBar);
        progressBarThread.start();
        progressBarThread.interrupt();

        for (int i = 0; i < count.finalCount; i++) {
            Thread.sleep(1000);
            count.count++;
        }

        progressBarThread.interrupt();

        LinkedList<String> strings = new LinkedList<>();
        strings.add(0,"test");

        strings.get(0);

        HashMap<Integer,String> hashMap = new HashMap<>();
        //List


    }




}
