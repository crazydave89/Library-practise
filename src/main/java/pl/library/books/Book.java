package pl.library.books;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.library.authors.Author;
import pl.library.users.User;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String title;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    private LocalDate realeaseDate;
    private String publisher;
    @Enumerated(value = EnumType.STRING)
    private BookType bookType;
    private int numberOfPages;
    private LocalDate borrowedTime;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Book(String title, Author author, LocalDate realeaseDate, String publisher, BookType bookType, int numberOfPages, LocalDate borrowedTime, User user) {
        this.title = title;
        this.author = author;
        this.realeaseDate = realeaseDate;
        this.publisher = publisher;
        this.bookType = bookType;
        this.numberOfPages = numberOfPages;
        this.borrowedTime = borrowedTime;
        this.user = user;
    }

}
