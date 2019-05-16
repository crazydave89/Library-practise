package pl.library;

import pl.library.books.Book;
import pl.library.books.BookType;

import javax.persistence.EntityManager;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        Book book = new Book("tytul",null, LocalDate.now(),"publisher", BookType.PHANTASY,300);
        entityManager.persist(book);
    }

}
