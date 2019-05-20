package pl.library.authors;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.library.books.Book;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    private String lastName;

    @OneToOne(mappedBy = "author",fetch = FetchType.LAZY)
    private Book book;

    public Author(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
