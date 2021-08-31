package dao;

import entities.Album;
import entities.Composition;
import entities.Musician;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactory;

import java.util.List;

public class AlbumDao {
    public Album findById(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Album.class, id);
        }
    }

    public void saveAlbum(Album album) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(album);
            transaction.commit();
        }
    }

    public void insertAlbum(int musicianId, Album album) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Musician musician = session.get(Musician.class, musicianId);
            musician.addAlbum(album);
            //album.setId_musician_fk(musician);
            session.update(musician);
            session.save(album);
            transaction.commit();
        }
    }

    public void updateAlbum(Album album) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(album);
            transaction.commit();
        }
    }

    public void deleteAlbum(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(session.get(Album.class, id));
            transaction.commit();
        }
    }

    public Composition findCompositionById(int id) {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            return session.get(Composition.class, id);
        }
    }

    public List<Album> selectAlbums() {
        try (Session session = HibernateSessionFactory.getSessionFactory().openSession()) {
            List<Album> albums = (List<Album>) session.createQuery("From Album").list();
            return albums;
        }
    }
}
