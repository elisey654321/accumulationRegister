package Course.JMX;

public class My implements MyMBean {

    String name = "";

    @Override
    public String getMyName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void writeToConsole(String message) {
        System.out.println(message);
    }
}
