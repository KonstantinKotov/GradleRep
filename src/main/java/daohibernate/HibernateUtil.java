package daohibernate;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by k.kotov on 11.09.2017.
 */
public class HibernateUtil {
    public static SessionFactory factory;


    public static SessionFactory getSessionFactory() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        return factory;
    }
}
