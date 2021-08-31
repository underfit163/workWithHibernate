package dao;

import entities.Album;
import entities.Musician;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class MusicianDao {
    public Musician findById(int id)
    {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession())
        {
            return session.get(Musician.class,id);
        }
    }

    public void saveMusician(Musician musician)
    {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.save(musician);
            transaction.commit();
        }
    }

    public void updateMusician(Musician musician)
    {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.update(musician);
            transaction.commit();
        }
    }
    public void deleteMusician(int id)
    {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Musician.class,id));
            transaction.commit();
        }
    }
    public Album findAlbumById(int id)
    {
        try(Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Album.class,id);
        }
    }

    public List<Musician> selectMusician() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Musician> musicians =(List<Musician>) session.createQuery("From Musician").list();
            return musicians;
        }
    }
}
