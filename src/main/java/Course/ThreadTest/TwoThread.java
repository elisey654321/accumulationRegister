package Course.ThreadTest;

public class TwoThread extends Thread{
    public ValueClass valueClass;

    public TwoThread(ValueClass valueClass) {
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

            if (valueClass.getNow().equals("1")) {
                valueClass.setNow("-2", false);
            }
        }

    }

}
