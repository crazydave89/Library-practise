package pl.library.users;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.library.books.Book;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String login;
    private LocalDateTime registryDate;

    @OneToMany (mappedBy = "user", cascade = CascadeType.ALL)
    List<Book> bookList = new ArrayList<>();


    public User(String name, String lastName, String email, String password, String login, LocalDateTime registryDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.login = login;
        this.registryDate = registryDate;
    }

    public User(String name, String lastName, String email, String password, String login) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.login = login;
    }
}
