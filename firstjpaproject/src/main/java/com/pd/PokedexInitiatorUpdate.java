package com.pd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PokedexInitiatorUpdate {

    public static void main(String[] args) {
        EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("Prajwal");

        EntityManager entitymanager = entitymanagerfactory.createEntityManager();

        EntityTransaction entitytransaction = entitymanager.getTransaction();

        Pokemon p = entitymanager.find(Pokemon.class, "pikachu");

        if (p != null) {
            p.setPower(200);

            entitytransaction.begin();
            entitymanager.persist(p);
            entitytransaction.commit();
        }
        else{
            System.out.println("Entry Does not exist ");
        }
    }
}
