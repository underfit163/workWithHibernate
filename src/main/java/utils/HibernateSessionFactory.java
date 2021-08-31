package utils;

import entities.Album;
import entities.Composition;
import entities.Musician;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory ==null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Musician.class);
                configuration.addAnnotatedClass(Album.class);
                configuration.addAnnotatedClass(Composition.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }

    public static Session getSession() throws HibernateException
    {
        return  getSessionFactory().openSession();
    }
}