package Course.JMX;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class App {
    public static void main(String[] args) {
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        My mbean = new My();

        try {
            ObjectName name = new ObjectName("Course.JMX:type=My");//"ru.kvsspb.accumulationRegister.Course.JMX:type=My");
            mbs.registerMBean(mbean,name);
            System.out.println("Waiting forever...");
            Thread.sleep(Long.MAX_VALUE);
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (NotCompliantMBeanException e) {
            e.printStackTrace();
        } catch (InstanceAlreadyExistsException e) {
            e.printStackTrace();
        } catch (MBeanRegistrationException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
