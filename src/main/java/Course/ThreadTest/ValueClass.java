package Course.ThreadTest;

public class ValueClass {
    private String now;

    public String getNow() {
        return now;
    }

    public void setNow(String now,boolean up) {
        System.out.print((up?"\n":"") + now);
        this.now = now;
    }

    public ValueClass(String now) {
        setNow(now,false);
    }
}
