package org.jpa.app.queries;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.queries.config.PersistenceConfig;
import org.jpa.app.queries.entities.Product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Map<String, String> props = new HashMap<>();
        props.put("jakarta.persistence.schema-generation.database.action", "none");

        var emf = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(new PersistenceConfig("jpa-queries"), props);
        var em = emf.createEntityManager();
        var eTx = em.getTransaction();

        eTx.begin();

        IntStream.rangeClosed(1, 6)
                .forEach(number -> {
                    var p1 = new Product();
                    p1.setName("product-" + number);
                    p1.setPrice(BigDecimal.valueOf(Math.random() * 10));

                    em.persist(p1);
                });
        /*String jpql = """
                SELECT p from Product p
                """;

        Query q = em.createQuery(jpql);
        q.getResultList().forEach(o -> {
            System.out.println(o);
        });*/

        /*String jpql = """
                SELECT p FROM Product p 
                WHERE p.price > 5
                """;
        TypedQuery<Product> query = em.createQuery(jpql, Product.class);
        query.getResultList().forEach(product -> {
            System.out.println(product);
        });*/

        /*String jpql = """
                SELECT p FROM Product p
                WHERE p.name LIKE '%product-1%'
                """;
        em.createQuery(jpql, Product.class)
                .getResultList()
                .forEach(System.out::println);*/

        eTx.commit();

        em.close();
        emf.close();
    }
}
