package pl.mariuszczarny.jpaprovider;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class MainApp {
	private static EntityManager entityManager;
	
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("ProjectPU");
        entityManager = entityManagerFactory.createEntityManager();
 
        createEmployee(1, "Mariusz", "Czarny", "Powstańców Śląskich 8, Wrocław");
    }
 
    private static void createEmployee(int id, String firstName,
            String lastName, String address) {
        entityManager.getTransaction().begin();
        MyUser user = new MyUser(id, firstName, lastName, address);
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
