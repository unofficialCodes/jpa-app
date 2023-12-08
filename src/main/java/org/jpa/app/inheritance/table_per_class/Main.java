package org.jpa.app.inheritance.table_per_class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.inheritance.table_per_class.config.CustomPersistenceUnitInfo;
import org.jpa.app.inheritance.table_per_class.entities.Book;
import org.jpa.app.inheritance.table_per_class.entities.ElectronicDevice;
import org.jpa.app.inheritance.table_per_class.entities.Product;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new CustomPersistenceUnitInfo("table-per-class"), new HashMap<>());
        EntityManager em = emf.createEntityManager();
        EntityTransaction eTx = em.getTransaction();

        eTx.begin();

        Book book = new Book();
        book.setId(1L);
        book.setAuthor("author-1");

        ElectronicDevice device = new ElectronicDevice();
        device.setId(2L);
        device.setVoltage(200);

        em.persist(book);
        em.persist(device);

        var query = "SELECT p from Product p";
        em.createQuery(query, Product.class)
                .getResultList()
                .forEach(System.out::println);

        var bookQuery = "SELECT b from Book b";
        em.createQuery(bookQuery, Book.class)
                .getResultList()
                .forEach(System.out::println);

        eTx.commit();

        em.close();
        emf.close();
    }
}
