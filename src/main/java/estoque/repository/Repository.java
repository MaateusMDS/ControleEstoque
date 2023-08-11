package estoque.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public abstract class Repository {

    public static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("maria-db");
    public static final EntityManager manager = factory.createEntityManager();

}
