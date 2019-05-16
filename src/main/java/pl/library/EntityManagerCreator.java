package pl.library;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerCreator {

    public static EntityManager getEntityManager(){
        EntityManagerFactory test2 = Persistence.createEntityManagerFactory("test");
        return test2.createEntityManager();
    }
}
