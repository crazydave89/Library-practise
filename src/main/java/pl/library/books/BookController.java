package pl.library.books;

import pl.library.EntityManagerCreator;
import pl.library.authors.Author;
import pl.library.users.User;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class BookController {

    /**
     * Method which creates new Book and adds it to MySQL database.
     * @param title
     * @param author
     * @param realeseDate
     * @param publisher
     * @param bookType
     * @param numberOfPages
     * @param borrowedTime
     * @param user
     */
    public void createBookInDB(String title, Author author, LocalDate realeseDate, String publisher, BookType bookType, int numberOfPages, LocalDate borrowedTime, User user){
        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        Book book= new Book(title,author,realeseDate,publisher,bookType,numberOfPages,null,null);
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
