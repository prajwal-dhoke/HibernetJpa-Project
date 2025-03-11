package com.pd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PokedexInitiatorDelete {

    public static void main(String[] args) {
        EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("Prajwal");

        EntityManager entitymanager = entitymanagerfactory.createEntityManager();

        EntityTransaction entitytransaction = entitymanager.getTransaction();

        Pokemon p = entitymanager.find(Pokemon.class, "Myouth");

        if(p != null){
            entitytransaction.begin();
            entitymanager.remove(p);
            entitytransaction.commit();
        }
        else{
            System.out.println("Pokemon Not Found");
        }
    }
}
