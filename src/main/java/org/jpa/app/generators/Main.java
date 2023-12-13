package org.jpa.app.generators;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.jpa.app.compositeKeys.config.CustomPUInfo;
import org.jpa.app.generators.config.GeneratorPUInfo;
import org.jpa.app.generators.entities.Product;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        var emf = new HibernatePersistenceProvider().createContainerEntityManagerFactory(new GeneratorPUInfo(), new HashMap<>());
        var em = emf.createEntityManager();
        var tx = em.getTransaction();

        tx.begin();


        /*Product p1 = new Product();
        p1.setName("product-1");

        em.persist(p1);*/

        Product product = em.createQuery("SELECT p from Product p", Product.class).getSingleResult();
        System.out.println(product);

        tx.commit();
        em.close();
        emf.close();
    }
}
