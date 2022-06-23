package modules;

import classes.Register;
import org.hibernate.cfg.Configuration;

public class getConfigure {

    static public Configuration getConfigure(){
        Configuration configure = new Configuration();
        configure.addAnnotatedClass(Register.class);
        configure.configure();
        return configure;
    }
}
