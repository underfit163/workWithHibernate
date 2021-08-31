import dao.AlbumDao;
import dao.CompositionDao;
import dao.MusicianDao;
import entities.Album;
import entities.Composition;
import entities.Musician;
import org.hibernate.QueryException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateSessionFactory;

import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        AlbumDao albumDao = new AlbumDao();
        CompositionDao compDao = new CompositionDao();
        MusicianDao musicianDao = new MusicianDao();
        /*Musician Andrey = new Musician("Andrey");
        Musician Georgy = new Musician("Georgy");
        Musician Bond = new Musician("Bond");
        Musician Alex = new Musician("Alex");
        Musician Sergey = new Musician("Sergey");

        Album Loaded = new Album("Laded","Pop");
        Album Paranoid = new Album("Paranoid","Rock");
        Album Tim = new Album("Tim","Pop");
        Album Closer = new Album("Closer","Rap");
        Album Desire = new Album("Desire","Jazz");

        Composition Squad = new Composition("Squad",50);
        Composition Cream = new Composition("Cream",7);
        Composition Soda = new Composition("Soda",4);
        Composition Gorit = new Composition("Gorit",8);
        Composition Kiss = new Composition("Kiss",20);
        Composition Girl = new Composition("Girl",20);
        Composition Boy = new Composition("Boy",3);


        //-----------------------------------Заполнение данными:---------------------------------------------------
        Andrey.addAlbum(Loaded);

        Georgy.addAlbum(Paranoid);
        Paranoid.addComposition(Squad);
        Paranoid.addComposition(Cream);
        Paranoid.addComposition(Soda);
        musicianDao.saveMusician(Georgy);

        Bond.addAlbum(Closer);
        Bond.addAlbum(Desire);
        Closer.addComposition(Kiss);
        Desire.addComposition(Girl);
        Desire.addComposition(Boy);

        Alex.addAlbum(Tim);
        Tim.addComposition(Gorit);

        musicianDao.saveMusician(Andrey);
        musicianDao.saveMusician(Georgy);
        musicianDao.saveMusician(Bond);
        musicianDao.saveMusician(Alex);
        musicianDao.saveMusician(Sergey);

        //-----------------------Вывод данных:---------------
        for (var item : musicianDao.selectMusician())
        {
            System.out.println(item);
        }
        for (var item:
             albumDao.selectAlbums()) {
            System.out.println(albumDao.findById(item.getId_album())+" НАПИСАН: "+ musicianDao.findById(item.getId_musician_fk().getId_musician()));
        }
        for (var item:
             compDao.selectCompositions()) {
            System.out.println(item);
        }*/
        //--------------------удаление и редактирование данных в любой из таблиц-----------
       /* compDao.deleteComposition(7);
        for (var item:
                compDao.selectCompositions()) {
            System.out.println(item);
        }*/

       /* Composition Gorit = new Composition("Gorit",8);
        compDao.insertComposition(5,Gorit);
        for (var item:
                compDao.selectCompositions()) {
            System.out.println(item);
        }
        //-------------update через язык запросов---------
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("UPDATE Composition set duration_composition = 100 where name_composition = :name");
        query.setParameter("name", "Soda");
        query.executeUpdate();
        transaction.commit();*/
        //-------------update через метод-----------------
        for (var item :
                compDao.selectCompositions()) {
            if (item.getName_composition().equals("Soda")) {
                item.setDuration_composition(10);
                compDao.updateComposition(item);
                break;
            }
        }
    }
}
