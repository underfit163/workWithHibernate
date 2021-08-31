package dao;

import entities.Album;
import entities.Composition;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class CompositionDao {

    public Composition findById(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Composition.class, id);
        }
    }

    public void saveComposition(Composition composition) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(composition);
            transaction.commit();
        }
    }

    public void insertComposition(int albumId, Composition composition) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Album album = session.get(Album.class, albumId);

            album.addComposition(composition);
            // composition.setId_album_fk(album);
            session.update(album);
            session.save(composition);
            transaction.commit();
        }
    }

    public void updateComposition(Composition composition) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(composition);
            transaction.commit();
        }
    }

    public void deleteComposition(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Composition.class, id));
            transaction.commit();
        }
    }

    public List<Composition> selectCompositions() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Composition> compositions = (List<Composition>) session.createQuery("From Composition").list();
            return compositions;
        }
    }
}

