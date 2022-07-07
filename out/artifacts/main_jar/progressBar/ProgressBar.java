package progressBar;

public class ProgressBar implements Runnable {

    Count count;
    final Integer endCount = count.finalCount;

    public ProgressBar(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        synchronized (count){
            while (true){

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                System.out.print("(");

                for (int i = 0; i < endCount; i++) {
                    if (count.count < i){
                        System.out.print("_");
                    }else System.out.print("#");
                }
                System.out.print(")");

                if (endCount == count.count) break;
            }
        }
    }

    public void setCount(Integer count) {
        this.count.count = count;
    }
}


