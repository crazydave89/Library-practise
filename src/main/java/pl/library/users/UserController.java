package pl.library.users;

import pl.library.EntityManagerCreator;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class UserController {

    /**
     * Method which creates new User and adds him to MySQL database.
     * @param name
     * @param lastName
     * @param email
     * @param password
     * @param login
     */
    public void createUserInDB(String name,String lastName,String email,String password,String login){
        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        if (checkIfUserExist(email, login)){
            System.err.println("User with that email or login already exist!");
        }
        else {
            User user = new User(name,lastName,email,password,login, LocalDateTime.now());
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
    }

    /**
     * Method which check if user exist in MySQL database.
     * @param email
     * @param login
     * @return true - exist, false - not exist
     */
    public boolean checkIfUserExist(String email, String login){
        EntityManager entityManager = EntityManagerCreator.getEntityManager();
        List<User> resultList = entityManager.createQuery("select u from User u where u.email='" + email + "'or u.login='" + login + "'", User.class)
                .getResultList();
        if (resultList.size()==0){
            return false;
        }
        else return true;
    }


}