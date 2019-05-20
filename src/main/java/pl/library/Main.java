package pl.library;

import pl.library.authors.Author;
import pl.library.books.Book;
import pl.library.books.BookType;
import pl.library.users.User;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        User user = new User("name","lastName","email","password","login", LocalDateTime.now());
        Author author = new Author("autor1","lastNameAAA");
        Book book = new Book("tytul",author, LocalDate.now(),"publisher", BookType.PHANTASY,300);
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}
