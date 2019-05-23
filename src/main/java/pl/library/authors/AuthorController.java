package pl.library.authors;

import pl.library.EntityManagerCreator;
import pl.library.users.User;

import javax.persistence.EntityManager;
import java.util.List;

public class AuthorController {

    /**
     * Method which adds new Author to MySQL Database.
     * @param name
     * @param lastName
     */
    public void createAuthorInDB(String name,String lastName){
        if (checkIfAuthorExist(name,lastName)){
            System.err.println("Author already exist!");
        }
        else {
            EntityManager entityManager = EntityManagerCreator.getEntityManager();
            Author author = new Author(name,lastName);
            entityManager.getTransaction().begin();
            entityManager.persist(author);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    /**
     * Method which gets Author from MySQL database.
     * @param name
     * @param lastName
     * @return Author object
     */
    public Author getAuthor(String name, String lastName){
        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        Author author = entityManager.createQuery("select a from Author a where a.name='" + name + "' and a.lastName='" + lastName + "'", Author.class)
                .getSingleResult();
        entityManager.close();
        return author;
    }

    public boolean checkIfAuthorExist(String name, String lastName){
        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        List<Author> resultList = entityManager.createQuery("select a from Author a where a.name='" + name + "'and a.lastName='" + lastName + "'", Author.class)
                .getResultList();
        if (resultList.size()==0){
            return false;
        }
        else return true;
    }


}
