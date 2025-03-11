package com.pd;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PokedexInitiatorRead {

    public static void main(String[] args) {

        EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("Prajwal");

        EntityManager entitymanager = entitymanagerfactory.createEntityManager();

       Pokemon p = entitymanager.find(Pokemon.class, "pikachu");

       System.out.println(p);
    }
}
