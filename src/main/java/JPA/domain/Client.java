package JPA.domain;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
public class Client {

    public Client() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NOM")
    private String nom;

    @Column(name = "PRENOM")
    private String prenom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}