package entities;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Musician")
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_for_mus")
    @SequenceGenerator(name = "id_for_mus", sequenceName = "id_for_musician",allocationSize = 1)
    @Column(nullable = false)
    private int id_musician;
    @Column(nullable = false,length = 50)
    private String name_musician;
    @OneToMany(mappedBy = "id_musician_fk",cascade = CascadeType.ALL)
    private List<Album> albMusList;

    public Musician() {
    }

    public Musician(String name_musician) {
        this.name_musician = name_musician;
        this.albMusList = new ArrayList<>();
    }

    public int getId_musician() {
        return id_musician;
    }

    public String getName_musician() {
        return name_musician;
    }

    public void setName_musician(String name_musician) {
        this.name_musician = name_musician;
    }

    public List<Album> getAlbMusList() {
        return albMusList;
    }

    public void setAlbMusList(List<Album> compAlList) {
        this.albMusList = compAlList;
    }

    @Override
    public String toString() {
        return "Musician{" +
                "id_musician=" + id_musician +
                ", name_musician=" + name_musician +
                '}';
    }
    public void  addAlbum(Album album)
    {
        album.setId_musician_fk(this);
        albMusList.add(album);
    }
    public void removeAlbum(Album album)
    {
        albMusList.remove(album);
    }
}

