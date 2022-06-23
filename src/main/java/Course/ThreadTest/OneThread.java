package Course.ThreadTest;

public class OneThread extends Thread{
    public ValueClass valueClass;

    public OneThread(ValueClass valueClass) {
        this.valueClass = valueClass;
    }

    public ValueClass getValueClass() {
        return valueClass;
    }

    public void setValueClass(ValueClass valueClass) {
        this.valueClass = valueClass;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (valueClass.getNow().equals("-2")) {
                valueClass.setNow("1", true);
            }
        }
    }

}
