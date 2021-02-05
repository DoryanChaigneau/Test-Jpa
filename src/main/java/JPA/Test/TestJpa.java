package JPA.Test;

import JPA.domain.Livre;

import javax.persistence.*;

public class TestJpa {

    public static void main(String[] args) {
        searchLivre();
        //addLivre();
        //modifyLivre();
        //JPQLextraireTitre();
        //JPQLextraireAuteur();
        //deleteLivre();
        //allLivres();
    }

    public static void searchLivre() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Livre livre = entityManager.find(Livre.class,1);
        System.out.println(livre.getTitre());
    }

    public static void addLivre() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Livre addLivre = new Livre();
        addLivre.setAuteur("Doryan");
        addLivre.setTitre("Le titre du livre");
        entityManager.persist(addLivre);
        entityTransaction.commit();
        entityManager.close();
    }

    public static void modifyLivre() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Livre livre = entityManager.find(Livre.class,5);
        livre.setTitre(livre.getTitre());
        livre.setTitre("Du plaisir dans la cuisine");
        entityManager.merge(livre);
        entityTransaction.commit();
        entityManager.close();
    }

    public static void JPQLextraireTitre() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        TypedQuery<Livre> query = entityManager.createQuery("select l from Livre l where l.titre='Du plaisir dans la cuisine'", Livre.class);
        Livre livre = query.getResultList().get(0);
        System.out.println(livre.getTitre() + " : " + livre.getAuteur());
    }

    public static void JPQLextraireAuteur() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        TypedQuery<Livre> query = entityManager.createQuery("select l from Livre l where l.auteur='Jean-Pierre Coffe'", Livre.class);
        Livre livre = query.getResultList().get(0);
        System.out.println(livre.getTitre() + " : " + livre.getAuteur());
    }

    public static void deleteLivre() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        Livre livre = entityManager.find(Livre.class,6);
        entityManager.remove(livre);
        entityTransaction.commit();
        entityManager.close();
    }

    public static void allLivres() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu-dc");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        System.out.println(entityManager.createQuery("select l from Livre l", Livre.class).getResultList());
    }
}
