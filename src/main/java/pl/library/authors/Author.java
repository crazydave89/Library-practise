package pl.library.authors;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.library.books.Book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Book> bookList = new ArrayList<>();

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
