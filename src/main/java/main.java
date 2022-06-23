
import classes.Register;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;

import static modules.getConfigure.getConfigure;
import static modules.getOpenSession.getOpenSession;

public class main {
    public static void main(String[] args) {

        try {

            Session session = getOpenSession();
            session.beginTransaction();

            Register register = Register.builder().item("test").count(1).id(4).build();
            NativeQuery sqlQuery = session.createSQLQuery(getQuery()).addEntity(Register.class);

            ArrayList<Register> list = (ArrayList) sqlQuery.list();

            for (Register reg:list) {
                System.out.println("item: " + reg.getItem().replace("  ","") + "| count: " + reg.getCount());
            }

            session.getTransaction().commit();


        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }


    }

    private static String getQuery(){
        return "select max(id) as id,\n" +
                "       item as item,\n" +
                "       SUM(count) as count\n" +
                "from register\n" +
                "group by item";
    }

}
