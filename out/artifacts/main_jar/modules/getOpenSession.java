package modules;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static modules.getConfigure.getConfigure;

public class getOpenSession {
    public static Session getOpenSession(){
        Configuration configure = getConfigure();

        SessionFactory sessionFactory = configure.buildSessionFactory();
        Session session = sessionFactory.openSession();
        return session;
    }
}
