package JPA.Test;

import JPA.domain.Emprunt;
import JPA.domain.Livre;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class TestBibliotheque {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager em = emf.createEntityManager();

        Livre l1 = em.find(Livre.class, 2);
        System.out.println(l1.toString());

        List<Livre> liste = null;
        liste = em.createQuery("FROM Livre", Livre.class).getResultList();
        System.out.println(liste.toString());

        List<Emprunt> liste2 = null;
        liste2 = em.createQuery("FROM Emprunt WHERE client.id = 2", Emprunt.class).getResultList();
        System.out.println(liste2.toString());

        em.getTransaction().commit();
        em.close();
    }
}
