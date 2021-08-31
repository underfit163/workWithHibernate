package entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_for_al")
    @SequenceGenerator(name = "id_for_al", sequenceName = "id_for_album", allocationSize = 1)
    @Column(nullable = false)
    private int id_album;
    @Column(nullable = false, length = 30)
    private String name_album;
    @Column(length = 30)
    private String genre_album;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_musician")
    private Musician id_musician_fk;
    @OneToMany(mappedBy = "id_album_fk", cascade = CascadeType.ALL)
    private List<Composition> compAlList;

    public Album() {
    }

    public Album(String name_album, String genre_album) {
        this.name_album = name_album;
        this.genre_album = genre_album;
        this.compAlList = new ArrayList<>();
    }

    public int getId_album() {
        return id_album;
    }

    public String getName_album() {
        return name_album;
    }

    public void setName_album(String name_album) {
        this.name_album = name_album;
    }

    public String getGenre_album() {
        return genre_album;
    }

    public void setGenre_album(String genre_album) {
        this.genre_album = genre_album;
    }

    public Musician getId_musician_fk() {
        return id_musician_fk;
    }

    public void setId_musician_fk(Musician id_musician_fk) {
        this.id_musician_fk = id_musician_fk;
    }

    public List<Composition> getCompAlList() {
        return compAlList;
    }

    public void setCompAlList(List<Composition> compAlList) {
        this.compAlList = compAlList;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id_album=" + id_album +
                ", name_album=" + name_album +
                ", genre_album=" + genre_album +
                '}';
    }

    public void addComposition(Composition composition) {
        composition.setId_album_fk(this);
        compAlList.add(composition);
    }

    public void removeComposition(Composition composition) {
        compAlList.remove(composition);
    }
}
