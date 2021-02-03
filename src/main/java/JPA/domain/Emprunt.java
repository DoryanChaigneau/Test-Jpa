package JPA.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

    public Emprunt() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "DATE_DEBUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_debut;

    @Column(name = "DATE_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date_fin;

    @Column(name = "DELAI")
    private int delai;

    @Column(name = "ID_CLIENT")
    private int id_client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
}
