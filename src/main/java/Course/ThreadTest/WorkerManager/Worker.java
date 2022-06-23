package Course.ThreadTest.WorkerManager;

public class Worker implements Runnable{
    public Worker(String nameManager) {
        this.nameManager = nameManager;
    }

    String nameManager = "";

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    @Override
    public void run() {
        System.out.println("Manager: " + nameManager + " Start worker number - " + Thread.currentThread().getName());
    }
}
