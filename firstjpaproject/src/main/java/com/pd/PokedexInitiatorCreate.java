package com.pd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PokedexInitiatorCreate {
    public static void main(String[] args) {
        Pokemon p1 = new Pokemon();

        p1.setName("pikachu");
        p1.setPower(100);
        p1.setType("Electric");
        p1.setColor(Color.YELLOW);

        Pokemon p2 = new Pokemon();
        p2.setName("Charazod");
        p2.setPower(500);
        p2.setType("Fire");
        p2.setColor(Color.ORANGE);

        Pokemon p3 = new Pokemon();
        p3.setName("Myouth");
        p3.setPower(50);
        p3.setType("cat");
        p3.setColor(Color.CREAM);

        EntityManagerFactory  entitymanagerfactory = Persistence.createEntityManagerFactory("Prajwal");

        EntityManager entitymanager = entitymanagerfactory.createEntityManager();

        EntityTransaction entitytransaction = entitymanager.getTransaction();

        entitytransaction.begin();
        entitymanager.persist(p1);
        entitymanager.persist(p2);
        entitymanager.persist(p3);
        entitytransaction.commit();
    }

}
