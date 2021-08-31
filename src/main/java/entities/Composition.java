package entities;

import javax.persistence.*;

@Entity
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "id_for_comp")
    @SequenceGenerator(name = "id_for_comp", sequenceName = "id_for_composition",allocationSize = 1)
    @Column(nullable = false)
    private int id_composition;
    @Column(nullable = false,length = 30)
    private String name_composition;
    @Column(nullable = false)
    private float duration_composition;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_album")
    private Album id_album_fk;

    public Composition() {
    }

    public Composition(String name_composition, float duration_composition) {
        this.name_composition = name_composition;
        this.duration_composition = duration_composition;
    }

    public int getId_composition() {
        return id_composition;
    }

    public void setId_composition(int id_composition) {
        this.id_composition = id_composition;
    }

    public String getName_composition() {
        return name_composition;
    }

    public void setName_composition(String name_composition) {
        this.name_composition = name_composition;
    }

    public float getDuration_composition() {
        return duration_composition;
    }

    public void setDuration_composition(float duration_composition) {
        this.duration_composition = duration_composition;
    }

    public Album getId_album_fk() {
        return id_album_fk;
    }

    public void setId_album_fk(Album id_album_fk) {
        this.id_album_fk = id_album_fk;
    }

    @Override
    public String toString() {
        return "Composition{" +
                "id_composition=" + id_composition +
                ", name_composition=" + name_composition  +
                ", duration_composition=" + duration_composition +
                '}';
    }
}
