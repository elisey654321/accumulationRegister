package Course;

public class HelloThread extends Thread{

    @Override
    public void run() {
        System.out.println("hello from " + getName());
    }

}
