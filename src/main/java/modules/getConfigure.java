package modules;

import classes.Register;
import classes.Users_new;
import org.hibernate.cfg.Configuration;

import javax.jws.soap.SOAPBinding;

public class getConfigure {

    static public Configuration getConfigure(){
        Configuration configure = new Configuration();
        configure.addAnnotatedClass(Register.class);
        configure.addAnnotatedClass(Users_new.class);
        configure.configure();
        return configure;
    }
}
