package Course.ThreadTest.WorkerManager;

public class Manager implements Runnable{

    private Integer countWorker = 0;
    private Thread[] workers;
    private Runnable runnable;
    private Integer quantity;

    public Manager(Integer countWorker, Integer quantity) {
        this.countWorker = countWorker;
        this.quantity = quantity;
        createWorker();
    }

    private void createWorker() {
        workers = new Thread[countWorker];
    }

    public void startWorker() throws InterruptedException {

        Boolean infinity = quantity == 0;
        if (infinity) quantity = 1;

        Integer count = 0;

        while (count < quantity){
            for (int i = 0; i < workers.length; i++) {
                Runnable runnable = new Worker(Thread.currentThread().getName());
                workers[i] = new Thread(runnable);
                workers[i].start();
            }

            for (int i = 0; i < workers.length; i++) {
                workers[i].join();
            }

            System.out.println("Manager - " + Thread.currentThread().getName());
            if (!infinity) count++;
        }
    }

    @Override
    public void run() {
        try {
            startWorker();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
