package Course.ThreadTest.WorkerManager;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager(3,2);
        Thread managerThread = new Thread(manager);
        managerThread.start();

//        Thread managerThread_1 = new Thread(manager);
//        managerThread_1.start();

    }
}
