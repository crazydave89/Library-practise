package pl.library;


import pl.library.authors.AuthorController;
import pl.library.users.UserController;

public class Main {

    public static void main(String[] args) {

        UserController userController = new UserController();
        AuthorController authorController = new AuthorController();
        authorController.createAuthorInDB("Adam","Okrasa");
        //userController.createUserInDB("Dawid","Kamasz","dawid.kamasz@gmail.com","password","crazydave89");

    }
}
