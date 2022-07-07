package Course;

public class Dsaw implements TestThread{
    @Override
    public void testMethod() {
        System.out.println("Start testMethod");
    }

    @Override
    public void run() {
        testMethod();
        System.out.println("Start run");
    }
}
